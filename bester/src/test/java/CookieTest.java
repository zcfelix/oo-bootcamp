import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CookieTest {

    private Cookie good;
    private Cookie better;
    private Cookie best;

    @Before
    public void setUp() throws Exception {
        good = new Cookie(10);
        better = new Cookie(20);
        best = new Cookie(30);
    }

    @Test
    public void should_cookie_has_more_chocolates_is_better() throws Exception {
        assertThat(better.isBetterThan(good), is(true));
        assertThat(better.isBetterThan(best), is(false));
    }

    @Test
    public void should_find_best_cookie_with_most_chocolates() throws Exception {
        assertThat(Bester.findBest(asList(good, better, best)), is(best));
    }
}