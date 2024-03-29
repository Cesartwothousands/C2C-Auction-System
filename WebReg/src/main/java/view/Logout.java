package view;

import model.CustomerRep;
import model.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session=request.getSession(false);
        Member n=(Member)session.getAttribute("Member");
        CustomerRep c=(CustomerRep)session.getAttribute("CustomerRep");
        if (n!=null)
            request.setAttribute("email", n.getEmail());
        else if (c!=null)
            request.setAttribute("email", c.getEmail());
        request.getRequestDispatcher("logout.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String uid = request.getParameter("email");
        HttpSession session=request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }
}