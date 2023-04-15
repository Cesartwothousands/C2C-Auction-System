package controller;

import model.TableItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BargainDao extends Dao{
    public BargainDao(){
        super();
    }

    public String update(int increment, int id){
        String result;

        Connection con = getConnection();
        String sql = "UPDATE mydb.auction SET increment = ? WHERE idItem = ?";

        result="Data Updated Successfully";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, increment);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            result="Data Update Failed!";
            e.printStackTrace();
        }
        return result;
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
                Double finalPrice = initialPrice+rs.getDouble("increment");
                Date endDate = rs.getDate("endDate");
                String description = rs.getString("description");
                TableItem tableItem = new TableItem(name, initialPrice, finalPrice, endDate, description);
                tableItems.add(tableItem);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tableItems;
    }
}
