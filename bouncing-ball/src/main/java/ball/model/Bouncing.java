package ball.model;

import ui.BallWorld;

public class Bouncing implements Behavior{
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private int direction;

    public Bouncing(int direction) {
        this.direction = direction;
    }

    @Override
    public void update(BallImpl ball) {
        direction = reverseDirectionIfNecessary(ball);
        ball.setY(move(ball));
    }

    /*******************************************************************
     *
     * Do not change bouncing ALGORITHM below.
     *
     ******************************************************************/
    private int reverseDirectionIfNecessary(BallImpl ball) {
        if (movingTooHigh(ball) || movingTooLow(ball)) {
            return switchDirection();
        }
        return this.direction;
    }

    private boolean movingTooLow(BallImpl ball) {
        return ball.center().y + ball.radius() >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh(BallImpl ball) {
        return ball.center().y - ball.radius() <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private int move(BallImpl ball) {
        return ball.center().y + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }
}
