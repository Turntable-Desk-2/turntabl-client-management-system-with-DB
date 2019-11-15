package io.turntabl.models;

import io.turntabl.Client;

import java.util.List;

public interface ClientsDAO {
    public void addNewClient(Client client);
    public List<Client> displayAllClients();
    public void deleteClient(Integer id);
    public void updateClient(Integer id);
    public List<Client> searchClients(String name, String level, Integer id);
}
