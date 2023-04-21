package controller;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao extends Dao{
    public HistoryDao(){
        super();
    }

    public List<HistoryBid> get(int idUser){
        List<HistoryBid> bid = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM mydb.bid WHERE idUser = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()){
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bid;
    }

    public int getId(String email) {
        String sql = "SELECT idUser FROM mydb.end_user WHERE email = ?";
        int sellerName = -1;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                sellerName = rs.getInt("idUser");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sellerName;
    }
}
