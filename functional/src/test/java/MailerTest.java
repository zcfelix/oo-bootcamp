import org.junit.Test;

public class MailerTest {


    @Test
    public void should_send_mail_with_block() {
        Mailer.send(mailer -> mailer.from("ybzhou@thoughtworks.com")
                .to("zc_felix@qq.com")
                .subject("test mailer")
                .body("cool loan pattern"));
    }
}
