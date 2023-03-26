

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname=request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");

        Member member=new Member(uname, password, email);
        RegisterDao rdao=new RegisterDao();
        String result;

        if(uname=="" || password=="" || email==""){
            result="Null values are not allowed!";
        }else if(uname.length()>16){
            result="Length of username should not longer than 16 characters!";
        }else if(password.length()<6){
            result="Length of username should not shorter than 6 characters!";
        }else{
            result=rdao.insert(member);
        }

        response.getWriter().println(result);
    }
}
