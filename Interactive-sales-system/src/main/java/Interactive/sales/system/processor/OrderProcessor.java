package Interactive.sales.system.processor;

//Бизнес логика( Принимаем из мейна цену , скидку , шаг затем Чтение, выбор адаптера, подсчёт , записывания в файл)

import Interactive.sales.system.adapter.OrderAdapter;
import Interactive.sales.system.adapter.OrderAdapterFactory;
import Interactive.sales.system.discountservice.DiscountCalculate;
import Interactive.sales.system.fileservice.FileService;
import Interactive.sales.system.dto.DtoOrder;
import java.util.List;
import java.util.Map;

public class OrderProcessor {


    public static void process(String filePath, double price, double discount, double discountStep) throws Exception {


        FileService fileService = new FileService();
        List<String> lines = fileService.readLines(filePath);


        OrderAdapter adapter = OrderAdapterFactory.getAdapter(filePath);
        List<DtoOrder> orders = adapter.adapt(lines);


        DiscountCalculate service = new DiscountCalculate();
        Map<String, Double> results = service.calculate(orders, price, discount, discountStep);

        fileService.WriteReader("result.txt", results);
    }
}
