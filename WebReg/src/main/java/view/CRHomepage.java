package view;

import controller.CRHomepageDao;

import model.CustomerRep;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Explore
 */
@WebServlet("/CRHomepage")
public class CRHomepage extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.sendRedirect("CRhomepage.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        CustomerRep c = (CustomerRep) session.getAttribute("CustomerRep");
        CRHomepageDao dao = new CRHomepageDao();

        String result = null;

        if (c != null) {
            String action = request.getParameter("action");

            if ("updateUser".equals(action)) {
                Integer idUser = Integer.parseInt(request.getParameter("idUser1"));
                String newname = request.getParameter("newname");
                String newpassword = request.getParameter("newpassword");
                result = dao.setUser(idUser, newname, newpassword);

            } else if ("deleteBids".equals(action)) {
                Integer idItem = Integer.parseInt(request.getParameter("idItem"));
                Integer idUser = Integer.parseInt(request.getParameter("idUser2"));
                Double price = Double.parseDouble(request.getParameter("price"));
                result = dao.deleteBids(idItem, idUser, price);

            } else if ("deleteAuction".equals(action)) {
                Integer idItem = Integer.parseInt(request.getParameter("idItem2"));
                result = dao.deleteAuction(idItem);
            }
        }
        System.out.println(result);
        request.setAttribute("result", result);
        request.getRequestDispatcher("CRhomepage.jsp").forward(request, response);
    }

}
