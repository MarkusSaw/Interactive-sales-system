package Interactive.sales.system.service;

//Бизнес логика( Чтение, выбор адаптера, подсчёт , записывания в файл)

import Interactive.sales.system.adapter.OrderAdapter;
import Interactive.sales.system.adapter.SelectAdapter;
import Interactive.sales.system.discountservice.DiscountCalculate;
import Interactive.sales.system.fileservice.FileService;
import Interactive.sales.system.adapter.DtoOrder;
import java.util.List;
import java.util.Map;

public class LogicImplementation {



    public static void process(String filePath) throws Exception {


        FileService fileService = new FileService();
        List<String> lines = fileService.readLines(filePath);


        OrderAdapter adapter = SelectAdapter.chooseAdapter(filePath);
        List<DtoOrder> orders = adapter.adapt(lines);



        DiscountCalculate service = new DiscountCalculate();
        Map<String, Double> results = service.calculate(orders);

        fileService.WriteReader("result.txt", results);
    }
}
