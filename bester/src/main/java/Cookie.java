public class Cookie implements Compare<Cookie> {
    private int numberOfChocolates;

    public Cookie(int numberOfChocolates) {
        this.numberOfChocolates = numberOfChocolates;
    }

    @Override
    public boolean isBetterThan(Cookie other) {
        return numberOfChocolates > other.numberOfChocolates;
    }

}
