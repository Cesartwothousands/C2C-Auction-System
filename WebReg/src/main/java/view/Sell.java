package view;

import controller.ItemDao;
import controller.MemberDao;
import controller.PropertyDao;
import model.Member;
import model.Property;
import model.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
            HttpSession session=request.getSession(false);
            String type=(String)session.getAttribute("type");
            String itemName = request.getParameter("name");
            String initialPrice = request.getParameter("initial price");
            String enddate = request.getParameter("end date");
            String increment = request.getParameter("increment");
            String minimumPrice = request.getParameter("minimum price");
            String description = request.getParameter("description");
            int count=1;
            List<Property> properties=new ArrayList<>();
            while(request.getParameter("property"+count)!=null){
                String property = request.getParameter("property"+count);
                String descriptionProperty = request.getParameter("description"+count);
                properties.add(new Property(property, new Type(type), descriptionProperty));
                System.out.println("property"+count+": "+property+" description: "+descriptionProperty);
                count++;
            }
            Member member=(Member)session.getAttribute("member");
            int memberid=new MemberDao().getMemberId(member);
            new ItemDao().insertItem(itemName, Date.valueOf(enddate), Double.parseDouble(initialPrice), Double.parseDouble(increment), Double.parseDouble(minimumPrice), description, memberid,type, properties);
            System.out.println("itemName: "+itemName+" type: "+type+" initialPrice: "+initialPrice+" enddate: "+enddate+" increment: "+increment+" minimumPrice: "+minimumPrice+" description: "+description);
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
            HttpSession session=request.getSession(false);
            session.setAttribute("type", type);
            request.setAttribute("propertylist", typeToProperty);
            request.getRequestDispatcher("sell.jsp").forward(request, response);
        }

    }
}