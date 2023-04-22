package controller;

import model.Alert;
import model.Item;
import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class AdminDao extends Dao{
    public AdminDao() {
        super();
    }
    public void createCustomerRep(){

    }
    public HashMap<String,Double> earningsPerItem(){
        Connection con = getConnection();
        String sql = " select name,sum(currentprice) from (select * from mydb.auction where currentprice >= minimumprice and enddate>= CURDATE()) as t group by name;";
        HashMap<String,Double> result=new HashMap<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs!=null&&rs.next()){
                String itemName=rs.getString(1);
                Double price=rs.getDouble(2);
                result.put(itemName,price);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public HashMap<String,Double> earningsPerType(){
        Connection con = getConnection();
        String sql = " select type,sum(currentprice) from (select * from mydb.auction where currentprice >= minimumprice and enddate>= CURDATE()) as t group by type;";
        HashMap<String,Double> result=new HashMap<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs!=null&&rs.next()){
                String type=rs.getString(1);
                Double price=rs.getDouble(2);
                result.put(type,price);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
    public HashMap<String,Double> earningsPerSeller(){
        Connection con = getConnection();
        //seller is an int type foreign key to member table
        String sql = " select seller,sum(currentprice) from (select * from mydb.auction where currentprice >= minimumprice and enddate>= CURDATE()) as t group by seller;";
        HashMap<String,Double> result=new HashMap<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs!=null&&rs.next()){
                int sellerId=rs.getInt(1);
                Double price=rs.getDouble(2);
                String sellerName=new MemberDao().getMember(sellerId).getUname();
                result.put(sellerName,price);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public Double totalEarnings(){
        Connection con = getConnection();
        String sql = " select sum(currentprice) from (select * from mydb.auction where currentprice >= minimumprice and enddate>= CURDATE()) as t;";
        double result=0.0;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            if(rs!=null&&rs.next()){
                result=rs.getDouble(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public Item bestSellingItems(){
        Connection con = getConnection();
        String sql = "select idItem,max(cur_price) from " +
                "(select idItem,sum(currentprice) as cur_price from (select * from mydb.auction where currentprice >= minimumprice and enddate>= CURDATE()) as t group by idItem) as a group by idItem;";
        Item result=null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            if(rs!=null&&rs.next()){
                int item=rs.getInt(1);
                Double price=rs.getDouble(2);
                result=new ItemDao().getItem(item);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    //return a list with length 2, the first is the member object, the second is the total spending
    public List<Object> bestBuyer(){
        String selledItems="select idItem,currentPrice from mydb.auction where currentprice >= minimumprice and enddate>= CURDATE()";
        String buyerId="select idUser,price from mydb.bid join ("+selledItems+") as t on bid.idItem=t.idItem where bid.price=t.currentPrice";
        String buyerSpending="select A.idUser,sum(price) as price from mydb.end_user join ("+buyerId+") as A on end_user.idUser=A.idUser group by idUser";
        String bestBuyer="select idUser,max(price) from ("+buyerSpending+") as B group by idUser";
        Connection con = getConnection();
        List<Object> result=new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(bestBuyer);
            ResultSet rs =ps.executeQuery();
            if(rs!=null&&rs.next()){
                int id=rs.getInt(1);
                //want to return a tuple of id and name
                //java doesn't support tuple
                result.add(new MemberDao().getMember(id));
                result.add(rs.getDouble(2));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
