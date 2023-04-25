package view;

import controller.AdminDao;

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
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("adminlogin.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String uid = request.getParameter("email");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        // String phone=request.getParameter("phone");
        AdminDao rdao=new AdminDao();
        boolean verified=rdao.verify(email,password);
        if(verified){
            HttpSession session=request.getSession();
            session.setAttribute("verified",true);
            response.sendRedirect("Admin");
        }else {
            response.getWriter().println("Not found");
        }
    }
}