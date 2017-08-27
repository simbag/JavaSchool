package com.sbt.javaschool.collections.lecture_tasks;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task4 {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();

        try {
            lines =
                    (Files.readAllLines(
                            Paths.get("D:\\JavaSchool\\JavaIntroduction\\JavaIntroduction\\src\\com\\sbt\\javaschool\\collections\\lecture_tasks\\input2.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (ListIterator<String> i = lines.listIterator(lines.size()); i.hasPrevious(); ) {
            System.out.println(new StringBuilder(i.previous()).reverse());
        }

    }
}
