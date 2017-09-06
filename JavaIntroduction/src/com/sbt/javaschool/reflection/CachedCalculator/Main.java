package com.sbt.javaschool.reflection.CachedCalculator;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        ICalculator calculator =
                (ICalculator) Proxy.newProxyInstance(
                        Calculator.class.getClassLoader(),
                        new Class[]{ICalculator.class},
                        new CachedProxy(new Calculator()));


        System.out.println("1+1 = " + calculator.plus(1., 1.));
        System.out.println("1+1 = " + calculator.plus(1., 1.));
        System.out.println("2-1 = " + calculator.minus(2., 1.));
        System.out.println("10/6 = " + calculator.divide(10., 6.));
        System.out.println("2-1 = " + calculator.minus(2., 1.));
        System.out.println("10/6 = " + calculator.divide(10., 6.));
        System.out.println("2*3 = " + calculator.multiply(2., 3.));
        System.out.println("2*3 = " + calculator.multiply(2., 3.));
    }
}
