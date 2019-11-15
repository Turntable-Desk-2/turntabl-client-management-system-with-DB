package io.turntabl.controllers;

import io.turntabl.Client;
import io.turntabl.ClientLevel;
import io.turntabl.ClientRegister;
import jdk.vm.ci.code.Register;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class NewClient {
    public static void newClient(){
        GenerateID id = new GenerateID();

        Scanner sc = new Scanner(System.in);

        System.out.println("Name: ");
        String name = sc.nextLine();

        System.out.println("Address: ");
        String address = sc.nextLine();

        System.out.println("Telephone: ");
        String telephone = sc.nextLine();

        System.out.println("Email: ");
        String email = sc.nextLine();

        System.out.println("=====Choose Client Level===== \n1. GOLD\n2. PREMIUM\n3. PLATINUM");
        Integer res = sc.nextInt();
        ClientLevel level = null;
        switch (res){
            case 1:
              level = ClientLevel.GOLD;
              break;
            case 2:
                level = ClientLevel.PREMIUM;
                break;
            case 3:
                level = ClientLevel.PLATINUM;
                break;
            default:
                level = ClientLevel.GOLD;
        }
        PersistData.writeFile(id.getId(5), name, address, telephone, email, level);
    }

}
