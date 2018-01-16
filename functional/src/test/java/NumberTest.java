import org.junit.Test;

public class NumberTest {

    @Test
    public void should_sum_all_the_numbers() {
        final int sum = Number.sum(1, 3, x -> x * x);
        System.out.println(sum);
    }
}