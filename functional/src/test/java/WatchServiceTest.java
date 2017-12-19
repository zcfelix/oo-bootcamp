import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class WatchServiceTest {

    @Test
    public void should_watch_file_changes() throws IOException, InterruptedException {
        final Path path = Paths.get(".");
        final WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        System.out.println("Report any file changed within next 1 minute...");

        final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
        if (watchKey != null) {
            watchKey.pollEvents()
                    .stream()
                    .forEach(event -> System.out.println(event.context()));
        }
    }
}
