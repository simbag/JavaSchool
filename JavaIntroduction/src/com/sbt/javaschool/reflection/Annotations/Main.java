package com.sbt.javaschool.reflection.Annotations;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Na");
        try {
            checkAnnotation(person);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void checkAnnotation(Object o) throws IllegalAccessException {
        Class clazz = o.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Length.class)) {
                Length length = field.getAnnotation(Length.class);
                int min = length.min();
                int max = length.max();

                String fieldValue = field.get(o).toString();
                if (fieldValue.length() < min) {
                    throw new IllegalStateException("Слишком короткое имя! Имя должно содержать минимум "+min+" символов.");
                }

                if (fieldValue.length() > max) {
                    throw new IllegalStateException("Слишком длинное имя! Имя не должно содержать более "+max+" символов.");
                }

            }
        }
    }
}
