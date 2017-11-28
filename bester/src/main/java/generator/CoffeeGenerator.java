package generator;

import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee> {

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class};
    private static Random rand = new Random(System.currentTimeMillis());

    @Override
    public Coffee next() {
        Coffee coffee = null;
        try {
            coffee = (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coffee;
    }
}
