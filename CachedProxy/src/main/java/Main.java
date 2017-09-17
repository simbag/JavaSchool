import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        CacheProxy cacheProxy = new CacheProxy("src\\main\\resources\\cache\\");

        Service service = cacheProxy.cache(new ServiceImpl());

        System.out.println(service.work("500"));
        System.out.println(service.work("500"));
        System.out.println(service.work("500"));
        System.out.println(service.work("100"));
        System.out.println(service.work("100"));

        System.out.println(service.run("100",5, Date.from(Instant.now())));
        System.out.println(service.run("100",10, Date.from(Instant.now())));
        System.out.println(service.run("100",11, Date.from(Instant.now())));


    }

}
