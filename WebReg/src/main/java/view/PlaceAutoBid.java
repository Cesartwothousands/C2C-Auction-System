package view;


import controller.AutoBidDao;
import model.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AutoBid/*")
public class PlaceAutoBid extends HttpServlet {
    public PlaceAutoBid() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value=request.getPathInfo().split("/")[1];
        HttpSession session=request.getSession(false);
        session.setAttribute("itemId",value);
        response.sendRedirect("/webreg/autobid.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Member n=(Member)session.getAttribute("Member");
        int itemId=Integer.parseInt((String) session.getAttribute("itemId"));
        double upperlimit=Double.parseDouble( request.getParameter("upperlimit"));
        new AutoBidDao().createAutoBid(n,itemId,upperlimit);
        response.sendRedirect("/webreg/explore.jsp");
    }
}
