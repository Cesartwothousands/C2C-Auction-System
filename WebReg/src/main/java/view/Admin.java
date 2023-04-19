package view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AdminDao;
import model.Item;
import model.Member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
    public Admin() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDao adminDao = new AdminDao();
        HashMap<String, Double> itemEarnings = adminDao.earningsPerItem();
        HashMap<String, Double> typeEarnings = adminDao.earningsPerType();
        HashMap<String, Double> sellerEarnings = adminDao.earningsPerSeller();
        Double totalEarnings = adminDao.totalEarnings();
        Item item = adminDao.bestSellingItems();
        List<Object> result=adminDao.bestBuyer();
        Member bestBuyer=(Member)result.get(0);
        Double bestBuyerSpending=(Double)result.get(1);
        request.setAttribute("itemEarnings", itemEarnings);
        request.setAttribute("typeEarnings", typeEarnings);
        request.setAttribute("sellerEarnings", sellerEarnings);
        request.setAttribute("totalEarnings", totalEarnings);
        request.setAttribute("item", item);
        request.setAttribute("bestBuyer", bestBuyer);
        request.setAttribute("bestBuyerSpending", bestBuyerSpending);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
