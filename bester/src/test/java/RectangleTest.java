import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void should_rectangle_be_better_when_height_closer_to_width() throws Exception {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(4, 10);
        assertThat(r1.isBetterThan(r2), is(true));
    }
}