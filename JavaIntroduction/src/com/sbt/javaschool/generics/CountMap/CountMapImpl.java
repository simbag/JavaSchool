package com.sbt.javaschool.generics.CountMap;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private Map<T, Integer> map = new HashMap<>();

    /**
     * добавляет элемент в этот контейнер.
     *
     * @param element
     */
    @Override
    public void add(T element) {
        int count = map.getOrDefault(element, 0);
        map.put(element, count + 1);
    }

    /**
     * Возвращает количество добавлений данного элемента
     *
     * @param element
     */
    @Override
    public int getCount(T element) {
        return map.getOrDefault(element,0);
    }

    /**
     * Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
     *
     * @param element
     */
    @Override
    public int remove(T element) {
        return map.remove(element);
    }

    /**
     * количество разных элементов
     */
    @Override
    public int size() {
        return map.size();
    }

    /**
     * Добавить все элементы из source в текущий контейнер, при совпадении ключей,     суммировать значения
     *
     * @param source
     */
    @Override
    public void addAll(CountMap<T> source) {
        Map<T, Integer> sourceMap = source.toMap();
        for (Map.Entry<T,Integer> entry : sourceMap.entrySet()) {
            int count = map.getOrDefault(entry.getKey(),0);
            map.put(entry.getKey(),count+entry.getValue());
        }
    }

    /**
     * Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
     */
    @Override
    public Map<T, Integer> toMap() {
        return new HashMap<T, Integer>(map);
    }

    /**
     * Тот же самый контракт как и toMap(), только всю информацию записать в destination
     *
     * @param destination
     */
    @Override
    public void toMap(Map destination) {
        destination = new HashMap(map);
    }
}
