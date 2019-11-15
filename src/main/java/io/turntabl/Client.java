package io.turntabl;

public class Client {
    private String name;
    private String address;
    private String telephone;
    private String email;
    private Integer level;

    public Client(String name, Integer level, String address, String telephone, String email) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.level = level;

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


    public Integer getLevel() {
        return level;
    }

}
