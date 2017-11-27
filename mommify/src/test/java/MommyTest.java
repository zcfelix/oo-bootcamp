import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class MommyTest {
    private Mommy mommy;

    @Before
    public void setUp() throws Exception {
        mommy = new Mommy();
    }

    @Test
    public void should_return_null_when_input_is_null() throws Exception {
        assertThat(mommy.mommify(null), is(nullValue()));
    }

    @Test
    public void should_return_empty_string_when_input_is_empty() throws Exception {
        assertThat(mommy.mommify(""), is(""));
    }

    @Test
    public void should_return_mommy_when_input_is_vowel() throws Exception {
        assertThat(mommy.mommify("a"), is("mommy"));
        assertThat(mommy.mommify("e"), is("mommy"));
        assertThat(mommy.mommify("i"), is("mommy"));
        assertThat(mommy.mommify("o"), is("mommy"));
        assertThat(mommy.mommify("u"), is("mommy"));
    }

    @Test
    public void should_return_input_when_input_is_not_vowel() throws Exception {
        assertThat(mommy.mommify("s"), is("s"));
    }

    @Test
    public void should_replace_vowel_when_input_contains_vowel() throws Exception {
        assertThat(mommy.mommify("wo"), is("wmommy"));
    }

    @Test
    public void should_replace_continuous_vowels_with_only_one_mommy() throws Exception {
        assertThat(mommy.mommify("whoohoo"), is("whmommyhmommy"));
    }

    @Test
    public void should_not_replace_vowels_when_vowels_num_less_than_or_equal_to_one_third_of_input() throws Exception {
        assertThat(mommy.mommify("abc"), is("abc"));
    }

    @Test
    public void should_replace_all_vowels_when_vowels_are_not_continuous() throws Exception {
        assertThat(mommy.mommify("banana"), is("bmommynmommynmommy"));
    }
}