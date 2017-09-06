package com.sbt.javaschool.reflection.BeanUtils;

public class Main {
    public static void main(String[] args) {
        IntegerClassFrom classFrom = new IntegerClassFrom(100, 1000);

        NumberClassTo classTo1 = new NumberClassTo(1D, "1D");
        IntegerClassTo classTo2 = new IntegerClassTo(2, "2");

        System.out.println("classTo1.value = " + classTo1.getValue());
        BeanUtils.assign(classTo1, classFrom);
        System.out.println("classTo1.value = " + classTo1.getValue());

        System.out.println();

        System.out.println("classTo2.value = " + classTo2.getValue());
        BeanUtils.assign(classTo2, classFrom);
        System.out.println("classTo2.value = " + classTo2.getValue());

    }
}
