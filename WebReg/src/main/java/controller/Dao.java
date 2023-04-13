package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {
    /*
    private Connection con;
    public Dao() {
        try {
            DBConfig dbConfig = new DBConfig();
            con = DriverManager.getConnection(
                    dbConfig.getUrl(),
                    dbConfig.getUser(), dbConfig.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return con;
    }
    */
    //Above is the nightly version
    //Below is the stable version
    public Dao() {
    }
    public Connection getConnection() {
        Connection con = null;
        try {
            DBConfig dbConfig = new DBConfig();
            con = DriverManager.getConnection(
                    dbConfig.getUrl(),
                    dbConfig.getUser(), dbConfig.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
