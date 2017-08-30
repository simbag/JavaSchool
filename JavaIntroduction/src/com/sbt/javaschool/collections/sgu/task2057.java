package com.sbt.javaschool.collections.sgu;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

class MultiSet {
    private PriorityQueue<Integer> multiSet = new PriorityQueue<>();

    public void add(Integer element) {
        this.multiSet.add(element);
    }

    public Integer poll() {
        return this.multiSet.poll();
    }
}

public class task2057 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countOps = scanner.nextInt();

        MultiSet multiSet = new MultiSet();

        StringJoiner stringJoiner = new StringJoiner("\n");
        for (int i = 0; i < countOps; i++) {
            if (scanner.nextInt() == 2) {
                stringJoiner.add(multiSet.poll().toString());
            } else {
                multiSet.add(scanner.nextInt());
            }
        }

        System.out.println(stringJoiner.toString());
    }
}
