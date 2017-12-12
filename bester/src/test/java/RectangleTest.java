import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RectangleTest {

    private Rectangle good;
    private Rectangle better;
    private Rectangle best;

    @Before
    public void setUp() throws Exception {
        good = new Rectangle(4, 30);
        better = new Rectangle(4, 20);
        best = new Rectangle(4, 10);
    }

    @Test
    public void should_rectangle_better_when_closer_to_square() throws Exception {
        assertThat(good.isBetterThan(better), is(false));
        assertThat(best.isBetterThan(better), is(true));
    }

    @Test
    public void should_find_best_rectangle_which_closest_to_square() throws Exception {
        assertThat(Bester.findBest(asList(good, better, best)), is(best));
    }
}
