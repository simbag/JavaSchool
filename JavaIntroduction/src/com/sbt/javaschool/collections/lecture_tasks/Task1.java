package com.sbt.javaschool.collections.lecture_tasks;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task1 {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();

        try {
            lines =
                    (Files.readAllLines(
                            Paths.get("D:\\JavaSchool\\JavaIntroduction\\JavaIntroduction\\src\\com\\sbt\\javaschool\\collections\\lecture_tasks\\input2.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashSet<String> words = new HashSet<>();


        for (String line: lines) {
            words.addAll(Arrays.asList(line.split("[^a-zA-Z]")));
            words.removeAll(Arrays.asList(""));
        }

        for (String line: lines) {
            System.out.println(words.toString());
        }

        System.out.println(words.size());

    }


}
