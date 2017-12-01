import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorTest {

    private Author martin;

    @Before
    public void setUp() throws Exception {
        martin = new Author("Martin", Gender.MALE, "martin@thoughtworks.com");
    }

    @Test
    public void should_print_author_info_with_correct_format() throws Exception {
        assertThat(martin.toString(), is("Author[name=Martin, email=martin@thoughtworks.com, gender=Male]"));
        System.out.println(martin);
    }

    @Test
    public void should_author_change_email() throws Exception {
        martin.setEmail("martin@huawei.com");
        assertThat(martin.getEmail(), is("martin@huawei.com"));
    }
}
