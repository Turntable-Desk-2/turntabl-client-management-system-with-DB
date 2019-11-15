package io.turntabl.controllers;

import java.util.Random;

public class GenerateID {
    public int getId(int length){
        String numbers = "0123456789";
        Random ran = new Random();
        int getLen = length;
        StringBuilder sb = new StringBuilder(getLen);

        for (int i = 0; i < getLen; i++) {
            sb.append(numbers.charAt(ran.nextInt(numbers.length())));
        }
        return Integer.parseInt(sb.toString());
    }

}
