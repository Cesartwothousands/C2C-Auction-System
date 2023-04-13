package controller;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BidDao extends Dao{
    public List<Bid> getBidByUser(Member member){
        Connection con = getConnection();
        String sql = "select * from mydb.end_user where email=?";
        String sql2 = "select * from mydb.bid where idUser=?";
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
            List<Bid> bids=new ArrayList<>();
            if(rs!=null){
                while(rs.next()){
                    //index start from 1
                    int idItem=rs.getInt(1);
                    double price=rs.getDouble(3);
                    ItemDao itemDao=new ItemDao();
                    Item item=itemDao.getItem(idItem);
                    bids.add(new Bid(member,item,price));
                }
            }
            return bids;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
