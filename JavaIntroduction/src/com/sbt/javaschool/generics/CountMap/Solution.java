package com.sbt.javaschool.generics.CountMap;

import com.sbt.javaschool.generics.List.LinkedList;

public class Solution {
    public static void main(String[] args) {

        CountMap<Integer> countMapmap1 = new CountMapImpl<>();
        CountMap<Integer> countMapmap2 = new CountMapImpl<>();

        countMapmap1.add(10);
        countMapmap1.add(10);
        countMapmap1.add(5);
        countMapmap1.add(6);
        countMapmap1.add(5);
        countMapmap1.add(10);

        countMapmap2.add(10);
        countMapmap2.add(10);
        countMapmap2.add(6);
        countMapmap2.add(1);
        countMapmap2.add(1);

        System.out.println(countMapmap1.getCount(5));
        System.out.println(countMapmap1.getCount(6));
        System.out.println(countMapmap1.getCount(10));

        countMapmap1.addAll(countMapmap2);

        System.out.println(countMapmap1.getCount(5));
        System.out.println(countMapmap1.getCount(6));
        System.out.println(countMapmap1.getCount(10));
        System.out.println(countMapmap1.getCount(1));
        System.out.println(countMapmap1.getCount(3));

    }
}
