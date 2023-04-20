package controller;

import model.Property;
import model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PropertyDao extends Dao{
    public PropertyDao() {
        super();
    }

    public Property getProperty(int idItem, int idProperty){
        Connection con = getConnection();
        String sql = "select * from mydb.property where idproperty=?";
        String sqlproperty = "select * from mydb.itemProperty where idItem=? and idproperty=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProperty);
            ResultSet rs =ps.executeQuery();
            String name=null;
            Type type=null;
            if(rs!=null&&rs.next()){
                //index start from 1
                name=rs.getString(2);
                type=new Type(rs.getString(3));
            }
            if(name == null){
                return null;
            }
            PreparedStatement ps2 = con.prepareStatement(sqlproperty);
            ps2.setInt(1, idItem);
            ps2.setInt(2, idProperty);
            ResultSet rs2 =ps2.executeQuery();
            Property result=null;
            if(rs2!=null&&rs2.next()){
                //index start from 1
                result=new Property(name,type,rs2.getString(3));
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Property> getPropertyByItem(int idItem){
        Connection con = getConnection();
        String sql = "select * from mydb.property where idproperty=?";
        String sqlproperty = "select * from mydb.itemProperty where idItem=?";
        List<Property> result=new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sqlproperty);
            ps.setInt(1, idItem);
            ResultSet rs =ps.executeQuery();
            if(rs!=null&&rs.next()){
                //index start from 1
                int idProperty=rs.getInt(2);
                String description=rs.getString(3);
                PreparedStatement ps2 = con.prepareStatement(sql);
                ps2.setInt(1, idProperty);
                ResultSet rs2 =ps2.executeQuery();
                if(rs2!=null){
                    while(rs2.next()){
                        //index start from 1
                        Property property=new Property(rs2.getString(2),new Type(rs2.getString(3)),description);
                        result.add(property);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }



    // select distinct type from mydb.property;
    public List<Type> getAllType(){
        Connection con = getConnection();
        String sql = "select distinct type from mydb.property";
        List<Type> result=new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    //index start from 1
                    result.add(new Type(rs.getString(1)));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    // select property name by type
    public List<String> getPropertyByType(Type type){
        Connection con = getConnection();
        String sql = "select name from mydb.property where type=?";
        List<String> result=new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, type.getName());
            ResultSet rs =ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    //index start from 1
                    result.add(rs.getString(1));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public void insertProperty(int itemid,Property property){
        //get property id from mydb.property
        Connection con = getConnection();
        String sql = "select idproperty from mydb.property where name=? and type=?";
        String sql2 = "insert into mydb.itemProperty(idItem,idproperty,describtion) values(?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, property.getName());
            ps.setString(2, property.getType().getName());
            ResultSet rs =ps.executeQuery();
            int idProperty=-1;
            if(rs!=null&&rs.next()){
                //index start from 1
                idProperty=rs.getInt(1);
            }
            if(idProperty==-1){
                return;
            }
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, itemid);
            ps2.setInt(2, idProperty);
            ps2.setString(3, property.getValue());
            ps2.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
