public class Rectangle implements Compare<Rectangle> {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean isBetterThan(Rectangle other) {
        return this.rate() > other.rate();
    }

    private double rate() {
        return height < width ? height / width : width / height;
    }

}
