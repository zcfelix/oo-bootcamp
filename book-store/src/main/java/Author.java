public class Author extends Person {

    public Author(String name, Gender gender, String email) {
        super(email, name, gender);
    }

    @Override
    public String toString() {
        return String.format("Author[name=%s, email=%s, gender=%s]", name, email, gender);
    }

}
