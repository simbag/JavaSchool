
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


public class CacheHandler implements InvocationHandler {

    private Object delegate;
    private final String cacheDirectoryPath;


    public CacheHandler(Object delegate, String cacheDirectoryPath) {
        this.delegate = delegate;
        this.cacheDirectoryPath = cacheDirectoryPath;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //Если не нужно кешировать - просто вызываем метод
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(delegate, args);
        }
        //Получаем настройки кэша
        Cache cache = method.getAnnotation(Cache.class);

        Object result = null;

        //Формируем ключ по которому будем искать/записывать кэш
        String cacheKey = cache.fileNamePrefix() + getCacheKey(method.getName(), args, Arrays.asList(cache.identityBy()));

        //Если указано, что кэш должен храниться в файле
        if (cache.cacheType() == CacheType.FILE) {
            File cacheDirectory = new File(cacheDirectoryPath);
            if (!cacheDirectory.exists()) {
                if (!cacheDirectory.mkdir()) {
                    throw new IOException("Ошибка при создании папки для храния кэша!");
                }
            }
            if (Arrays.asList(cacheDirectory.list()).contains(cacheKey)) {
                result = CacheSerialization.deserialize(cacheDirectoryPath + cacheKey, CacheType.FILE);
                System.out.println("Результат получен из кэша!");
            }
            //Если указано, что кэш должен храниться в памяти
        } else if (cache.cacheType() == CacheType.MEMORY) {
            if (CacheSerialization.checkCache(cacheDirectoryPath + cacheKey)) {
                result = CacheSerialization.deserialize(cacheDirectoryPath + cacheKey, CacheType.MEMORY);
                System.out.println("Результат получен из кэша!");
            }
        }

        //Если не нашли результат в кэше - вызываем метод и сериализовываем результат
        if (result == null) {
            result = method.invoke(delegate, args);
            CacheSerialization.serialize(cacheDirectoryPath + cacheKey, result, cache.cacheType());
        }

        return result;
    }

    private String getCacheKey(String methodName, Object[] args, List<Class> usedArgs) {
        int hashCode = methodName.hashCode();

        for (Object arg : args) {
            if (usedArgs.contains(arg.getClass()) && !usedArgs.isEmpty()) {
                hashCode += arg.hashCode();
            }
        }

        return hashCode + ".ser";
    }
}
