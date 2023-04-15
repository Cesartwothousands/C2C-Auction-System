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

public class ItemDao extends Dao{
    public Item getItem(int idItem){
        Connection con = getConnection();
        String sql = "select * from mydb.auction where idItem=?";
        Item result=null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idItem);
            ResultSet rs =ps.executeQuery();
            if(rs!=null&&rs.next()){
                //index start from 1
                int id=rs.getInt(1);
                String name=rs.getString(2);
                Date endDate=rs.getDate(3);
                Double initialPrice=rs.getDouble(4);
                Double increment=rs.getDouble(5);
                Double minimumPrice=rs.getDouble(6);
                String description=rs.getString(7);
                int memberId=rs.getInt(8);
                Type type=new Type(rs.getString(9));
                Member member=new MemberDao().getMember(memberId);
                List<Property> properties=new PropertyDao().getPropertyByItem(idItem);
                result=new Item(id,name,endDate,initialPrice,increment,minimumPrice,description,member,properties,type);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void insertItem(String name, Date endDate, Double initialPrice, Double increment, Double minimumPrice, String description, int seller, String type, List<Property> properties){
        Connection con = getConnection();
        String sql = "insert into mydb.auction (name,enddate,initialprice,increment,minimumprice,description,seller,type) values (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDate(2, endDate);
            ps.setDouble(3, initialPrice);
            ps.setDouble(4, increment);
            ps.setDouble(5, minimumPrice);
            ps.setString(6, description);
            ps.setInt(7, seller);
            ps.setString(8, type);
            ps.executeUpdate();
            //get the id of the item
            String sql2="select idItem from mydb.auction where name=? and enddate=? and initialprice=? and increment=? and minimumprice=? and description=? and seller=? and type=?";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, name);
            ps2.setDate(2, endDate);
            ps2.setDouble(3, initialPrice);
            ps2.setDouble(4, increment);
            ps2.setDouble(5, minimumPrice);
            ps2.setString(6, description);
            ps2.setInt(7, seller);
            ps2.setString(8, type);
            ResultSet rs =ps2.executeQuery();
            int idItem=0;
            if(rs!=null&&rs.next()){
                idItem=rs.getInt(1);
            }
            for(Property property:properties){
                new PropertyDao().insertProperty(idItem,property);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
