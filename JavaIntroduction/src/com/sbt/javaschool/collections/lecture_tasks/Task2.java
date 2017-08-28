package com.sbt.javaschool.collections.lecture_tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) {

        String str = "";

        try {
            Scanner scanner = new Scanner(new File("resources/input.txt")).useDelimiter("\\Z");
            str = scanner.next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() > o2.length()) {
                    return 1;
                } else return 0;
            }
        };

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        TreeSet<String> words = new TreeSet<>(lengthComparator.thenComparing(stringComparator));

        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        System.out.println(words);
    }
}
