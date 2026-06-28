package Interactive.sales.system.resultwriter;

// Собирает всё воедино и сохраняет результат в файл.

import Interactive.sales.system.adapter.DtoOrder;
import Interactive.sales.system.adapter.hashreaderOrderAdaper;
import Interactive.sales.system.adapter.txtreaderOrderAdapter;
import Interactive.sales.system.discountservice.DiscountCalculate;
import Interactive.sales.system.reader.FileReader;
import Interactive.sales.system.adapter.OrderAdapter;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ResultWriter {

    private static OrderAdapter chooseAdapter(String filePath) {
        if (filePath.endsWith(".txt")) {
            return new txtreaderOrderAdapter();
        } else {
            return new hashreaderOrderAdaper();
        }
    }

    public static void process(String filePath) throws Exception {


        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.readLines(filePath);


        OrderAdapter adapter = chooseAdapter(filePath);
        List<DtoOrder> orders = adapter.adapt(lines);


        DiscountCalculate service = new DiscountCalculate();
        Map<String, Double> results = service.calculate(orders);


        List<String> outputLines = results.entrySet().stream()
                .map(e -> e.getKey() + " - " + e.getValue())
                .toList();

        Files.write(Paths.get("result.txt"), outputLines);
    }
}