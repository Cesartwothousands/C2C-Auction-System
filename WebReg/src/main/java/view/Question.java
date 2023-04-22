package view;

import controller.QuestionDao;
import model.QuestionItem;
import model.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * Servlet implementation class Explore
 */
@WebServlet("/Report")
public class Question extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String questionTitle = request.getParameter("questionTitle");
        String questionContent = request.getParameter("questionContent");

        HttpSession session = request.getSession(false);
        Member n = (Member) session.getAttribute("Member");

        Map<String, String> jsonResponse = new HashMap<>();

        if (n != null) {
            String Email = n.getEmail();

            if (questionTitle != null && questionContent != null) {
                QuestionDao questionDao = new QuestionDao();
                Integer idUser = questionDao.getIdUser(Email);

                questionDao.insertQuestion(questionTitle, questionContent, idUser);
                jsonResponse.put("status", "success");
                jsonResponse.put("message", "Question inserted successfully.");
            } else {
                jsonResponse.put("status", "error");
                jsonResponse.put("message", "Missing parameters.");
            }
        } else {
            jsonResponse.put("status", "error");
            jsonResponse.put("message", "User not found.");
        }

        Gson gson = new Gson();
        String json = gson.toJson(jsonResponse);

        request.setAttribute("resultJson", json);
        request.getRequestDispatcher("report.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        QuestionDao questionDao = new QuestionDao();
        List<QuestionItem> questionItems;

        String query = request.getParameter("query");

        if (query == null || query.isEmpty() || query.equals("")) {
            questionItems = questionDao.getAll();
        } else {
            questionItems = questionDao.get(query);
        }

        // Convert the tableItems list to JSON
        Gson gson = new Gson();
        String questionItemsJson = gson.toJson(questionItems);
        System.out.println("Generated JSON: " + questionItemsJson);

        request.setAttribute("QuestionTable", questionItemsJson);
        request.getRequestDispatcher("report.jsp").forward(request, response);
    }
}
