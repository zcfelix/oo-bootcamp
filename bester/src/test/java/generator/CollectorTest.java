package generator;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CollectorTest {

    @Test
    public void should_collect_coffee_and_fruit() throws Exception {
        Generator<Coffee> coffeeGenerator = new CoffeeGenerator();
        Generator<Fruit> fruitGenerator = new FruitGenerator();

        List<Coffee> coffees = Collector.collect(coffeeGenerator, 6);
        assertThat(coffees.size(), is(6));
        System.out.println(coffees);

        List<Fruit> fruits = Collector.collect(fruitGenerator, 4);
        assertThat(fruits.size(), is(4));
        System.out.println(fruits);
    }
}
