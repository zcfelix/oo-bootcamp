import java.util.List;

public class Cookie {
    private int numberOfChocolates;

    public Cookie(int numberOfChocolates) {
        this.numberOfChocolates = numberOfChocolates;
    }

    public boolean isBetterThan(Cookie other) {
        return numberOfChocolates > other.numberOfChocolates;
    }

    public static Cookie bestOne(List<Cookie> cookies) {
        return cookies.stream().reduce((x, y) -> x.isBetterThan(y) ? x : y).get();
    }
}
