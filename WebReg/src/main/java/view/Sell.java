package view;

import controller.PropertyDao;
import model.Member;
import model.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
        List<Type> types =new PropertyDao().getAllType();
        request.setAttribute("types", types);
        List<String> typeToProperty=new PropertyDao().getPropertyByType(types.get(0));
        request.setAttribute("propertylist", typeToProperty);
        request.getRequestDispatcher("sell.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("submitform") != null) {
            // Login form submitted. store to database
            System.out.println("submitform");
        }else{
            // type submitted, change the property list
            PropertyDao pdao=new PropertyDao();
            List<Type> types =pdao.getAllType();
            String type=request.getParameter("type");
            request.setAttribute("types", types);
            System.out.println("type: "+type);
            List<String> typeToProperty=pdao.getPropertyByType(new Type(type));
            System.out.println("property len: "+typeToProperty.size());
            request.setAttribute("propertylist", typeToProperty);
            request.getRequestDispatcher("sell.jsp").forward(request, response);
        }

    }
}