package view;

import controller.LoginDao;
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
@WebServlet("/Login")
public class Login extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.sendRedirect("login.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String uid = request.getParameter("email");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        // String phone=request.getParameter("phone");
        Member member=new Member(null, password, email);
        LoginDao rdao=new LoginDao();
        Member result=rdao.query(member);
        if(result!=null){
            HttpSession session=request.getSession();
            session.setAttribute("Member",result);
            response.sendRedirect("Logout");
        }else {
            response.getWriter().println("Not found");
        }
    }
}