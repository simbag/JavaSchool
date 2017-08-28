package com.sbt.javaschool.collections.lecture_tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    public static void main(String[] args) {

        String str = "";

        try {
            Scanner scanner = new Scanner(new File("resources/input.txt")).useDelimiter("\\Z");
            str = scanner.next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashMap<String,Integer> result = new HashMap<>();

        Pattern pattern = Pattern.compile("[a-zA-z]+");
        Matcher matcher = pattern.matcher(str);

        while(matcher.find()){
            String word = matcher.group();
            int count = result.getOrDefault(word,0);
            result.put(word,++count);
        }

        System.out.println(result);
    }
}
