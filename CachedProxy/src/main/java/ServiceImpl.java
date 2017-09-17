import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ServiceImpl implements Service, Serializable {

    public List<String> run(String item, double value, Date date) {
        List<String> result = new ArrayList<>();
        if (value == 5) {
            result.add(item + " " + date.toString());
        }
        return result;
    }

    public List<String> work(String item) {
        return Arrays.asList(item);
    }
}
