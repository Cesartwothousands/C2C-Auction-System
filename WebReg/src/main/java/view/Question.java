package view;

import controller.QuestionDao;
import model.QuestionItem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        QuestionDao questionDao = new QuestionDao();
        List<QuestionItem> questionItems = questionDao.getAll();
        if ("query" != "") {
            questionItems = questionDao.get("query");
        }

        // Convert the tableItems list to JSON
        Gson gson = new Gson();
        String questionItemsJson = gson.toJson(questionItems);

        request.setAttribute("QuestionTable", questionItemsJson);
        request.getRequestDispatcher("report.jsp").forward(request, response);
    }
}
