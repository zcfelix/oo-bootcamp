import java.util.HashMap;
import java.util.Map;

public class BookStore {

    private Map<Book, Integer> books;

    public BookStore() {
        books = new HashMap<>();
    }

    public void addBooks(Book book, int count) {
        books.merge(book, count, Integer::sum);
    }

    public boolean sellBooks(Book book, int count) {
        if (!books.containsKey(book)) {
            return false;
        } else if (books.get(book) < count) {
            return false;
        } else {
            books.replace(book, books.get(book) - count);
            return true;
        }
    }

    public int curCount(Book book) {
        return books.getOrDefault(book, 0);
    }
}
