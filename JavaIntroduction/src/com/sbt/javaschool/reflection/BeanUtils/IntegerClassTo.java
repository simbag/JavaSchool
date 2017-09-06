package com.sbt.javaschool.reflection.BeanUtils;

public class IntegerClassTo {
    Integer value;
    String value2;

    public IntegerClassTo(Integer value, String value2) {
        this.value = value;
        this.value2 = value2;
    }

    public Integer getValue() {
        return value;

    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
