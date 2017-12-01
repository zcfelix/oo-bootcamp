import java.util.HashMap;
import java.util.Map;

public class Customer extends Person{
    private Map<Book, Integer> myBooks;

    public Customer(String name, Gender gender, String email) {
        super(email, name, gender);
        myBooks = new HashMap<>();
    }

    public boolean buyBooks(BookStore bookStore, Book book, int count) {
        if (bookStore.sellBooks(book, count)) {
            myBooks.merge(book, count, Integer::sum);
            return true;
        }
        return false;
    }

    public boolean buyBook(BookStore bookStore, Book book) {
        return buyBooks(bookStore, book, 1);
    }

    public int curCount(Book book) {
        return myBooks.getOrDefault(book, 0);
    }

    @Override
    public String toString() {
        return String.format("Customer[name=%s, email=%s, gender=%s]", name, email, gender);
    }

}
