package Interactive.sales.system.discountservice;

// Считает стоимость заказов со скидками.

import Interactive.sales.system.adapter.DtoOrder;
import Interactive.sales.system.setparameters.SetParameters;
import java.util.*;

public class DiscountCalculate {

    public Map<String, Double> calculate(List<DtoOrder> orders , double price , double discount , double discountStep) {


        List<DtoOrder> sortedOrders = new ArrayList<>(orders);

        Map<String, Double> result = new LinkedHashMap<>();
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
}

