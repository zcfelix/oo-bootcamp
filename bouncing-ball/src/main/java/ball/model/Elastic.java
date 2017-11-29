package ball.model;

public class Elastic implements Behavior {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection;

    public Elastic(int growthDirection) {
        this.growthDirection = growthDirection;
    }

    @Override
    public void update(BallImpl ball) {
        int radius = ball.radius();
        growthDirection = reverseGrowthDirectionIfNecessary(radius);
        ball.setRadius(next(radius));
    }

    /*******************************************************************
     *
     * Do not change elastic ALGORITHM below.
     *
     ******************************************************************/
    private int reverseGrowthDirectionIfNecessary(int radius) {
        if (growingTooBig(radius) || shrinkingTooSmall(radius)) {
            return switchDirection();
        }
        return this.growthDirection;
    }

    private boolean shrinkingTooSmall(int radius) {
        return radius <= 0 && shrinking();
    }

    private boolean growingTooBig(int radius) {
        return radius >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next(int radius) {
        return radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}
