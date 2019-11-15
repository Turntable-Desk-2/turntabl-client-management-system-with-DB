package io.turntabl;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import static org.junit.Assert.*;

public class ClientDBTest {

    private static final String url =  "jdbc:h2:tcmsdb";
    private static final String script = "tcmsdb.sql";
    @Test
    public void inMemoryDBTest() throws IOException {
        BufferedReader read = null;
        try {
            Class.forName("org.h2.Driver");
            Connection db = DriverManager.getConnection(url, "", "");

            Statement stmt = db.createStatement();
            read =  new BufferedReader(new FileReader(script));
            while(read.readLine() != null){
                stmt.execute(read.readLine());
            }
        }catch (SQLException | FileNotFoundException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void getClientsTest() throws IOException {
        try {
            Class.forName("org.h2.Driver");
            Connection db = DriverManager.getConnection(url, "", "");

            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("select * from levels");

            while(rs.next()){
                System.out.println(rs.getString("level_name"));
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

}
