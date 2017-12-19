import org.junit.Test;

import java.util.List;

public class PrimeFactoryTest {

    @Test
    public void should_find_primes() {
        List<Integer> primes = PrimeFactory.primes(2, 100);
        System.out.println(primes);
    }
}