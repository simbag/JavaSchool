
import java.util.Date;
import java.util.List;

interface Service {
    @Cache(cacheType = CacheType.FILE, identityBy = {String.class})
    List<String> run(String item, double value, Date date);

    @Cache(cacheType = CacheType.MEMORY)
    List<String> work(String item);
}
