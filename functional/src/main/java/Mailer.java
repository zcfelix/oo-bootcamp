import java.util.function.Consumer;

public class Mailer {
    private static StringBuilder builder;

    private Mailer() {
        builder = new StringBuilder();
    }

    public Mailer from(final String from) {
        builder.append("from: ").append(from).append("\n");
        return this;
    }

    public Mailer to(final String to) {
        builder.append("to: ").append(to).append("\n");
        return this;
    }

    public Mailer subject(final String subject) {
        builder.append("subject: ").append(subject).append("\n");
        return this;
    }

    public Mailer body(final String body) {
        builder.append("body: ").append(body).append("\n");
        return this;
    }

    public static void send(final Consumer<Mailer> block) {
        final Mailer mailer = new Mailer();
        block.accept(mailer);
        System.out.println("message sending...\n");
        System.out.println(builder.toString());
    }
}

