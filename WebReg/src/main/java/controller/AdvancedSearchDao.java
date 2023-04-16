package controller;

import model.Item;
import model.Member;
import model.Property;
import model.Type;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchDao extends Dao {

    public List<Item> SearchByCriteria(
            Date endDate, Double currentLowPrice, Double currentHighPrice, Double bidPrice, String itemType, String propertyName, String sellerName) {
        Connection con = getConnection();
        List<Item> searchResults = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM mydb.auction AS a");

        if (endDate != null || currentLowPrice != null || currentHighPrice != null || bidPrice != null || itemType != null || propertyName != null || sellerName != null) {
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
                conditions.add(" EXISTS (SELECT 1 FROM mydb.itemProperty AS ip JOIN mydb.property AS p ON ip.idproperty = p.idproperty WHERE a.idItem = ip.idItem AND p.name = ?)");
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
                int idItem = rs.getInt("idItem");
                String name = rs.getString("name");
                Date enddate = rs.getDate("enddate");
                double initialprice = rs.getDouble("initialprice");
                double increment = rs.getDouble("increment");
                double minimumprice = rs.getDouble("minimumprice");
                String description = rs.getString("description");
                int seller = rs.getInt("seller");
                String type = rs.getString("type");

                Item item = new Item(idItem, name, enddate, initialprice, increment, minimumprice, description, seller, type);
                searchResults.add(item);
            }


        }catch (Exception e) {
            e.printStackTrace();
        }

        return searchResults;
    }

}
