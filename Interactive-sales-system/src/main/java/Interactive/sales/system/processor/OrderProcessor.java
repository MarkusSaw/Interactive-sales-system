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

    private final String filePath;
    private final double price;
    private final double discount;
    private final double discountStep;
    private final FileService fileService;
    private final OrderAdapterFactory adapterFactory;
    private final DiscountCalculate discountCalculate;

    public OrderProcessor(String filePath, double price, double discount, double discountStep, FileService fileService, OrderAdapterFactory adapterFactory, DiscountCalculate discountCalculate) {

        this.filePath = filePath;
        this.price = price;
        this.discount = discount;
        this.discountStep = discountStep;
        this.fileService = fileService;
        this.adapterFactory = adapterFactory;
        this.discountCalculate = discountCalculate;
    }


    public void process() throws Exception {
        List<String> lines = fileService.readLines(filePath);
        OrderAdapter adapter = adapterFactory.getAdapter(filePath);
        List<DtoOrder> orders = adapter.adapt(lines);
        Map<String, Double> results = discountCalculate.calculate(orders, price, discount, discountStep);

        fileService.writeResults(results);
    }
}
