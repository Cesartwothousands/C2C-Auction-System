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
}
