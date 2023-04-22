package controller;

import model.AutoBid;
import model.Bid;
import model.Item;
import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutoBidDao extends Dao{
    public List<AutoBid> getAutoBitByUser(Member member){
        Connection con = getConnection();
        String sql = "select * from mydb.end_user where email=?";
        String sql2 = "select * from mydb.autobid where idUser=?";
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
            List<AutoBid> bids=new ArrayList<>();
            if(rs!=null){
                while(rs.next()){
                    //index start from 1
                    int idItem=rs.getInt(1);
                    double upperlimit=rs.getDouble(3);
                    ItemDao itemDao=new ItemDao();
                    Item item=itemDao.getItem(idItem);
                    bids.add(new AutoBid(member,item,upperlimit));
                }
            }
            return bids;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public void createAutoBid(Member member, int itemId, double upperlimit){
        Connection con = getConnection();
        String sql = "insert into mydb.autobid (idUser,idItem,upperlimit) values(?,?,?) on duplicate key update upperlimit=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            int memberId=new MemberDao().getMemberId(member);
            ps.setInt(1,memberId);
            ps.setInt(2,itemId);
            ps.setDouble(3,upperlimit);
            ps.setDouble(4,upperlimit);
            ps.executeUpdate();
            updatePriceOnInsert(itemId,upperlimit);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //See if there exists several autobids for the same item
    //If so, change the item price
    // item price = min(max(second highest autobid, current price)+ increment,highest autobid)
    public void updatePriceOnInsert(int itemId,double upperlimit){
        Connection con = getConnection();
        String numberOfAutoBid = "select count(*) from mydb.autobid where idItem=?";
        try{
            PreparedStatement ps = con.prepareStatement(numberOfAutoBid);
            ps.setInt(1,itemId);
            ResultSet rs =ps.executeQuery();
            if(rs!=null&&rs.next()){
                int count=rs.getInt(1);
                if(count>1){
                    String twoHighestAutoBid = "select upperlimit from mydb.autobid where idItem=? order by upperlimit desc limit 2";
                    ps = con.prepareStatement(twoHighestAutoBid);
                    ps.setInt(1,itemId);
                    rs =ps.executeQuery();
                    boolean isHighest=true;
                    double highest=0;
                    double secondhighest=0;
                    while(rs!=null&&rs.next()){
                        if(isHighest){
                            highest=rs.getDouble(1);
                            isHighest=false;
                        }else {
                            secondhighest=rs.getDouble(1);
                        }
                    }
                    String increment = "select increment,currentPrice from mydb.auction where idItem=?";
                    ps = con.prepareStatement(increment);
                    ps.setInt(1,itemId);
                    rs =ps.executeQuery();
                    double incrementValue=0;
                    double currentPrice=0;
                    if(rs!=null&&rs.next()){
                        incrementValue=rs.getDouble(1);
                        currentPrice=rs.getDouble(2);
                    }
                    if(currentPrice+incrementValue>highest){
                        return;
                    }
                    double newPrice=Math.min(Math.max(secondhighest,currentPrice)+incrementValue,highest);
                    String update="update mydb.auction set currentPrice=? where idItem=?";
                    ps = con.prepareStatement(update);
                    ps.setDouble(1,newPrice);
                    ps.setInt(2,itemId);
                    ps.executeUpdate();
                }else{
                    //get the price now for the item and set the new price
                    // if currrent price + increment <= upperlimit, set the new price to current price + increment
                    // else do not change
                    //TODO: check if the user is updating the upperlimit, if so, do not change the price
                    String increment = "select increment,currentPrice from mydb.auction where idItem=?";
                    ps = con.prepareStatement(increment);
                    ps.setInt(1,itemId);
                    rs =ps.executeQuery();
                    double incrementValue=0;
                    double currentPrice=0;
                    if(rs!=null&&rs.next()){
                        incrementValue=rs.getDouble(1);
                        currentPrice=rs.getDouble(2);
                    }
                    if(currentPrice+incrementValue<=upperlimit){
                        String update="update mydb.auction set currentPrice=? where idItem=?";
                        ps = con.prepareStatement(update);
                        ps.setDouble(1,currentPrice+incrementValue);
                        ps.setInt(2,itemId);
                        ps.executeUpdate();
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
