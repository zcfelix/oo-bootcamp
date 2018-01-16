import org.junit.Test;

public class FileWriterARMTest {

    @Test
    public void should_close_file_automatically() throws Exception {
        try(final FileWriterARM writer = new FileWriterARM("test.txt")) {
            writer.writeStuff("test");
            System.out.println("done with the resource");
        }
    }
}