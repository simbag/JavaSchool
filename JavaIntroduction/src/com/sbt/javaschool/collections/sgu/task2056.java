package com.sbt.javaschool.collections.sgu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task2056 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("input.txt")).useDelimiter("\\Z");

        String str = scanner.next();

        str = str.toLowerCase();

        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(str);

        TreeMap<String, Integer> words = new TreeMap<>();

        while (matcher.find()) {
            String word = matcher.group();
            int count = words.getOrDefault(word, 0);
            words.put(word, count + 1);
        }

        int max = Collections.max(words.values());

        for (Map.Entry<String, Integer> word : words.entrySet()) {
            if (word.getValue() == max) {
                System.out.println(word.getKey());
            }
        }
    }
}
