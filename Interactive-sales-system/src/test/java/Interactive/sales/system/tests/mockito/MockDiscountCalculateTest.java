package Interactive.sales.system.tests.mockito;

import Interactive.sales.system.discountservice.DiscountCalculate;
import Interactive.sales.system.dto.DtoOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockDiscountCalculateTest {

    @Mock
    DiscountCalculate calculatemock;

    @Test
    void mockTestingCalculate() {
        DtoOrder order = new DtoOrder(LocalDateTime.now(), "Broke Company", 1000);
        List<DtoOrder> orders = List.of(order);
        Map<String, Double> result = new LinkedHashMap<>();
        result.put("Broke Company", 5000.0);

        when(calculatemock.calculate(orders, 10.0, 50.0, 5.0)).thenReturn(result);

        Map<String, Double> actualResult = calculatemock.calculate(orders, 10.0, 50.0, 5.0);

        assertEquals(5000.0, actualResult.get("Broke Company"), 0.01);

        verify(calculatemock).calculate(orders, 10.0, 50.0, 5.0);

    }
}
