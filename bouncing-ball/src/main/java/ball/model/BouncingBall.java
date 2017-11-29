package ball.model;

import ui.BallWorld;

import java.awt.*;

public class BouncingBall implements Ball {
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    protected int x;
    protected int y;
    protected int radius;
    protected int direction;

    public BouncingBall(int x, int y, int radius, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.direction = direction;
    }

    public BouncingBall(int x, int y, int direction) {
        this(x, y, Ball.DEFAULT_RADIUS, direction);
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
        direction = reverseDirectionIfNecessary();
        y = move();
    }

    /*******************************************************************
     *
     * Do not change bouncing ALGORITHM below.
     *
     ******************************************************************/
    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirection();
        }
        return this.direction;
    }

    private boolean movingTooLow() {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return y - radius <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private int move() {
        return y + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }
}
