import java.util.Arrays;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countWith(final Classifier classifier1) {
        return (int) Arrays.stream(numbers).filter(x -> classifier1.classify(x)).count();
    }

}
