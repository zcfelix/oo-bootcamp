import java.util.ArrayList;
import java.util.List;

public class NumberCruncher {
    public static List<Integer> filterEvens(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : numbers) {
            if (i % 2 == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> filterOdds(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : numbers) {
            if (i % 2 != 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> filterPositives(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : numbers) {
            if (i > 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> filterNegatives(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : numbers) {
            if (i < 0) {
                list.add(i);
            }
        }
        return list;
    }
}
