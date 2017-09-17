import java.lang.reflect.Proxy;

public class CacheProxy {
    private final String cacheDirectoryPath;

    public CacheProxy(String cacheDirectoryPath) {
        this.cacheDirectoryPath = cacheDirectoryPath;
    }

    public Service cache(ServiceImpl object) {
        return (Service) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader()
                , new Class[]{Service.class}
                , new CacheHandler(object, cacheDirectoryPath));
    }

}
