package com.sbt.javaschool.reflection.CachedCalculator;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class CachedProxy implements InvocationHandler {
    private final Object delegate;
    private HashMap<String, Object> cache = new HashMap<>();
    private String cacheFileName = "cache.txt";

    CachedProxy(Object delegate) {
        this.delegate = delegate;

        try {
            List<String> lines = Files.readAllLines(Paths.get(cacheFileName));
            for (String line : lines) {
                String key = line.split("=")[0];
                Object value = Double.parseDouble(line.split("=")[1]);
                cache.put(key, value);
            }
        } catch (IOException e) {
            System.out.println("Файл кэша " + cacheFileName + " отсутствует! Будет создан новый файл.");
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        String key = method.getName() + Arrays.toString(args);
        if (cache.containsKey(key)) {
            System.out.print("Результат получен из кэша! ");
            return cache.get(key);
        } else {
            Object result = method.invoke(delegate, args);
            cache.put(key, result);

            try (FileWriter fileWriter = new FileWriter(cacheFileName, true)) {
                fileWriter.write(key + "=" + result + "\n");
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл" + cacheFileName);
            }
            return result;
        }
    }
}
