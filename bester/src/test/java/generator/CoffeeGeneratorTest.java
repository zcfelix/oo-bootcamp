package generator;

import org.junit.Test;

public class CoffeeGeneratorTest {

    @Test
    public void should_generate_nex_coffee() throws Exception {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
        System.out.println(coffeeGenerator.next());
        System.out.println(coffeeGenerator.next());
        System.out.println(coffeeGenerator.next());
    }
}
