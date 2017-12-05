import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarsRoverTest {

    private MarsRover rover;

    @Before
    public void setUp() {
        rover = new MarsRover(new Position(1, 1), "N");
    }

    @Test
    public void should_move_rover_around() {
        assertThat(rover.run("MM"), is("1 3 N"));
    }

    @Test
    public void should_turn_rover_right() {
        assertThat(rover.run("RRR"), is("1 1 W"));
    }

    @Test
    public void should_turn_rover_left() {
        assertThat(rover.run("LLL"), is("1 1 E"));
    }

    @Test
    public void should_circle_around() {
        assertThat(rover.run("MRMRMRMR"), is("1 1 N"));
        assertThat(rover.run("MLMLMLML"), is("1 1 N"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_allow_invalid_input() {
        rover.run("invalid input");
    }
}
