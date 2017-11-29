package ball.model;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, BouncingBall.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, ElasticBall.SHRINK),
                bouncingElasticBall(400, 150, Ball.DEFAULT_RADIUS, BouncingBall.UP, ElasticBall.SHRINK)
        };
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        return new BouncingBall(centerX, centerY, Ball.DEFAULT_RADIUS, direction);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        return new ElasticBall(centerX, centerY, radius, direction);
    }

    public static Ball bouncingElasticBall(int centerX, int centerY, int radius, int direction, int growthDirection) {
        return new BouncingElasticBall(centerX, centerY, radius, direction, growthDirection);
    }
}
