import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BesterTest {

    private Cookie cookie1;
    private Cookie cookie2;
    private Cookie cookie3;
    private Rectangle r1;
    private Rectangle r2;
    private Rectangle r3;

    @Before
    public void setUp() throws Exception {
        cookie1 = new Cookie(10);
        cookie2 = new Cookie(20);
        cookie3 = new Cookie(30);

        r1 = new Rectangle(10, 11);
        r2 = new Rectangle(10, 12);
        r3 = new Rectangle(10, 13);
    }

    @Test
    public void should_find_best_cookie() throws Exception {
        assertThat(Bester.bestOne(asList(cookie1, cookie2, cookie3)), is(cookie3));
    }

    @Test
    public void should_find_best_rectangle() throws Exception {
        assertThat(Bester.bestOne(asList(r1, r2, r3)), is(r1));
    }
}