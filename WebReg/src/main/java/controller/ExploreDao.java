package controller;

import model.TableItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExploreDao {
    private final DBConfig dbConfig=new DBConfig();

    public void loadDriver(String dbDriver){
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    dbConfig.getUrl(),
                    dbConfig.getUser(), dbConfig.getPassword());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

    public List<TableItem> get() {
        String dbdriver = dbConfig.getDbdriver();
        loadDriver(dbdriver);
        List<TableItem> tableItems = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM mydb.auction ORDER BY endDate ASC LIMIT 25";

        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                Double initialPrice = rs.getDouble("initialPrice");
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
