package controller;

import model.TableItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExploreDao extends Dao{

    public ExploreDao() {
        super();
    }

    public List<TableItem> get() {
        List<TableItem> tableItems = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM mydb.auction ORDER BY endDate ASC LIMIT 25";

        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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
