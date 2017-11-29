import java.util.List;

public class Bester {
    public static <T extends Compare<T>> T findBest(List<T> objs) {
        return objs.stream().reduce((x, y) -> x.isBetterThan(y) ? x : y).get();
    }
}
