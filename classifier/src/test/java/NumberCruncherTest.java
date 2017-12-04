import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberCruncherTest {

    private NumberCruncher cruncher;
    @Before
    public void setUp() {
        cruncher = new NumberCruncher(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
    }

    @Test
    public void should_count_evens() {
        assertThat(cruncher.countEvens(), is(5));
    }
    

    @Test
    public void should_count_odds() {
        assertThat(cruncher.countOdds(), is(6));
    }

    @Test
    public void should_count_negatives() {
        assertThat(cruncher.countNegatives(), is(5));
    }

    @Test
    public void should_count_positives() {
        assertThat(cruncher.countPositives(), is(5));
    }
}