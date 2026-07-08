package Interactive.sales.system;

// Точка входа в программу, вносим сюда числа для расчёта,потом открывает отсюда файл и потом создаёт результат.

import Interactive.sales.system.configuration.ApplicationPropertiesConfiguration;
import Interactive.sales.system.processor.OrderProcessor;
import Interactive.sales.system.adapter.OrderAdapterFactory;
import Interactive.sales.system.discountservice.DiscountCalculate;
import Interactive.sales.system.fileservice.FileService;


public class Main {

    public static void main(String[] args) throws Exception {
        // String filePath = "C:\\Users\\user\\IdeaProjects\\Планировщик задач приложение\\gfree\\Hibernate Example\\Interactive-sales-system\\discount_day.txt";

        String filePath = ApplicationPropertiesConfiguration.getString("file.path");
        double price = ApplicationPropertiesConfiguration.getDouble("price");
        double discount = ApplicationPropertiesConfiguration.getDouble("discount");
        double discountStep = ApplicationPropertiesConfiguration.getDouble("discount.step");

        FileService fileService = new FileService();
        OrderAdapterFactory factory = new OrderAdapterFactory();
        DiscountCalculate service = new DiscountCalculate();

        OrderProcessor processor = new OrderProcessor(filePath, price, discount, discountStep, fileService, factory, service);
        processor.process();

        System.out.println("Результат в result.txt");
    }
}
