package controller;

import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class RegisterDao extends Dao{
    public RegisterDao() {
        super();
    }

    public String insert(Member member) {
        String result;

        // Check if the username is taken
        if (isUsernameTaken(member.getEmail())) {
            result = "Email has been registered!";
            return result;
        }

        Connection con = getConnection();
        String sql = "INSERT INTO mydb.end_user (name,password,email) values(?,?,?) ";

        result="Data Entered Successfully";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, member.getUname());
            ps.setString(2, member.getPassword());
            ps.setString(3, member.getEmail());

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            result="Data Not Entered Successfully";
            e.printStackTrace();
        }
        return result;
    }

    private boolean isUsernameTaken(String email) {
        String sql = "SELECT COUNT(*) FROM mydb.end_user WHERE email = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}