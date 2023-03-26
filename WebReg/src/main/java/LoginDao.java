import java.sql.*;

public class LoginDao {
    private String DB_password = "135790";

    public void loadDriver(String dbDriver)
    {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb",
                    "root", DB_password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

    public Member query(Member member) {
        String dbdriver = "com.mysql.jdbc.Driver";
        loadDriver(dbdriver);
        Connection con = getConnection();
        String sql = "select count(*) from 'mydb'.'end_user' where email=? and password=?";
        Member result=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, member.getEmail());
            ps.setString(2, member.getPassword());
            //ps.setInt(1, (int)Long.parseLong(member.getPhone())%1000000);
            ResultSet rs =ps.executeQuery();
            int size =0;
            if (rs != null)
            {
                rs.last();    // moves cursor to the last row
                size = rs.getRow(); // get row id
            }
            if(size==1){
                result=member;
            }else if(size>1){
                throw new Exception("Multiple user found");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }
}
