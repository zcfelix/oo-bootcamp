public class Cookie {
    private int numberOfChocolates;

    public Cookie(int numberOfChocolates) {
        this.numberOfChocolates = numberOfChocolates;
    }

    public boolean isBetterThan(Cookie other) {
        return numberOfChocolates > other.numberOfChocolates;
    }
}
