package view;


import com.google.gson.Gson;
import controller.WinnerDao;
import model.Member;
import model.Winner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/Winner")
public class GetWinner extends HttpServlet {

    public GetWinner(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WinnerDao winnerDao = new WinnerDao();
        // manual member for test
        // Member member = new Member("Gareth Bruce", "123456", "sb@gmail.com");
        HttpSession session = req.getSession(false);
        Member member = (Member)session.getAttribute("Member");
        List<Winner> winners =  winnerDao.get(member);

        //Convert the tableItems to JSON
        Gson gson = new Gson();
        String winnerJson = gson.toJson(winners);
        System.out.println(winnerJson);
        req.setAttribute("winnerJson", winnerJson);
        req.getRequestDispatcher("winner.jsp").forward(req, resp);
    }
}
