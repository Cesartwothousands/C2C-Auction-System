package view;

import com.google.gson.Gson;
import controller.HistoryDao;
import model.Bid;
import model.HistoryBid;
import model.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/History/*")
public class History extends HttpServlet {

    public History(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idItem = req.getPathInfo().split("/")[1];
        HistoryDao historyDao = new HistoryDao();
        String type;
        type = req.getParameter("type");
        List<HistoryBid> bidItems;

        if (type == null){
            bidItems = historyDao.get(Integer.parseInt(idItem));
        }
        else{
            bidItems = historyDao.get(type);
        }

        // Convert the tableItems list to JSON
        Gson gson = new Gson();
        String historyJson = gson.toJson(bidItems);
        // System.out.println(historyJson);
        req.setAttribute("historyJson", historyJson);
        req.getRequestDispatcher("/history.jsp").forward(req, resp);
    }
}
