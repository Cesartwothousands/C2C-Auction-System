package view;

import controller.ExploreDao;
import model.TableItem;

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
@WebServlet("/Explore")
public class Explore extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Explore() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        ExploreDao exploreDao = new ExploreDao();
        List<TableItem> tableItems = exploreDao.get();

        // Convert the tableItems list to JSON
        Gson gson = new Gson();
        String tableItemsJson = gson.toJson(tableItems);

        request.setAttribute("ExploreTable", tableItemsJson);
        request.getRequestDispatcher("explore.jsp").forward(request, response);
    }

}
