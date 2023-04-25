package view;

import controller.*;
import model.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/User")
public class UserProfile extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Member n=(Member)session.getAttribute("Member");
        request.setAttribute("member", n);
        List<Alert> alerts=new AlertDao().getAlertByMember(n);
        List<AutoBid> autoBids=new AutoBidDao().getAutoBitByUser(n);
        List<Bid> bids=new BidDao().getBidByUser(n);
        List<Item> activeItems=new AlertDao().getActiveAlertByMember(n);
        List<Item> badBids=new AlertDao().getBadBidByMember(n);
        List<Item> badAutoBids=new AlertDao().getBadAutoBidByMember(n);
        //System.out.println("alerts len: " + alerts.size()+ " autoBids len: " + autoBids.size() + " bids len: " + bids.size());
        List<Winner> winners=new WinnerDao().get(n);
        request.setAttribute("alerts", alerts);
        request.setAttribute("autoBids", autoBids);
        request.setAttribute("bids", bids);
        request.setAttribute("activeItems", activeItems);
        request.setAttribute("badBids", badBids);
        request.setAttribute("badAutoBids", badAutoBids);
        request.setAttribute("winners", winners);
        request.getRequestDispatcher("user_profile.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Member n=(Member)session.getAttribute("Member");
        String itemName = request.getParameter("itemName");
        //System.out.println("itemName: "+itemName);
        new AlertDao().insertAlert(itemName,n);
        request.setAttribute("member", n);
        List<Alert> alerts=new AlertDao().getAlertByMember(n);
        List<AutoBid> autoBids=new AutoBidDao().getAutoBitByUser(n);
        List<Bid> bids=new BidDao().getBidByUser(n);
        List<Item> activeItems=new AlertDao().getActiveAlertByMember(n);
        List<Item> badBids=new AlertDao().getBadBidByMember(n);
        List<Item> badAutoBids=new AlertDao().getBadAutoBidByMember(n);
        List<Winner> winners=new WinnerDao().get(n);
        request.setAttribute("alerts", alerts);
        request.setAttribute("autoBids", autoBids);
        request.setAttribute("bids", bids);
        request.setAttribute("activeItems", activeItems);
        request.setAttribute("badBids", badBids);
        request.setAttribute("badAutoBids", badAutoBids);
        request.setAttribute("winners", winners);
        request.getRequestDispatcher("user_profile.jsp").forward(request, response);
    }
}
