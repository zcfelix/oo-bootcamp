import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEAM2 {
    private final FileWriter writer;

    private FileWriterEAM2(String fileName) throws IOException {
        this.writer = new FileWriter(fileName);
    }

    public void close() throws IOException {
        System.out.println("close automatically...");
        writer.close();
    }

    public static void use(String fileName, UseInstance<FileWriterEAM2, IOException> block) throws IOException {
        final FileWriterEAM2 writerEAM2 = new FileWriterEAM2(fileName);
        try {
            block.accept(writerEAM2);
        } finally {
            writerEAM2.close();
        }
    }
}
