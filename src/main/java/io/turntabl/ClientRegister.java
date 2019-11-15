package io.turntabl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientRegister {

    private List<Client> clients;

    public ClientRegister(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getAllClients(){
        return clients.stream().collect(Collectors.toList());
    }

    public List<Client> getClientsByName(String name){
        return clients.stream()
                .filter(client -> client.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Client> getClientsLevel(ClientLevel level) {
        return clients.stream()
                .filter(client -> client.getLevel().equals(level))
                .collect(Collectors.toList());
    }

    public List <Client> getClientsById(int clientsId){
        return clients.stream()
                .filter(client -> client.getId() == clientsId)
                .collect(Collectors.toList());
    }


}
