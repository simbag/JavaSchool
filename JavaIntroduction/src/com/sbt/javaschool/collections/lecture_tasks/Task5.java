package com.sbt.javaschool.collections.lecture_tasks;

public class Task5 {
    public static void main(String[] args) {

        ReversArrayList<Integer> reversArrayList = new ReversArrayList<>();

        reversArrayList.add(1);
        reversArrayList.add(2);
        reversArrayList.add(3);
        reversArrayList.add(4);
        reversArrayList.add(5);
        reversArrayList.add(6);
        reversArrayList.add(7);
        reversArrayList.add(8);
        reversArrayList.add(9);
        reversArrayList.add(10);

        for (Integer i : reversArrayList) {
            System.out.println(i);
        }
    }
}
