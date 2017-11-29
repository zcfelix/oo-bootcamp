package ball.model;

import org.junit.Test;

import static ball.model.BallTestHarness.assertRadiusIs;
import static ball.model.BallTestHarness.oneStepInwardsFrom;
import static ball.model.BallTestHarness.oneStepOutwardsFrom;

public class ElasticBallTest {

    @Test
    public void should_decrease_radius() throws Exception {
        Ball elasticBall = BallFactory.elasticBall(0, 0, 20, ElasticBall.SHRINK);

        elasticBall.update();

        assertRadiusIs(oneStepInwardsFrom(20), elasticBall);
    }

    @Test
    public void should_increase_radius_after_fully_shrinking() throws Exception {
        Ball elasticBall = BallFactory.elasticBall(0, 0, 0, ElasticBall.SHRINK);

        elasticBall.update();

        assertRadiusIs(oneStepOutwardsFrom(0), elasticBall);
    }

    @Test
    public void should_increase_radius() throws Exception {
        Ball elasticBall = BallFactory.elasticBall(250, 100, 20, ElasticBall.GROW);

        elasticBall.update();

        assertRadiusIs(oneStepOutwardsFrom(20), elasticBall);
    }

    @Test
    public void should_decrease_radius_after_fully_expanding() throws Exception {
        Ball elasticBall = BallFactory.elasticBall(0, 0, Ball.DEFAULT_RADIUS, ElasticBall.GROW);

        elasticBall.update();

        assertRadiusIs(oneStepInwardsFrom(Ball.DEFAULT_RADIUS), elasticBall);
    }
}
