package Interactive.sales.system.fileservice;

//Чтение и запись файла

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class FileService {

    public List<String> readLines(String filePath) throws IOException {

        return Files.readAllLines(Paths.get(filePath));
    }


    public void WriteReader(String filePath, Map<String, Double> results) throws IOException {
        List<String> outputLines = results.entrySet().stream()
                .map(e -> e.getKey() + " - " + e.getValue())
                .toList();

        Files.write(Paths.get("result.txt"), outputLines);
    }


}
