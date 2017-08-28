package com.sbt.javaschool.collections.lecture_tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    public static void main(String[] args) {

        String str = "";

        try {
            Scanner scanner = new Scanner(new File("resources/input.txt")).useDelimiter("\\Z");
            str = scanner.next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashSet<String> words = new HashSet<>();

        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        System.out.println(words.size());
    }
}
