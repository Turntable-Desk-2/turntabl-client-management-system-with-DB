package io.turntabl.DB;

import java.sql.*;

public class ConnectDB {

    public static Connection dbConnect(){
        Connection conn = null;
        String url = "jdbc:postgresql:tcmsdb";
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, "shadrack-ankomahene", "turntabl");
            System.out.println("Database Connected");
        }catch (SQLException | ClassNotFoundException sql){
            System.err.println("Connection Error: " + sql);
        }
        return conn;
    }
}
