package controller;

import model.*;

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
    public List<Item> getActiveAlertByMember(Member member){
        Connection con=getConnection();
        int userId=new MemberDao().getMemberId(member);
        String getAlert="select ItemName from mydb.alert where idUser=?";
        //An active alert is an alert that has the corresponding itemName in the auction table
        String getActiveAlert="select idItem from mydb.auction where name in ("+getAlert+")";
        List<Item> items=new ArrayList<>();
        try{
            PreparedStatement ps=con.prepareStatement(getActiveAlert);
            ps.setInt(1,userId);
            ResultSet rs=ps.executeQuery();
            while(rs!=null&&rs.next()){
                int id=rs.getInt(1);
                items.add(new ItemDao().getItem(id));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
    /**
     * return a list of the items that the user has bid on and the current price is higher than the bid price
     *
     * @param member The Member object
     * @return List<Item> The list of items match the requirement
     */
    public List<Item> getBadBidByMember(Member member){
        int memberId=new MemberDao().getMemberId(member);
        return getBadBidByMember(memberId);
    }
    /**
     * return a list of the items that the user has bid on and the current price is higher than the bid price
     *
     * @param memberId The id for user
     * @return List<Item> The list of items match the requirement
     */
    public List<Item> getBadBidByMember(int memberId){
        Connection con=getConnection();
        String memberItems="select idItem,currentPrice from mydb.auction where idItem in (select idItem from mydb.bid where idUser=?)";
        String getBadBid="select A.idItem from ("+memberItems+") as A join (select idItem,price from mydb.bid where idUser=?) as B on A.idItem=B.idItem where A.currentPrice>B.price";
        List<Item> items=new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(getBadBid);
            ps.setInt(1, memberId);
            ps.setInt(2, memberId);
            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                int id = rs.getInt(1);
                items.add(new ItemDao().getItem(id));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
    /**
     * return a list of the items that the user has auto bid on and the current price is higher than the upper limit
     *
     * @param member The Member object
     * @return List<Item> The list of items match the requirement
     */
    public List<Item> getBadAutoBidByMember(Member member){
        int memberId=new MemberDao().getMemberId(member);
        return getBadAutoBidByMember(memberId);
    }
    /**
     * return a list of the items that the user has auto bid on and the current price is higher than the upper limit
     *
     * @param memberId The id for user
     * @return List<Item> The list of items match the requirement
     */
    public List<Item> getBadAutoBidByMember(int memberId){
        Connection con=getConnection();
        String memberItems="select idItem,currentPrice from mydb.auction where idItem in (select idItem from mydb.autobid where idUser=?)";
        String getBadBid="select A.idItem from ("+memberItems+") as A join (select idItem,upperlimit from mydb.autobid where idUser=?) as B on A.idItem=B.idItem where A.currentPrice>B.upperlimit";
        List<Item> items=new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(getBadBid);
            ps.setInt(1, memberId);
            ps.setInt(2, memberId);
            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                int id = rs.getInt(1);
                items.add(new ItemDao().getItem(id));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
}
