import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RectangleTest {

    private Rectangle r1;
    private Rectangle r2;
    private Rectangle r3;

    @Before
    public void setUp() throws Exception {
        r1 = new Rectangle(4, 5);
        r2 = new Rectangle(4, 10);
        r3 = new Rectangle(4, 20);
    }

    @Test
    public void should_rectangle_be_better_when_height_closer_to_width() throws Exception {
        assertThat(r1.isBetterThan(r2), is(true));
    }

    @Test
    public void should_rectangle_best_when_height_is_closest_to_width() throws Exception {
        assertThat(Bester.bestOne(asList(r1, r2, r3)), is(r1));
    }
}