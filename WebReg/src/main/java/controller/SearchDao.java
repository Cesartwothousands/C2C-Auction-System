package controller;

import model.Item;
import model.Member;
import model.Property;
import model.Type;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SearchDao extends Dao {

    public List<Item> searchItem(String query){
        Connection con = getConnection();
        String sql = "SELECT * FROM mydb.auction WHERE MATCH(name, description) AGAINST(? IN BOOLEAN MODE);";
        List<Item> searchResults = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, query);
            ResultSet rs =ps.executeQuery();

            while (rs!=null&&rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Date endDate = rs.getDate(3);
                Double initialPrice = rs.getDouble(4);
                Double increment = rs.getDouble(5);
                Double minimumPrice = rs.getDouble(6);
                String description = rs.getString(7);
                int memberId = rs.getInt(8);
                Type type = new Type(rs.getString(9));
                Member member = new MemberDao().getMember(memberId);
                List<Property> properties = new PropertyDao().getPropertyByItem(id);
                Item result = new Item(id, name, endDate, initialPrice, increment, minimumPrice, description, member, properties, type,initialPrice);

                searchResults.add(result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return searchResults;
    }

}
