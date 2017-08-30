package com.sbt.javaschool.generics.List;

public class Solution {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Заполнили лист");

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(10);

        for (Integer i:linkedList) {
            System.out.println(i);
        }

        linkedList.add(5,100);

        System.out.println("Добавили элемент со значением 100 в позицию 5");

        System.out.println(linkedList.get(5));

        for (Integer i:linkedList) {
            System.out.println(i);
        }

        System.out.println("Удалили элемент с индексом 5");

        Integer e = linkedList.remove(5);

        System.out.println(e);

        for (Integer i:linkedList) {
            System.out.println(i);
        }

    }
}
