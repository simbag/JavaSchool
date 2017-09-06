package com.sbt.javaschool.reflection.Annotations;

public class Person {
    @Length(min=5,max=20)
    public String Name;

    public Person(String name) {
        Name = name;
    }
}
