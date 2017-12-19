import org.junit.Test;

import java.io.IOException;

public class FileWriteEAMTest {

    @Test
    public void should_write_file_and_close() throws IOException {
        FileWriteEAM.use("cool-writer.txt", file -> file.writeStuff("cool instance"));
    }
}