import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EuroTest {

    private Euro euro1;
    private Euro euro2;

    @Before
    public void setUp() throws Exception {
        euro1 = new Euro(5);
        euro2 = new Euro(5);
    }

    @Test
    public void should_5_euro_equals_5_euro() throws Exception {
        assertThat(euro1.equals(euro2), is(true));
    }
}
