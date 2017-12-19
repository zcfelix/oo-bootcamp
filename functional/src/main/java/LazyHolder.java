import java.util.function.Supplier;

public class LazyHolder {
    private Supplier<Heavy> heavy = () -> createAndCacheHeavy();

    public LazyHolder() {
        System.out.println("lazy holder created...");
    }

    public Heavy getHeavy() {
        return heavy.get();
    }

    public synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy> {

            private final Heavy heavyInstance = new Heavy();

            @Override
            public Heavy get() {
                return heavyInstance;
            }
        }

        if (!HeavyFactory.class.isInstance(heavy)) {
            heavy = new HeavyFactory();
        }

        return heavy.get();
    }
}
