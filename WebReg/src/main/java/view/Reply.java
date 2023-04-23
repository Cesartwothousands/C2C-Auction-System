package view;

import controller.QuestionDao;
import model.QuestionItem;
import model.CustomerRep;

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
@WebServlet("/Reply")
public class Reply extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reply() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer idQuestion = Integer.parseInt(request.getParameter("questionId"));
        String answerTitle = request.getParameter("answerTitle");
        String answerContent = request.getParameter("answerContent");

        HttpSession session = request.getSession(false);
        CustomerRep c = (CustomerRep) session.getAttribute("CustomerRep");

        Map<String, String> jsonResponse = new HashMap<>();

        if (c != null) {
            QuestionDao questionDao = new QuestionDao();
            questionDao.insertAnswer(idQuestion, answerTitle, answerContent);
            jsonResponse.put("status", "success");
            jsonResponse.put("message", "Answer inserted successfully.");
        } else {
            jsonResponse.put("status", "error");
            jsonResponse.put("message", "You don't have this permission.");
        }

        Gson gson = new Gson();
        String json = gson.toJson(jsonResponse);

        request.setAttribute("resultJson", json);
        request.getRequestDispatcher("Reply.jsp").forward(request, response);
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
        request.getRequestDispatcher("Reply.jsp").forward(request, response);
    }
}
