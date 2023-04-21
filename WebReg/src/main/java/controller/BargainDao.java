package controller;

import model.TableItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BargainDao extends Dao{
    public BargainDao(){
        super();
    }

    public void update(double currentPrice, int id){
        // we need to both update users' bidding history and currentPrice.
        Connection con = getConnection();

        //TODO: Connect to the login page to get user's id.
        int idUser = 1;

        String sql1 = "INSERT INTO mydb.bid(idItem, idUser, Price)" +
                "VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, id);
            ps.setInt(2, idUser);
            ps.setDouble(3, currentPrice);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String sql2 = "UPDATE mydb.auction SET auction.currentPrice = " +
                "    (SELECT max(price) FROM mydb.bid " +
                "     WHERE mydb.bid.idItem = ? " +
                "     GROUP BY idItem) " +
                "    WHERE mydb.auction.idItem = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public TableItem get(int id){
        TableItem tableItem = null;
        Connection con = getConnection();
        String sql = "SELECT * FROM mydb.auction WHERE idItem = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String name = rs.getString("name");
                double initialPrice = rs.getDouble("initialPrice");
                double currentPrice = rs.getDouble("currentPrice");
                double increment = rs.getDouble("increment");
                AdvancedSearchDao advancedSearchDao = new AdvancedSearchDao();
                Integer bidnumber = advancedSearchDao.getBidCount(id);
                String endDate = String.valueOf(rs.getDate("endDate"));
                String description = rs.getString("description");
                String seller = rs.getString("seller");
                String type = rs.getString("type");
                tableItem = new TableItem(id, name, initialPrice, currentPrice,
                        increment, bidnumber, endDate, description, seller, type);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tableItem;
    }
}