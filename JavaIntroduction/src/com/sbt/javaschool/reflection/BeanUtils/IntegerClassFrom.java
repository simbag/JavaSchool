package com.sbt.javaschool.reflection.BeanUtils;

public class IntegerClassFrom {
    Integer value;
    Integer value2;

    public IntegerClassFrom(Integer value, Integer value2) {
        this.value = value;
        this.value2 = value2;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue2() {
        return value2;
    }

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }
}
