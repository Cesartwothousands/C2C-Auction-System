package controller;

import model.TableItem;
import controller.AdvancedSearchDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BargainDao extends Dao{
    public BargainDao(){
        super();
    }

    public void update(double currentPrice, int id){
        // we need to both update users' history and currentPrice.
        Connection con = getConnection();
        String sql = "UPDATE mydb.auction SET currentPrice = ? WHERE idItem = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, currentPrice);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<TableItem> get(int id){
        List<TableItem> tableItems = new ArrayList<>();
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
                TableItem tableItem = new TableItem(id, name, initialPrice, currentPrice,
                        increment, bidnumber, endDate, description, seller, type);
                tableItems.add(tableItem);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tableItems;
    }
}
