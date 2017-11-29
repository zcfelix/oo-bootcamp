package ball.model;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, Bouncing.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Elastic.SHRINK),
                bouncingElasticBall(400, 150, Ball.DEFAULT_RADIUS, Bouncing.UP, Elastic.SHRINK)
        };
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        return new BallImpl(centerX, centerY, Ball.DEFAULT_RADIUS)
                .addBehavior(new Bouncing(direction));
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int growthDirection) {
        return new BallImpl(centerX, centerY, radius)
                .addBehavior(new Elastic(growthDirection));
    }

    public static Ball bouncingElasticBall(int centerX, int centerY, int radius, int direction, int growthDirection) {
        return new BallImpl(centerX, centerY, radius)
                .addBehavior(new Bouncing(direction))
                .addBehavior(new Elastic(growthDirection));
    }
}
