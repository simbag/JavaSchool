package com.sbt.javaschool.reflection.CachedCalculator;

public class Calculator implements ICalculator {

    @Override
    public Double plus(Double arg1, Double arg2) {
        return arg1 + arg2;
    }

    @Override
    public Double minus(Double arg1, Double arg2) {
        return arg1 - arg2;
    }

    @Override
    public Double divide(Double arg1, Double arg2) {
        return arg1 / arg2;
    }

    @Override
    public Double multiply(Double arg1, Double arg2) {
        return arg1 * arg2;
    }
}
