package com.sbt.javaschool.collections.lecture_tasks;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task3 {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();

        try {
            lines =
                    (Files.readAllLines(
                            Paths.get("D:\\JavaSchool\\JavaIntroduction\\JavaIntroduction\\src\\com\\sbt\\javaschool\\collections\\lecture_tasks\\input2.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> allWords = new ArrayList<>();
        HashSet<String> words = new HashSet<>();

        for (String line : lines) {
            allWords.addAll(Arrays.asList(line.split("[^a-zA-Z]")));
            allWords.removeAll(Arrays.asList(""));
            words.addAll(allWords);
        }

        for (String word : words) {
            System.out.println(word + ": " + Collections.frequency(allWords, word));
        }
    }
}
