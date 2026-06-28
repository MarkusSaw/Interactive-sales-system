package Interactive.sales.system.reader;

// Читает файл и возвращает список строк.

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class FileReader {

    public List<String> readLines(String filePath) throws IOException {

        return Files.readAllLines(Paths.get(filePath));
    }
}