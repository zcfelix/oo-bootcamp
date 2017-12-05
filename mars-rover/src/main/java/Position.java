public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void updateX(int step) {
        x += step;
    }

    public void updateY(int step) {
        y += step;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
