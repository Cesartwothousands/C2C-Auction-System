package view;

import com.google.gson.Gson;
import controller.HistoryDao;
import model.Bid;
import model.HistoryBid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/History")
public class History extends HttpServlet {

    public History(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = "mauris.vel@outlook.edu";
        HistoryDao historyDao = new HistoryDao();
        int idUser = historyDao.getId(email);
        List<HistoryBid> bidItems = historyDao.get(idUser);
        // Convert the tableItems list to JSON
        Gson gson = new Gson();
        String historyJson = gson.toJson(bidItems);
        System.out.println(historyJson);
        req.setAttribute("historyJson", historyJson);
        req.getRequestDispatcher("history.jsp").forward(req, resp);
    }
}
