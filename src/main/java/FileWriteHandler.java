import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteHandler {
    FileWriter fw;
    File file;

    public FileWriteHandler(FileWriter fw, File file) {
        this.fw = fw;
        this.file = file;
    }

    public void writer(String line) throws IOException {
        fw = new FileWriter(file, true);
        fw.write(line);
    }

    public void close () throws IOException {
        fw.close();
    }
}
