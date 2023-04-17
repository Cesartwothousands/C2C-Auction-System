package controller;

import model.TableItem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AdvancedSearchDao extends Dao {

    public List<TableItem> get(
            Date endDate, Double currentLowPrice, Double currentHighPrice, Double bidPrice, String itemType,
            String propertyName, String sellerName) {
        Connection con = getConnection();
        List<TableItem> tableItems = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM mydb.auction AS a");

        if (endDate != null || currentLowPrice != null || currentHighPrice != null || bidPrice != null
                || itemType != null || propertyName != null || sellerName != null) {
            sql.append(" WHERE");
            List<String> conditions = new ArrayList<>();

            if (endDate != null) {
                conditions.add(" a.enddate <= ?");
            }
            if (currentLowPrice != null) {
                conditions.add(" a.initialprice >= ?");
            }
            if (currentHighPrice != null) {
                conditions.add(" a.initialprice <= ?");
            }
            if (bidPrice != null) {
                conditions.add(" EXISTS (SELECT 1 FROM mydb.bid AS b WHERE a.idItem = b.idItem AND b.price <= ?)");
            }
            if (itemType != null) {
                conditions.add(" a.type = ?");
            }
            if (propertyName != null) {
                conditions.add(
                        " EXISTS (SELECT 1 FROM mydb.itemProperty AS ip JOIN mydb.property AS p ON ip.idproperty = p.idproperty WHERE a.idItem = ip.idItem AND p.name = ?)");
            }
            if (sellerName != null) {
                conditions.add(" EXISTS (SELECT 1 FROM mydb.end_user AS u WHERE a.seller = u.idUser AND u.name = ?)");
            }

            sql.append(String.join(" AND", conditions));
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql.toString());

            int index = 1;
            if (endDate != null) {
                ps.setDate(index++, endDate);
            }
            if (currentLowPrice != null) {
                ps.setDouble(index++, currentLowPrice);
            }
            if (currentHighPrice != null) {
                ps.setDouble(index++, currentHighPrice);
            }
            if (bidPrice != null) {
                ps.setDouble(index++, bidPrice);
            }
            if (itemType != null) {
                ps.setString(index++, itemType);
            }
            if (propertyName != null) {
                ps.setString(index++, propertyName);
            }
            if (sellerName != null) {
                ps.setString(index++, sellerName);
            }

            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Integer id = rs.getInt("idItem");
                String name = rs.getString("name");
                Double initialPrice = rs.getDouble("initialPrice");
                Double increment = rs.getDouble("increment");
                Double currentPrice = rs.getDouble("currentPrice");
                Date endDate_2 = rs.getDate("endDate");
                String endDateStr = endDate != null ? endDate_2.toString() : null;
                String description = rs.getString("description");
                String type = rs.getString("type");

                Integer sellerId = rs.getInt("seller");
                String sellerName_2 = getSellerName(sellerId);

                Integer bidnumber = getBidCount(id);

                TableItem tableItem = new TableItem(id, name, initialPrice, currentPrice, increment, bidnumber,
                        endDateStr, description, sellerName_2, type);
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
