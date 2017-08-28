package com.sbt.javaschool.collections.lecture_tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task6 {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();

        try {
            lines =
                    (Files.readAllLines(
                            Paths.get("resources/input.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }
            if (number <= lines.size()) {
                System.out.println(lines.get(number - 1));
            } else {
                System.out.println("Строка с указанным номером отсутствует");
            }
        }
    }
}
