package com.sbt.javaschool.collections.sgu;

import java.util.*;

public class task2051 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        TreeMap<Integer,Integer> result = new TreeMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                queue.push(i+1);
            } else result.put(queue.pop(),i+1);
        }

        for (Map.Entry<Integer,Integer> entry: result.entrySet()) {
            System.out.println(entry.getKey() + " " +entry.getValue());
        }
    }
}
