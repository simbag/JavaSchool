package com.sbt.javaschool.classloaders.EncryptedClassLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Encoder {

    public static void encode(File file, String key) {
        try {
            Integer keyValue = Integer.parseInt(key);
            byte[] bytes = Files.readAllBytes(Paths.get(String.valueOf(file)));
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] += keyValue;
            }
            Files.write(Paths.get(String.valueOf(file)), bytes);
            System.out.println("Файл " + file.toString() + " зашифрован.");
        } catch (IOException e) {
            System.out.println("Возникла ошибка при чтении файла "+file.getName());
        }
    }
}
