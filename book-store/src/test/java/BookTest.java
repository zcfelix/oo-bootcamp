import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookTest {

    private Author martin;

    @Before
    public void setUp() throws Exception {
        martin = new Author("Martin", Gender.MALE, "martin@thoughtworks.com");
    }

    @Test
    public void should_print_book_info_with_correct_format() throws Exception {
        Book refactoring = new Book("Refactoring", martin, 49.80d);
        assertThat(refactoring.toString(), is("Book[name=Refactoring, " +
                "Author[name=Martin, email=martin@thoughtworks.com, gender=Male], price=¥49.80]"));
        System.out.println(refactoring);
    }
}
