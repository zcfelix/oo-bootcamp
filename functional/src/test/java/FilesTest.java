import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesTest {

    @Test
    public void should_list_all_files_of_current_directory() throws IOException {
        Files.list(Paths.get(".")).forEach(System.out::println);
    }

    @Test
    public void should_list_and_filter_files() throws IOException {
        Files.newDirectoryStream(Paths.get("."), path -> path.toString().endsWith(".iml")).forEach(System.out::println);
    }
}
