import static java.lang.Math.sqrt;
import static java.util.stream.LongStream.range;
import static java.util.stream.LongStream.rangeClosed;

public class Prime {

    public long countPrimes(int max) {
        return range(1, max).parallel().filter(this::isPrime).count();
    }

    private boolean isPrime(long n) {
        return n > 1 && rangeClosed(2, (long) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }
}
