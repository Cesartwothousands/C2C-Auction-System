package controller;

import java.sql.*;
import model.Member;
public class LoginDao {
    private final DBConfig dbConfig=new DBConfig();

    public void loadDriver(String dbDriver)
    {
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

    public Member query(Member member) {
        String dbdriver = dbConfig.getDbdriver();
        loadDriver(dbdriver);
        Connection con = getConnection();
        String sql = "select name from mydb.end_user where email=? and password=?";
        Member result=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, member.getEmail());
            ps.setString(2, member.getPassword());
            ResultSet rs =ps.executeQuery();
            if(rs!=null&&rs.next()){
                //index start from 1
                member.setUname(rs.getString(1));
                result=member;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
