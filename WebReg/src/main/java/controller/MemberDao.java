package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Alert;
import model.Member;
public class MemberDao extends Dao{
    public MemberDao() {
        super();
    }

    public Member getMember(String email, String password){
        Connection con = getConnection();
        String sql = "select * from mydb.end_user where email=? and password=?";
        Member result=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            if(rs!=null&&rs.next()){
                //index start from 1
                result=new Member();
                result.setUname(rs.getString(2));
                result.setPassword(rs.getString(3));
                result.setEmail(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
    public Member getMember(int iduser ){
        Connection con = getConnection();
        String sql = "select * from mydb.end_user where iduser=?";
        Member result=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, iduser);
            ResultSet rs =ps.executeQuery();
            if(rs!=null&&rs.next()){
                //index start from 1
                result=new Member();
                result.setUname(rs.getString(2));
                result.setPassword(rs.getString(3));
                result.setEmail(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public int getMemberId(Member member){
        Connection con = getConnection();
        String sql = "select idUser from mydb.end_user where email=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, member.getEmail());
            ResultSet rs =ps.executeQuery();
            int idUser=-1;
            if(rs!=null&&rs.next()){
                idUser=rs.getInt(1);
            }
            return idUser;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
