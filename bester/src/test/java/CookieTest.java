import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CookieTest {

    private Cookie cookie1;
    private Cookie cookie2;
    private Cookie cookie3;

    @Before
    public void setUp() throws Exception {
        cookie1 = new Cookie(1);
        cookie2 = new Cookie(2);
        cookie3 = new Cookie(3);
    }

    @Test
    public void should_cookie_has_more_chocolates_is_better() throws Exception {
        assertThat(cookie2.isBetterThan(cookie1), is(true));
    }

    @Test
    public void should_cookie_is_best_when_has_most_chocolates() throws Exception {
        assertThat(Cookie.bestOne(asList(cookie1, cookie2, cookie3)), is(cookie3));
    }
}