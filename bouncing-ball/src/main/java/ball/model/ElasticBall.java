package ball.model;

import java.awt.*;

public class ElasticBall implements Ball {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int x;
    private int y;
    private int radius;
    private int growthDirection;

    public ElasticBall(int x, int y, int radius, int growthDirection) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.growthDirection = growthDirection;
    }

    public ElasticBall(int x, int y, int growthDirection) {
        this(x, y, Ball.DEFAULT_RADIUS, growthDirection);
    }

    @Override
    public int radius() {
        return radius;
    }

    @Override
    public Point center() {
        return new Point(x, y);
    }

    @Override
    public void update() {
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
