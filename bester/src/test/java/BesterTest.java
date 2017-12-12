import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BesterTest {

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
    public void should_find_best_cookie() throws Exception {
        assertThat(Bester.findBest(asList(good, better, best)), is(best));
    }
}