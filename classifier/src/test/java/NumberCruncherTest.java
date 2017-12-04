import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberCruncherTest {

    private List<Integer> numbers;

    @Before
    public void setUp() throws Exception {
        numbers = asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
    }

    @Test
    public void should_classify_evens() {
        assertThat(NumberCruncher.filterEvens(numbers), is(asList(-4, -2, 0, 2, 4)));
    }

    @Test
    public void should_classify_odds() {
        assertThat(NumberCruncher.filterOdds(numbers), is(asList(-5, -3, -1, 1, 3, 5)));
    }

    @Test
    public void should_classify_negatives() {
        assertThat(NumberCruncher.filterNegatives(numbers), is(asList(-5, -4, -3, -2, -1)));
    }

    @Test
    public void should_classify_positives() {
        assertThat(NumberCruncher.filterPositives(numbers), is(asList(1, 2, 3, 4, 5)));
    }
}