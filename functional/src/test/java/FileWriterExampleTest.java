import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class FileWriterExampleTest {

    @Test
    public void should_write_file() throws IOException {
        final FileWriterExample writer = new FileWriterExample("test.txt");
        writer.writeStuff("hello");
//        writer.close();
    }

    @Test
    public void should_file_arm_close_automatic() throws IOException {
    }
}