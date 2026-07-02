package Interactive.sales.system.discountservice;

// Абстрактный класс для шаблона для вызова метода калькулятор из любового класса.

import Interactive.sales.system.adapter.DtoOrder;
import java.util.*;

public abstract class TemplateCalculate {

    public final Map<String,Double> calculate(List<DtoOrder> orders) {
        List<DtoOrder> sortedOrders = new ArrayList<>(orders);
        Map<String, Double> result = new LinkedHashMap<>();

        double price = getPrice();
        double discount = getDiscount();
        double discountStep = getDiscountStep();

        double currentDiscount = discount;

        for (DtoOrder order : sortedOrders) {
            double cost = order.getQuantityKg() * price * (100 - currentDiscount) / 100;
            String company = order.getCompanyName();
            result.put(company, result.getOrDefault(company, 0.0) + cost);

            currentDiscount -= discountStep;
            if (currentDiscount < 0) {
                currentDiscount = 0;
            }
        }

        return result;
    }

    public abstract double getPrice();
    public abstract double getDiscount();
    public abstract double getDiscountStep();
}
