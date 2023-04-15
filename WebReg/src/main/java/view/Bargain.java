package view;

import com.google.gson.Gson;
import controller.BargainDao;
import controller.ExploreDao;
import model.Item;
import model.TableItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(value = "/Bargain/{param}")
public class Bargain extends HttpServlet {

    List<TableItem> tableItemList;
    int increment;
    int id;
    BargainDao bargainDao;

    public Bargain() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session=request.getSession(false);

        // id = Integer.parseInt(getInitParameter("idItem"));
        // String pathInfo = request.getRequestURI(); // Get the pathInfo from the request
        // System.out.println(pathInfo);
        /**
         * adjust id manually
         */
        id = 2;
        /*if (pathInfo != null) {
            // id = pathInfo.charAt(1);
            id = 1;
        }*/

        bargainDao = new BargainDao();
        tableItemList = bargainDao.get(id);

        // Convert the tableItems list to JSON
        Gson gson = new Gson();
        String tableItemsJson = gson.toJson(tableItemList);

        request.setAttribute("tableItemsJson", tableItemsJson);
        request.getRequestDispatcher("bargain.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        increment = Integer.parseInt(request.getParameter("increment"));
        String result;

        double pre_incre = tableItemList.get(0).getFinalPrice() - tableItemList.get(0).getInitialPrice();
        if (increment <= pre_incre){
            result = "increment can't be less or equal initial increment!";
        }
        else{
            result = "Successful bidding!";
            bargainDao.update(increment, id);
        }
        response.getWriter().println(result);
    }

}
