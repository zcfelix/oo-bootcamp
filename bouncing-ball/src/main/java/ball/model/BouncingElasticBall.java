package ball.model;

public class BouncingElasticBall extends BouncingBall {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection;

    public BouncingElasticBall(int x, int y, int radius, int direction, int growthDirection) {
        super(x, y, radius, direction);
        this.growthDirection = growthDirection;
    }

    public BouncingElasticBall(int x, int y, int direction, int growthDirection) {
        super(x, y, direction);
        this.growthDirection = growthDirection;
    }

    @Override
    public void update() {
        super.update();
        growthDirection = reverseGrowthDirectionIfNecessary();
        radius = next();
    }

    /*******************************************************************
     *
     * Do not change elastic ALGORITHM below.
     *
     ******************************************************************/
    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }
        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return radius >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next() {
        return radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}
