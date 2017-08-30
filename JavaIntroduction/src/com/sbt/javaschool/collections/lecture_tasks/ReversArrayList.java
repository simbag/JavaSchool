package com.sbt.javaschool.collections.lecture_tasks;

import java.util.ArrayList;
import java.util.Iterator;


public class ReversArrayList<T> extends ArrayList<T> {

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = ReversArrayList.super.size();

            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public T next() {
                index--;
                return ReversArrayList.super.get(index);
            }
        };
    }
}
