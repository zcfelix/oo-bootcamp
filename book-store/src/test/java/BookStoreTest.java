import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookStoreTest {

    private BookStore bookStore;
    private Author author;
    private Book book;

    @Before
    public void setUp() throws Exception {
        author = new Author("Martin", Gender.MALE, "martin@thoughtworks.com");
        book = new Book("Refactoring", author, 49.80d);
        bookStore = new BookStore();
    }

    @Test
    public void should_book_store_add_books() throws Exception {
        bookStore.addBooks(book, 10);
        assertThat(bookStore.curCount(book), is(10));
        bookStore.addBooks(book, 9);
        assertThat(bookStore.curCount(book), is(19));
    }

    @Test
    public void should_book_store_sell_books() throws Exception {
        bookStore.addBooks(book, 10);
        assertThat(bookStore.curCount(book), is(10));
        bookStore.sellBooks(book, 1);
        assertThat(bookStore.curCount(book), is(9));
    }

}
