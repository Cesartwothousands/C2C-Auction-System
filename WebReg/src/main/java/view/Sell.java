package view;

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
@WebServlet("/Sell")
public class Sell extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sell() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Member n=(Member)session.getAttribute("Member");
        request.setAttribute("name", n.getUname());
        request.getRequestDispatcher("sell.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Member n=(Member)session.getAttribute("Member");
        request.setAttribute("name", n.getUname());
        request.getRequestDispatcher("sell.jsp").forward(request, response);
    }
}