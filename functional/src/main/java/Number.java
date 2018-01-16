import java.util.function.Function;
import java.util.stream.IntStream;

public class Number {
    public int sum(int a, int b) {
        return IntStream.rangeClosed(a, b).sum();
    }

    public int sumOfSquare(int a, int b) {
        return IntStream.rangeClosed(a, b).map(x -> x * x).sum();
    }

    public int sumOfCube(int a, int b) {
        return IntStream.rangeClosed(a, b).map(x -> x * x * x).sum();
    }

    public static int sum(int a, int b, Function<Integer, Integer> option) {
        return IntStream.rangeClosed(a, b).map(option::apply).sum();
    }
}
