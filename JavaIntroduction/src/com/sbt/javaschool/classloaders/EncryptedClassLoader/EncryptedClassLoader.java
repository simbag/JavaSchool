package com.sbt.javaschool.classloaders.EncryptedClassLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncryptedClassLoader extends ClassLoader {
    private final String key;
    private final File dir;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        File[] files = dir.listFiles();

        Integer keyValue = Integer.parseInt(key);

        for (File file : files) {
            try {
                if (file.getName().replace(".class", "").equals(name)) {
                    byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));
                    for (int i = 0; i < bytes.length; i++) {
                        bytes[i] -= keyValue;
                    }
                    Files.write(Paths.get(file.getPath()), bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                }
            } catch (IOException e) {
                System.out.println("Возникла ошибка при чтении файла "+file.getName());
            }
        }

        return super.findClass(name);
    }
}

