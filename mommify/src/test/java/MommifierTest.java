import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MommifierTest {
    private Mommifier mommifier;

    @Before
    public void setUp() throws Exception {
        mommifier = new Mommifier();
    }

    @Test
    public void should_return_empty_string_when_input_is_empty() throws Exception {
        assertThat(mommifier.mommify(""), is(""));
    }
}