package view;

import controller.SearchDao;
import model.Item;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Explore
 */
@WebServlet("/Search")
public class Search extends HttpServlet{
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String query = request.getParameter("query");
        SearchDao searchDao = new SearchDao();
        List<Item> searchResults = searchDao.searchItem(query);

        // Convert the tableItems list to JSON
        Gson gson = new Gson();
        String searchResultsJson = gson.toJson(searchResults);

        request.setAttribute("searchResultsJson", searchResultsJson);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}
