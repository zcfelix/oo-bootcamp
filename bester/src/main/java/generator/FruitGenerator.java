package generator;

public class FruitGenerator implements Generator<Fruit> {

    public Class curType = Apple.class;

    @Override
    public Fruit next() {
        Fruit fruit = null;
        try {
            fruit = (Fruit) curType.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        curType = curType == Apple.class ? Banana.class : Apple.class;
        return fruit;
    }
}
