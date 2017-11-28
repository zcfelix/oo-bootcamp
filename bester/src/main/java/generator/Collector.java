package generator;

import java.util.ArrayList;
import java.util.List;

public class Collector {
    public static  <T> List<T> collect(Generator<T> generator, int num) {
        List<T> ret = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            ret.add(generator.next());
        }
        return ret;
    }
}
