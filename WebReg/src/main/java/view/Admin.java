package view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.AdminDao;
import controller.RepDao;
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
        HttpSession session=request.getSession(false);

        if(session==null || session.getAttribute("verified")==null || !(boolean)session.getAttribute("verified")){
            response.sendRedirect("adminlogin.jsp");
            return;
        }

        AdminDao adminDao = new AdminDao();
        session=request.getSession(false);
        //check if the visitor is admin
        //Member n=(Member)session.getAttribute("Member");
        HashMap<String, Double> itemEarnings = adminDao.earningsPerItem();
        HashMap<String, Double> typeEarnings = adminDao.earningsPerType();
        HashMap<String, Double> sellerEarnings = adminDao.earningsPerSeller();
        Double totalEarnings = adminDao.totalEarnings();
        Item item = adminDao.bestSellingItems();
        List<Object> result=adminDao.bestBuyer();
        Member bestBuyer=null;
        Double bestBuyerSpending=null;
        if(result.size()>0){
            bestBuyer=(Member)result.get(0);
            bestBuyerSpending=(Double)result.get(1);
        }
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
        //check if the visitor is admin
        HttpSession session=request.getSession(false);
        //Member n=(Member)session.getAttribute("Member");
        String uname=request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        new RepDao().createCustomerRep(uname, email, password);
        response.getWriter().println("Customer Representative Created");
    }
}
