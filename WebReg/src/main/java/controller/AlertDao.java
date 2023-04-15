package controller;

import model.Alert;
import model.Member;
import model.Property;
import model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlertDao extends Dao{
    public AlertDao() {
        super();
    }

    public Alert getAlert(int idalert, int idUser){
        Connection con = getConnection();
        String sql = "select type from mydb.alert where idalert=? and idUser=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idalert);
            ps.setInt(2, idUser);
            ResultSet rs =ps.executeQuery();
            Member member=new MemberDao().getMember(idUser);
            if(rs!=null&&rs.next()){
                String itemName=rs.getString(3);
                return new Alert(idalert,member,itemName);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Alert> getAlertByMember(Member member){
        Connection con = getConnection();
        String sql = "select idUser from mydb.end_user where email=?";
        String sql2 = "select * from mydb.alert where idUser=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, member.getEmail());
            ResultSet rs =ps.executeQuery();
            int idUser=-1;
            if(rs!=null&&rs.next()){
                idUser=rs.getInt(1);
            }
            ps = con.prepareStatement(sql2);
            if(idUser==-1){
                return new ArrayList<>();
            }
            ps.setInt(1, idUser);
            rs =ps.executeQuery();
            List<Alert> alerts=new ArrayList<>();
            if(rs!=null){
                while(rs.next()){
                    int idalert=rs.getInt(1);
                    String itemName=rs.getString(3);
                    alerts.add(new Alert(idalert,member,itemName));
                }
            }
            return alerts;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public void insertAlert(String itemName,Member member){
        Connection con = getConnection();
        int memberID=new MemberDao().getMemberId(member);
        String sql = "INSERT INTO Alert (idUser,ItemName)\n" +
                "VALUES (?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, memberID);
            ps.setString(2, itemName);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
