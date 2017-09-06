package com.sbt.javaschool.reflection.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BeanUtils {

    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible  means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *    
     *
     * @param to     Object which properties will be set.
     * @param from Object which properties will be used to get values.     
     */

    public static void assign(Object to, Object from) {
        Class toClazz = to.getClass();
        Class fromClazz = from.getClass();

        Method[] fromMethods = fromClazz.getMethods();
        Method[] toMethods = toClazz.getMethods();

        HashMap<String, Method> toMethodsHashMap = new HashMap<>();

        for (Method method : toMethods) {
            toMethodsHashMap.put(method.getName(), method);
        }

        for (Method getMethod : fromMethods) {
            if (getMethod.getName().startsWith("get")) {

                String setMethodName = getMethod.getName().replace("get", "set");
                System.out.println("Get-метод: " + getMethod.getName());
                System.out.println("Ищем set-метод: " + setMethodName);

                Method setMethod = toMethodsHashMap.get(setMethodName);
                if (setMethod != null) {
                    System.out.println("Нашли set-метод: " + setMethodName);

                    Class<?> setMethodType = setMethod.getParameterTypes()[0];
                    Class<?> getMethodType = getMethod.getReturnType();

                    if (setMethodType.isAssignableFrom(getMethodType)) {
                        try {
                            setMethod.invoke(to, getMethod.invoke(from));
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            System.out.println("Ошибка доступа к методу! " + e.getMessage());
                        }
                    } else {
                        System.out.println("Параметры get-метода (" + getMethodType.getSimpleName() + ") и set-метода (" + setMethodType.getSimpleName() + ") несовместимы");
                    }

                } else {
                    System.out.println("set-метод " + setMethodName + " не найден");
                }
            }
        }
    }
}

