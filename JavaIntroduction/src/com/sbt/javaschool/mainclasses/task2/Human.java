package com.sbt.javaschool.mainclasses.task2;

public abstract class Human {
    String name;
    int age;

    abstract void goHome();
}

interface Worker {
    void doWork();
}

class Person extends Human {

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    void goHome() {
        System.out.println("Person " + this.name + " going home");
    }
}

class Client extends Person implements Worker {
    String phone;

    public Client(String name, int age, String phone) {
        super(name, age);
        this.phone = phone;
    }

    @Override
    void goHome() {
        System.out.println("Client " + this.name + " going home");
    }

    @Override
    public void doWork() {
        System.out.println("Client " + this.name + " working");
    }
}

class Solution {
    public static void main(String[] args) {

        Person person = new Person("John", 20);
        person.goHome();

        person = new Client("Max", 20, "123-456-678");
        person.goHome();

        new Client("Alex", 20, "123-456-678").doWork();
    }
}
