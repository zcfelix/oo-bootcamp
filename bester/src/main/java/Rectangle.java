import java.util.List;

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(final int width, final int height) {
        this.width = width;
        this.height = height;
    }


    public boolean isBetterThan(Rectangle other) {
        return Math.abs(width - height) < Math.abs(other.width - other.height);
    }

    public static Rectangle bestOne(List<Rectangle> rectangles) {
        return rectangles.stream().reduce((x, y) -> x.isBetterThan(y) ? x : y).get();
    }
}
