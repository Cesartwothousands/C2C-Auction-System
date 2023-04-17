package controller;

import model.TableItem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class SearchDao extends Dao {

    public List<TableItem> get(String query) {
        Connection con = getConnection();
        String sql = "SELECT * FROM mydb.auction WHERE MATCH(name, description, type) AGAINST(? IN BOOLEAN MODE);";
        List<TableItem> tableItems = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, query);
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Integer id = rs.getInt("idItem");
                String name = rs.getString("name");
                Double initialPrice = rs.getDouble("initialPrice");
                Double increment = rs.getDouble("increment");
                Double currentPrice = rs.getDouble("currentPrice");
                Date endDate = rs.getDate("endDate");
                String endDateStr = endDate != null ? endDate.toString() : null;
                String description = rs.getString("description");
                String type = rs.getString("type");

                Integer sellerId = rs.getInt("seller");
                String sellerName = getSellerName(sellerId);

                Integer bidnumber = getBidCount(id);

                TableItem tableItem = new TableItem(id, name, initialPrice, currentPrice, increment, bidnumber,
                        endDateStr, description, sellerName, type);
                tableItems.add(tableItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableItems;
    }

    public Integer getBidCount(Integer itemId) {
        String sql = "SELECT COUNT(*) AS bid_count FROM mydb.bid WHERE idItem = ?";
        Integer bidCount = 0;
        Connection con = getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bidCount = rs.getInt("bid_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bidCount;
    }

    public String getSellerName(Integer sellerId) {
        String sql = "SELECT name FROM mydb.end_user WHERE idUser = ?";
        String sellerName = "";

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, sellerId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                sellerName = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sellerName;
    }

}
