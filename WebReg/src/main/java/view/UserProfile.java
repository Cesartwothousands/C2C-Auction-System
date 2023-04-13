package view;

import controller.AlertDao;
import controller.AutoBidDao;
import controller.BidDao;
import controller.RegisterDao;
import model.Alert;
import model.AutoBid;
import model.Bid;
import model.Member;

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
        request.setAttribute("alerts", alerts);
        request.setAttribute("autoBids", autoBids);
        request.setAttribute("bids", bids);
        request.getRequestDispatcher("user_profile.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Member n=(Member)session.getAttribute("Member");
        request.setAttribute("name", n.getUname());
        request.getRequestDispatcher("user_profile.jsp").forward(request, response);
    }
}
