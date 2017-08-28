package com.sbt.javaschool.collections.sgu;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task2056 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\\z");

        String str = scanner.next();

        System.out.println(str);

        str = str.toLowerCase();

        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(str);

        TreeMap<String, Integer> words = new TreeMap<>();

        while (matcher.find()) {
            String word = matcher.group();
            int count = words.getOrDefault(word, 0);
            words.put(word, ++count);
        }

        int max = Collections.max(words.values());

        for (Map.Entry<String, Integer> word : words.entrySet()) {
            if (word.getValue() == max) {
                System.out.println(word.getKey());
            }
        }
    }
}
