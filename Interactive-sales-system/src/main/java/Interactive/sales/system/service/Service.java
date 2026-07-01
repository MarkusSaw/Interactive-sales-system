package Interactive.sales.system.service;

//Бизнес логика

import Interactive.sales.system.adapter.DtoOrder;
import Interactive.sales.system.adapter.HashReaderOrderAdapter;
import Interactive.sales.system.adapter.OrderAdapter;
import Interactive.sales.system.adapter.TXTReaderOrderAdapter;
import Interactive.sales.system.discountservice.DiscountCalculate;
import Interactive.sales.system.fileservice.FileService;
import Interactive.sales.system.setparameters.SetParameters;

import java.util.List;
import java.util.Map;

import static Interactive.sales.system.setparameters.SetParameters.Inputparameters.price;

public class Service {

    private static OrderAdapter chooseAdapter(String filePath) {
        if (filePath.endsWith(".txt")) {
            return new TXTReaderOrderAdapter();
        } else {
            return new HashReaderOrderAdapter();
        }
    }

    public static void process(String filePath) throws Exception {


        FileService fileService = new FileService();
        List<String> lines = fileService.readLines(filePath);


        OrderAdapter adapter = chooseAdapter(filePath);
        List<DtoOrder> orders = adapter.adapt(lines);



        DiscountCalculate service = new DiscountCalculate();
        double price = SetParameters.Inputparameters.price.getValue();
        double discount = SetParameters.Inputparameters.discount.getValue();
        double discountStep = SetParameters.Inputparameters.discountstep.getValue();
        Map<String, Double> results = service.calculate(orders, price, discount, discountStep );


    }
}
