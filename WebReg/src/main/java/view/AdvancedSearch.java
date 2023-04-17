package view;

import controller.AdvancedSearchDao;
import model.TableItem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

/**
 * Servlet implementation class Explore
 */
@WebServlet("/AdvancedSearch")
public class AdvancedSearch extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvancedSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String endDateString = request.getParameter("endDate");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date utilDate = null;
        if (endDateString != null && !endDateString.trim().isEmpty()) {
            try {
                utilDate = dateFormat.parse(endDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // Convert java.util.Date to java.sql.Date
        java.sql.Date endDate = null;
        if (utilDate != null) {
            endDate = new java.sql.Date(utilDate.getTime());
        }

        Double currentLowPrice = null;
        String currentLowPriceString = request.getParameter("currentLowPrice");
        if (currentLowPriceString != null && !currentLowPriceString.trim().isEmpty()) {
            currentLowPrice = Double.parseDouble(currentLowPriceString);
        }

        Double currentHighPrice = null;
        String currentHighPriceString = request.getParameter("currentHighPrice");
        if (currentHighPriceString != null && !currentHighPriceString.trim().isEmpty()) {
            currentHighPrice = Double.parseDouble(currentHighPriceString);
        }

        Double bidPrice = null;
        String bidPriceString = request.getParameter("bidPrice");
        if (bidPriceString != null && !bidPriceString.trim().isEmpty()) {
            bidPrice = Double.parseDouble(bidPriceString);
        }

        String itemType = request.getParameter("itemType");
        String propertyName = request.getParameter("propertyName");
        String sellerName = request.getParameter("sellerName");

        AdvancedSearchDao advancedSearchDao = new AdvancedSearchDao();
        List<TableItem> searchResults = advancedSearchDao.get(endDate, currentLowPrice, currentHighPrice, bidPrice,
                itemType, propertyName, sellerName);

        // Convert the tableItems list to JSON
        Gson gson = new Gson();
        String searchResultsJson = gson.toJson(searchResults);

        request.setAttribute("Ad-SearchTable", searchResultsJson);
        request.getRequestDispatcher("advanced_search.jsp").forward(request, response);
    }

}
