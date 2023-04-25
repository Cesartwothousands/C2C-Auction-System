package controller;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao extends Dao{
    public HistoryDao(){
        super();
    }

    public List<HistoryBid> get(int idItem){
        List<HistoryBid> bid = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM mydb.bid WHERE idItem = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idItem);
            getItem(bid, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bid;
    }

    public int getId(String email) {
        String sql = "SELECT idUser FROM mydb.end_user WHERE email = ?";
        int buyerName = -1;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                buyerName = rs.getInt("idUser");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return buyerName;
    }

    public List<HistoryBid> get(String type){
        List<HistoryBid> bid = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM mydb.bid WHERE idItem in (SELECT idItem FROM mydb.auction WHERE type = ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, type);
            getItem(bid, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bid;
    }

    private void getItem(List<HistoryBid> bid, PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        while (rs != null && rs.next()){
            int idUser = rs.getInt("idUser");
            int idItem = rs.getInt("idItem");
            double price = rs.getDouble("price");

            MemberDao memberDao = new MemberDao();
            Member member = memberDao.getMember(idUser);
            ItemDao itemDao = new ItemDao();
            Item item = itemDao.getItem(idItem);

            String userName = member.getUname();
            String itemName = item.getName();
            String itemType = item.getType().getName();
            String end_date = String.valueOf(item.getEndDate());
            String seller = item.getSeller().getUname();
            bid.add(new HistoryBid(userName, itemName, itemType,
                    price, end_date, seller));
        }
    }
}
