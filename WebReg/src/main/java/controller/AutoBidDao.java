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
}
