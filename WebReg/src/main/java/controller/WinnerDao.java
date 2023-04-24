package controller;

import model.Winner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WinnerDao extends Dao{
    public WinnerDao(){
        super();
    }

    public List<Winner> get(){
        List<Winner> winnerList = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT a.idItem, a.name, e.name FROM mydb.auction a, mydb.end_user e, mydb.bid b " +
                "WHERE a.currentPrice <= a.minimumprice AND curdate() <= a.enddate " +
                "AND a.idItem = b.idItem AND b.idUser = e.idUser AND b.price = a.currentPrice";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()){
                int idItem = rs.getInt("idItem");
                String itemName = rs.getString("a.name");
                String userName = rs.getString("e.name");
                winnerList.add(new Winner(idItem, itemName, userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return winnerList;
    }
}
