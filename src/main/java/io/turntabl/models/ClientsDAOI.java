package io.turntabl.models;

import io.turntabl.Client;
import io.turntabl.DB.ConnectDB;
import io.turntabl.DB.DBConstants;
import org.h2.command.Prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAOI implements ClientsDAO {
    private
    Connection conn = ConnectDB.dbConnect();

    @Override
    public void addNewClient(Client client) {
        try{
            PreparedStatement ps = conn.prepareStatement(DBConstants.ADD_CLIENT);
            ps.clearParameters();
            ps.setString(1, client.getName());
            ps.setInt(2, client.getLevel());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getEmail());
            ps.setString(5, client.getTelephone());
            ps.executeUpdate();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }

    @Override
    public List<Client> displayAllClients() {
        List<Client> clients = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(DBConstants.DISPLAY_CLIENTS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clients.add(rowMapper(rs));
            }

        }catch(SQLException sqle){
            sqle.getStackTrace();
        }
        return clients;
    }

    @Override
    public void deleteClient(Integer id) {
        try {
            PreparedStatement ps = conn.prepareStatement(DBConstants.DELETE_CLIENT);
            ResultSet rs = ps.executeQuery();
            ps.clearParameters();
            ps.setInt(1, id);
            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateClient(Integer id) {

    }

    @Override
    public List<Client> searchClients(String name, String level, Integer id) {
        return null;
    }

    private Client rowMapper(ResultSet rs) throws SQLException{
        Client client = new Client(
                rs.getString("client_name"),
                rs.getInt("level_id"),
                rs.getString("address"),
                rs.getString("email"),
                rs.getString("phone")
       );
        return client;
    }
}
