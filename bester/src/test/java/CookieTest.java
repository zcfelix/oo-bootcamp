import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CookieTest {

    @Test
    public void should_cookie_has_more_chocolates_is_better() throws Exception {
        Cookie cookie1 = new Cookie(1);
        Cookie cookie2 = new Cookie(2);
        assertThat(cookie2.isBetterThan(cookie1), is(true));
    }
}