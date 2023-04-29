package view;

import controller.MemberDao;
import controller.RepDao;
import model.CustomerRep;
import model.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CRLogin")
public class CRLogin extends HttpServlet {
    public CRLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.sendRedirect("crlogin.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String uid = request.getParameter("email");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        // String phone=request.getParameter("phone");
        RepDao rdao=new RepDao();
        CustomerRep result=rdao.getCustomerRep(email,password);
        if(result!=null){
            HttpSession session=request.getSession();
            session.setAttribute("CustomerRep",result);
            response.sendRedirect("CRHomepage");
        }else {
            response.getWriter().println("Not found");
        }
    }
}
