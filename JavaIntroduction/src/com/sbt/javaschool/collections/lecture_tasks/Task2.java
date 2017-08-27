package com.sbt.javaschool.collections.lecture_tasks;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task2 {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();

        try {
            lines =
                    (Files.readAllLines(
                            Paths.get("D:\\JavaSchool\\JavaIntroduction\\JavaIntroduction\\src\\com\\sbt\\javaschool\\collections\\lecture_tasks\\input2.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        TreeSet<String> words = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (String line : lines) {
            words.addAll(Arrays.asList(line.split("[^a-zA-Z]")));
            words.removeAll(Arrays.asList(""));
        }

        for (String line : lines) {
            System.out.println(words.toString());
        }
    }
}
