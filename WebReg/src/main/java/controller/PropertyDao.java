package controller;

import model.Property;
import model.Type;

import java.sql.*;
import java.util.ArrayList;
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
    public Property getAlertProperty(int idAlert, int idProperty){
        Connection con = getConnection();
        String sql = "select * from mydb.property where idproperty=?";
        String sqlproperty = "select * from mydb.alertproperty where idalert=? and idproperty=?";
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
            ps2.setInt(1, idAlert);
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
    public List<Property> getPropertyByAlert(int idAlert){
        Connection con = getConnection();
        String sql = "select * from mydb.property where idproperty=?";
        String sqlproperty = "select * from mydb.alertproperty where idalert=?";
        List<Property> result=new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sqlproperty);
            ps.setInt(1, idAlert);
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
}
