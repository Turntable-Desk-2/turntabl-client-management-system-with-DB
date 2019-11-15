package io.turntabl.DB;

public class DBConstants {
    public static String ADD_CLIENT = "insert into clients(client_name, level_id, address, email, phone) values(?, ?, ?, ?, ?)";
    public static String DISPLAY_CLIENTS = "select * from clients inner join levels on clients.level_id = levels.level_id";
    public static String UPDATE_CLIENT = "";
    public static String DELETE_CLIENT = "delete from clients where client_id = ?";
    public static String SEARCH_CLIENT = "";
}
