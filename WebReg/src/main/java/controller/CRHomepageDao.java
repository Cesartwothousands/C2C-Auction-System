package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class CRHomepageDao extends Dao {

    public String setUser(Integer idUser, String newname, String newpassword) {
        String result = "Success";
        if (newname == null && newpassword == null) {
            return result; // No updates needed if both newname and newpassword are null
        }

        StringBuilder sql = new StringBuilder("UPDATE mydb.end_user SET ");

        if (newname != null) {
            sql.append("name = ?");
        }

        if (newname != null && newpassword != null) {
            sql.append(", ");
        }

        if (newpassword != null) {
            sql.append("password = ?");
        }

        sql.append(" WHERE idUser = ?;");

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql.toString())) {

            int parameterIndex = 1;

            if (newname != null) {
                ps.setString(parameterIndex++, newname);
            }

            if (newpassword != null) {
                ps.setString(parameterIndex++, newpassword);
            }

            ps.setInt(parameterIndex, idUser);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Error";
        }
        return result;
    }

    public String deleteBids(Integer idItem, Integer idUser, Double price) {
        String sql = "DELETE FROM mydb.bid WHERE idItem = ? AND idUser = ? AND price = ?;";
        String result;

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idItem);
            ps.setInt(2, idUser);
            ps.setDouble(3, price);

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                result = "Error";
            } else {
                result = "Sucess";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Error";
        }

        return result;
    }

    public String deleteAuction(Integer idItem) {
        String sql = "DELETE FROM mydb.auction WHERE idItem = ?;";
        String result;

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idItem);

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                result = "Error";
            } else {
                result = "Sucess";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Error";
        }

        return result;
    }

}
