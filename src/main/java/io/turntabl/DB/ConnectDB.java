package io.turntabl.DB;

import java.sql.*;

public class ConnectDB {
    public static Connection dbConnect() throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        Class.forName("org.h2.Driver");
        //String url = "jdbc:postgresql:tcmsdb";
        try{
            conn = DriverManager.getConnection("jdbc:h2:~/test", "", "");
            System.out.println("Database Connected");
            stmt.execute("drop table user");
            stmt.execute("create table user(id int primary key, name varchar(100))");
            stmt.execute("insert into user values(1, 'hello')");
            stmt.execute("insert into user values(2, 'world')");
            ResultSet rs = stmt.executeQuery("select * from user");

            while (rs.next()) {
                System.out.println("id " + rs.getInt("id") + " name " + rs.getString("name"));
            }
            stmt.close();
        }catch (SQLException sql){
            System.err.println("Connection Error: " + sql);
        }
        return conn;
    }
}
