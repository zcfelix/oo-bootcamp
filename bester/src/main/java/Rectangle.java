public class Rectangle implements Compare<Rectangle> {
    private final double width;
    private final double height;

    public Rectangle(final double width, final double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean isBetterThan(Rectangle other) {
        return getRate(this) > getRate(other);
    }

    private static double getRate(Rectangle rectangle) {
        return rectangle.height > rectangle.width ? rectangle.width / rectangle.height : rectangle.height / rectangle.width;
    }

}
