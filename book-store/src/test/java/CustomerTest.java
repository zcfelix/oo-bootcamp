import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerTest {

    private Author martin;
    private Book book;
    private BookStore bookStore;
    private Customer felix;

    @Before
    public void setUp() throws Exception {
        martin = new Author("Martin", Gender.MALE, "martin@thoughtworks.com");
        book = new Book("Refactoring", martin, 49.80d);
        bookStore = new BookStore();
        bookStore.addBooks(book, 10);
        felix = new Customer("Felix", Gender.MALE, "ybzhou@thoughtworks.com");
    }

    @Test
    public void should_print_customer_info_with_correct_format() throws Exception {
        assertThat(felix.toString(), is("Customer[name=Felix, email=ybzhou@thoughtworks.com, gender=Male]"));
        System.out.println(felix);
    }

    @Test
    public void should_customer_buy_book() throws Exception {
        assertThat(felix.curCount(book), is(0));
        felix.buyBook(bookStore, book);
        assertThat(felix.curCount(book), is(1));
    }
}
