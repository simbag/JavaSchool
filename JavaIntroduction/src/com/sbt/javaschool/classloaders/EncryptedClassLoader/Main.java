package com.sbt.javaschool.classloaders.EncryptedClassLoader;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File dir = new File("D:\\JavaSchool\\Projects\\JavaIntroduction\\src\\com\\sbt\\javaschool\\classloaders\\EncryptedClassLoader\\Classes");

        EncryptedClassLoader encryptedClassLoader = new EncryptedClassLoader("1", dir, ClassLoader.getSystemClassLoader());

        try {
            for (File file : dir.listFiles()) {
                if (file.getName().endsWith(".class")) {
                    Encoder.encode(file, "1");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("В директории отсутствуют файлы!");
        }

        try {
            encryptedClassLoader.loadClass("Class0").newInstance();
            encryptedClassLoader.loadClass("Class1").newInstance();
            encryptedClassLoader.loadClass("Class2").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
