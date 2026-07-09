import Interactive.sales.system.discountservice.DiscountCalculate;
import Interactive.sales.system.dto.DtoOrder;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountCalculateTest {

    private final DiscountCalculate discountCalculate = new DiscountCalculate();

    @Test
    void testCalculator() {

        DtoOrder order = new DtoOrder(LocalDateTime.now(), "Broke Company", 1000);

        List<DtoOrder> orders = Arrays.asList(order);

        Map<String, Double> result = discountCalculate.calculate(orders, 10.0, 50.0, 5.0);

        assertEquals(5000.0, result.get("Broke Company"), 0.01);
    }


}
