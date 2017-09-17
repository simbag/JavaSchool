import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CacheSerialization {
    private static Map<String, byte[]> memoryCache = new HashMap<>();

    public static void serialize(String cacheKey, Object result, CacheType cacheType) throws IOException {
        if (cacheType == CacheType.FILE) {
            try (FileOutputStream fos = new FileOutputStream(cacheKey);
                 ObjectOutputStream out = new ObjectOutputStream(fos)) {
                out.writeObject(result);
            }
        } else if (cacheType == CacheType.MEMORY) {
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 ObjectOutputStream out = new ObjectOutputStream(bos)) {
                out.writeObject(result);
                memoryCache.put(cacheKey, bos.toByteArray());
            }
        }
    }

    public static Object deserialize(String cacheKey, CacheType cacheType) throws IOException, ClassNotFoundException {
        if (cacheType == CacheType.FILE) {
            try (FileInputStream fis = new FileInputStream(cacheKey);
                 ObjectInputStream in = new ObjectInputStream(fis)) {
                return in.readObject();
            }
        } else if (cacheType == CacheType.MEMORY) {
            try (ByteArrayInputStream bis = new ByteArrayInputStream(memoryCache.get(cacheKey));
                 ObjectInputStream in = new ObjectInputStream(bis)) {
                return in.readObject();
            }
        } else {
            throw new IllegalArgumentException("Неверно указан тип кэширования! Доступные типы: CacheType.FILE, CacheType.MEMORY.");
        }
    }

    public static boolean checkCache(String key){
        return memoryCache.containsKey(key);
    }

}
