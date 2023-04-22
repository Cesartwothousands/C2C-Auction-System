package controller;

import model.CustomerRep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public CustomerRep getCustomerRep(String email, String password){
        Connection con = getConnection();
        String sql = "select * from mydb.representatives where email=? and password=?";
        CustomerRep result=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            if(rs!=null&&rs.next()){
                //index start from 1
                result=new CustomerRep(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
