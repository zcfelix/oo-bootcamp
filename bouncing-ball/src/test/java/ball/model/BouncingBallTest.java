package ball.model;

import org.junit.Test;
import ui.BallWorld;

import static ball.model.BallTestHarness.assertCenterYCoordinateIs;
import static ball.model.BallTestHarness.oneStepDownFrom;
import static ball.model.BallTestHarness.oneStepUpFrom;

public class BouncingBallTest {

    @Test
    public void should_go_down() throws Exception {
        Ball bouncingBall = BallFactory.bouncingBall(0, 100, BouncingBall.DOWN);

        bouncingBall.update();;

        assertCenterYCoordinateIs(oneStepDownFrom(100), bouncingBall);
    }

    @Test
    public void should_go_up_after_hitting_the_bottom() throws Exception {
        int theBottomEdge = BallWorld.BOX_HEIGHT - Ball.DEFAULT_RADIUS;
        Ball bouncingBall = BallFactory.bouncingBall(0, theBottomEdge, BouncingBall.DOWN);

        bouncingBall.update();

        assertCenterYCoordinateIs(oneStepUpFrom(theBottomEdge), bouncingBall);
    }

    @Test
    public void should_go_up() throws Exception {
        Ball bouncingBall = BallFactory.bouncingBall(0, 100, BouncingBall.UP);

        bouncingBall.update();

        assertCenterYCoordinateIs(oneStepUpFrom(100), bouncingBall);
    }

    @Test
    public void should_go_down_after_hitting_the_top() throws Exception {
        int theTopEdge = Ball.DEFAULT_RADIUS;
        Ball bouncingBall = BallFactory.bouncingBall(0, theTopEdge, BouncingBall.UP);

        bouncingBall.update();

        assertCenterYCoordinateIs(oneStepDownFrom(theTopEdge), bouncingBall);
    }
}
