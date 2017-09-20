import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {
    private Collection<T> collection;

    private Streams(Collection<T> collection) {
        this.collection = collection;
    }

    public static <T> Streams<T> of(List<T> list) {
        return new Streams<>(new ArrayList<>(list));
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        for (T item : collection) {
            if (predicate.test(item)) {
                collection.remove(item);
            }
        }
        return this;
    }

    public <R> Streams<R> transform(Function<? super T, ? extends R> function) {
        List<R> list = new ArrayList<>();
        for (T item : collection) {
            list.add(function.apply(item));
        }
        return new Streams<>(list);
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> key, Function<? super T, ? extends V> value) {
        Map<K, V> map = new HashMap<>();
        for (T item : collection) {
            map.put(key.apply(item), value.apply(item));
        }
        return map;
    }
}
