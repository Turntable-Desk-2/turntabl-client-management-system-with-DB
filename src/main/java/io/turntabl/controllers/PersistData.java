package io.turntabl.controllers;

import io.turntabl.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersistData {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    public static void writeFile(int id, String name, String address, String telephone, String email, ClientLevel level) {
        try {
            File file = new File("store.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(id + "---" + name + "---" + address + "---" + telephone + "---" + email + "---" + level + "\n");
            pw.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String> readFile(){
        List<String> details = new ArrayList<>();
        try {
            File file = new File("store.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                details.add(data);
            }
        }catch (FileNotFoundException e){
            System.out.println(RED + "Client not Found" +RESET);
        }
        return details;
    }

    public static List<String> removeClient(String id){
        try {
            File file = new File("store.txt");
            List<String> out = Files.lines(file.toPath())
                    .filter(line -> !line.contains(id))
                    .collect(Collectors.toList());
            Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<String> updateClient(String id, String text, String newText){
        List<String> updatedFile =  readFile().stream().filter(l -> l.contains(id))
                .map(line -> line.replaceAll(text, newText))
                .collect(Collectors.toList());
        removeClient(id);
        try {
            File file = new File("store.txt");

            List<String> out = Files.lines(file.toPath())
                    .filter(line -> !line.contains(id))
                    .collect(Collectors.toList());
            Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            for(String update : updatedFile){
                pw.print(update);
                pw.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }


}
