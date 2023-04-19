package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RepDao extends Dao{
    public RepDao() {
        super();
    }
    public void createCustomerRep(String name,String email,String password){
        Connection con = getConnection();
        String sql = "insert into mydb.representatives (name,email,password) values(?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
