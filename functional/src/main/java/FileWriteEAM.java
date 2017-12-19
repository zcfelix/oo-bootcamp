import java.io.FileWriter;
import java.io.IOException;

public class FileWriteEAM {
    private final FileWriter writer;

    private FileWriteEAM(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    private void close() throws IOException {
        System.out.println("close calling automatically");
        writer.close();
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public static void use(final String fileName, final UseInstance<FileWriteEAM, IOException> block) throws IOException{
        final FileWriteEAM writeEAM = new FileWriteEAM(fileName);
        try {
            block.accept(writeEAM);
        } finally {
            writeEAM.close();
        }
    }
}
