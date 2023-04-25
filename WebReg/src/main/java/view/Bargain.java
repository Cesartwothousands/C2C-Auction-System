package view;

import com.google.gson.Gson;
import controller.BargainDao;
import controller.ExploreDao;
import controller.HistoryDao;
import model.Item;
import model.Member;
import model.TableItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(value = "/Bargain/*")
public class Bargain extends HttpServlet {

    TableItem tableItem;
    int currentPrice;
    String itemid;
    BargainDao bargainDao;

    public Bargain() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        itemid = request.getPathInfo().split("/")[1];

        bargainDao = new BargainDao();
        tableItem = bargainDao.get(Integer.parseInt(itemid));
        List<TableItem> tableItems = new ArrayList<>();
        tableItems.add(tableItem);
        // Convert the tableItems list to JSON
        Gson gson = new Gson();
        String tableItemsJson = gson.toJson(tableItems);
        request.setAttribute("tableItemsJson", tableItemsJson);
        request.getRequestDispatcher("/bargain.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        Member member = (Member)session.getAttribute("Member");
        String email = member.getEmail();
        HistoryDao historyDao = new HistoryDao();
        int idUser = historyDao.getId(email);
        int bidPrice = Integer.parseInt(request.getParameter("bidPrice"));
        String result;

        double currentPrice = tableItem.getCurrentPrice();
        double increment = tableItem.getIncrement();
        if (bidPrice - currentPrice < increment){
            result = "increment can't be less than initial increment!";
        }
        else{
            result = "Successful bidding!";
            bargainDao.update(bidPrice, Integer.parseInt(itemid), idUser);
        }
        response.getWriter().println(result);
    }

}
