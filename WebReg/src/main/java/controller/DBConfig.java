package controller;

public class DBConfig {
    private final String user = "root";
    private final String url = "jdbc:mysql://localhost:3306/mydb";
    private final String password = "3042127359@qq.com";
    private final String dbdriver = "com.mysql.cj.jdbc.Driver";

    public DBConfig() {
    }

    public String getUser() {
        return user;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    public String getDbdriver() {
        return dbdriver;
    }

}
