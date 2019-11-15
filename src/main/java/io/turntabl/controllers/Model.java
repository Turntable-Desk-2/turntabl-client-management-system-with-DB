package io.turntabl.controllers;

import io.turntabl.Client;
import io.turntabl.ClientLevel;
import io.turntabl.ClientRegister;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Model {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void indexPage(){
        boolean q = true;
        while(q) {
        System.out.println("\n=====TURNTABL CLIENT MANAGEMENT SYSTEM=====\nPlease Choose an Option by Number");
        System.out.println("1. Add new Client \n2. Display All Clients \n3. Update a Client Info \n4. Remove a Client \n5. Search for Client \n0. Quit App");
        System.out.println("Enter Option here: ");
        Scanner sc = new Scanner(System.in);
        Integer res = sc.nextInt();

            switch (res) {
                case 0:
                    System.out.println(RED + "Quiting Application..." + RESET);
                    q = false;
                    break;
                case 1:
                    System.out.println("Add new Client Details");
                    NewClient.newClient();
                    System.out.println("\n-------------------------------\n "+ GREEN+ "Client Added Successfully" + RESET + "\n----------------------------\n");
                    break;
                case 2:
                    getAllMyClients();
                    break;
                case 3:
                    if(getAllMyClients()) {
                        System.out.println("Enter id of Client you want to Update: ");
                        Integer idToUpdate = sc.nextInt();

                        if (searchByID(idToUpdate)) {
                            System.out.println("What do you want to Update?");
                            String what = sc.next();

                            System.out.println("Replace with?");
                            String replaceWith = sc.next();

                            PersistData.updateClient(idToUpdate.toString(), what, replaceWith);
                            System.out.println("\n-------------------------------\n" + GREEN + "Client info Updated Successfully" + RESET + "\n----------------------------\n");
                        }
                    }
                    break;
                case 4:
                    if(getAllMyClients()) {
                        System.out.println("Enter client Id to Remove: ");
                        String idToRemove = sc.next();
                        PersistData.removeClient(idToRemove);
                        System.out.println("\n-------------------------------\n" + GREEN + "Client Removed Successfully" + RESET + "\n----------------------------\n");
                    }
                    break;
                case 5:
                    System.out.println("=====Search for Clients By: \n1. Name\n2. Level\n3. ID");
                    Integer input = sc.nextInt();
                    Integer level = null;
                    switch (input){
                        case 1:
                            System.out.println("Enter Name: ");
                            String name = sc.next();
                            searchByName(name);
                            break;
                        case 2:
                            System.out.println("Enter Level: \n1. Gold\n2. Premium\n3. Platinum\n");
                            Integer in = sc.nextInt();
                            searchByLevel(in);
                            break;
                        case 3:
                            System.out.println("Enter Id: ");
                            int id = sc.nextInt();
                            searchByID(id);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("Please Enter Valid Number");
            }
        }
    }

    public static void searchByLevel(Integer in){
        ClientRegister reg = new ClientRegister(clientList());
        switch (in){
            case 1:
                if (reg.getClientsLevel(ClientLevel.GOLD).size() == 0 ){
                    System.out.println(RED + "------------------------------\nNo Client Found\n------------------------------" + RESET);
                }else {
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%5s %20s %20s %15s %20s %15s", BLUE + "ID", "NAME", "ADDRESS", "TEL NO.", "EMAIL", "LEVEL" + RESET);
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                    for (Client client : reg.getClientsLevel(ClientLevel.GOLD)) {
                        System.out.format("%5s %20s %20s %15s %25s %15s",
                                client.getId(), client.getName(), client.getAddress(), client.getTelephone(), client.getEmail(), client.getLevel());
                        System.out.println();
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
                }
                break;
            case 2:
                if (reg.getClientsLevel(ClientLevel.PREMIUM).size() == 0 ){
                    System.out.println(RED + "------------------------------\nNo Client Found\n------------------------------" + RESET);
                }else {
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%5s %20s %20s %15s %20s %15s", BLUE + "ID", "NAME", "ADDRESS", "TEL NO.", "EMAIL", "LEVEL" + RESET);
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                    for (Client client : reg.getClientsLevel(ClientLevel.PREMIUM)) {
                        System.out.format("%5s %20s %20s %15s %25s %15s",
                                client.getId(), client.getName(), client.getAddress(), client.getTelephone(), client.getEmail(), client.getLevel());
                        System.out.println();
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
                }
                break;
            case 3:
                if (reg.getClientsLevel(ClientLevel.PLATINUM).size() == 0 ){
                    System.out.println(RED + "------------------------------\nNo Client Found\n------------------------------" + RESET);
                }else {
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%5s %20s %20s %15s %20s %15s", BLUE + "ID", "NAME", "ADDRESS", "TEL NO.", "EMAIL", "LEVEL" + RESET);
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                    for (Client client : reg.getClientsLevel(ClientLevel.PLATINUM)) {
                        System.out.format("%5s %20s %20s %15s %25s %15s",
                                client.getId(), client.getName(), client.getAddress(), client.getTelephone(), client.getEmail(), client.getLevel());
                        System.out.println();
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
                }
                break;
            default:
                System.out.println(RED + "Enter Valid Client Level" + RESET);
        }
    }

    public static void searchByName(String name){
        ClientRegister reg = new ClientRegister(clientList());

        if (reg.getClientsByName(name).size() == 0 ){
            System.out.println(RED + "------------------------------\nNo Client Found\n------------------------------" + RESET);
        }else {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %20s %15s %20s %15s", BLUE + "ID", "NAME" , "ADDRESS", "TEL NO.", "EMAIL", "LEVEL" + RESET);
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

            for (Client client : reg.getClientsByName(name)) {
                System.out.format("%5s %20s %20s %15s %25s %15s",
                        client.getId(), client.getName(), client.getAddress(), client.getTelephone(), client.getEmail(), client.getLevel());
                System.out.println();
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public static boolean searchByID(int id){
        ClientRegister reg = new ClientRegister(clientList());

        if (reg.getClientsById(id).size() == 0 ){
            System.out.println(RED + "------------------------------\nNo Client Found with that ID\n------------------------------" + RESET);
            return false;
        }else {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %20s %15s %20s %15s", BLUE + "ID", "NAME", "ADDRESS", "TEL NO.", "EMAIL", "LEVEL" + RESET);
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            for (Client client : reg.getClientsById(id)) {
                System.out.format("%5s %20s %20s %15s %25s %15s",
                        client.getId(), client.getName(), client.getAddress(), client.getTelephone(), client.getEmail(), client.getLevel());
                System.out.println();
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        }
        return true;
    }

    public static List<Client> clientList(){
        List<Client> clients = new ArrayList<>();

        for (String data : PersistData.readFile()){
            String[] split = data.split("---");
            clients.add(new Client(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4], ClientLevel.valueOf(split[5])));
        }
        return clients;
    }

    public static boolean getAllMyClients(){
        ClientRegister reg = new ClientRegister(clientList());

        if (reg.getAllClients().size() == 0 ){
            System.out.println(RED + "------------------------------\nNo Client Found\n------------------------------" + RESET);
            return false;
        }else {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %20s %15s %20s %15s", BLUE + "ID", "NAME", "ADDRESS", "TEL NO.", "EMAIL", "LEVEL" + RESET);
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            for (Client client : reg.getAllClients()) {
                System.out.format("%5s %20s %20s %15s %25s %15s",
                        client.getId(), client.getName(), client.getAddress(), client.getTelephone(), client.getEmail(), client.getLevel());
                System.out.println();
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        }
        return true;
    }
}
