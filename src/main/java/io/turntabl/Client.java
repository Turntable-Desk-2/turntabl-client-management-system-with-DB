package io.turntabl;

public class Client {
    private int id;
    private String name;
    private String address;
    private String telephone;
    private String email;
    private ClientLevel level;

    public Client(int id, String name, Integer level, String address, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
//        this.level = level;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }


    public ClientLevel getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", level=" + level +
                '}';
    }
}
