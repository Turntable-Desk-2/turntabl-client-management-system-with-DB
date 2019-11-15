package io.turntabl;

import org.junit.Test;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import static org.junit.Assert.*;

public class ConnectionTest {
    private static final String url = "jdbc:h2:tcms";
    private static final String sqlpath = "tcsmstore.sql";

    @Test
    public void testMemoryIntegration() throws ClassNotFoundException {
        BufferedReader reader = null;
        Class.forName("org.h2.Driver");

        try (Connection db = DriverManager.getConnection(url, "", "")) {
            Statement st = db.createStatement();
            reader = new BufferedReader(new FileReader(sqlpath));

            String line;
            while ((line = reader.readLine()) != null) {
                st.execute(line);
            }

        } catch (SQLException | FileNotFoundException e) {
            System.err.println("Error " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuery() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try (Connection db = DriverManager.getConnection(url, "", "")) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("select * from clients");

            while (rs.next()) {
                System.out.format("%5s %10s %15s %10s %20s %20s", rs.getInt("client_id"), rs.getString("client_name"), rs.getString("client_level"), rs.getString("client_address"), rs.getString("client_email"), rs.getString("phone"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Connection err" + e);
        }

    }


    @Test
    public void testQueryForClientsNames() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try (Connection db = DriverManager.getConnection(url, "", "")) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("select client_name from clients");

            while (rs.next()) {
                System.out.format("%10s ", rs.getString("client_name"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Connection err" + e);
        }

        }

        @Test
        public void testQueryForClientsNamesByLevel() throws ClassNotFoundException {
            Class.forName("org.h2.Driver");
            try (Connection db = DriverManager.getConnection(url, "", "")) {
                Statement st = db.createStatement();
                ResultSet rs = st.executeQuery("select client_name from clients where client_level = 'Gold'");

                while (rs.next()) {
                    System.out.format("%10s ", rs.getString("client_name"));
                    System.out.println();
                }
            } catch (SQLException e) {
                System.err.println("Connection err" + e);
            }

        }
    }


