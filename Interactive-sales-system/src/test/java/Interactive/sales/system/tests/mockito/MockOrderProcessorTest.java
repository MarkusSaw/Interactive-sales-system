package Interactive.sales.system.tests.mockito;


import Interactive.sales.system.adapter.OrderAdapter;
import Interactive.sales.system.adapter.OrderAdapterFactory;
import Interactive.sales.system.discountservice.DiscountCalculate;
import Interactive.sales.system.dto.DtoOrder;
import Interactive.sales.system.fileservice.FileService;
import Interactive.sales.system.processor.OrderProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockOrderProcessorTest {


    @Test
    void testingProcess ()throws Exception{
        String filePath = "result.txt";
        double price = 10.0;
        double discount = 50.0;
        double discountStep = 5.0;
        List<String> lines = List.of("Broke Company, 1000");
        List<DtoOrder> orders = List.of(new DtoOrder(LocalDateTime.now(), "Broke Company", 1000));
        Map<String, Double> results = Map.of("Broke Company", 5000.0);


        FileService fileService = mock(FileService.class);
        OrderAdapter adapter = mock(OrderAdapter.class);
        OrderAdapterFactory adapterFactory = mock(OrderAdapterFactory.class);
        DiscountCalculate discountCalculate = mock(DiscountCalculate.class);

        OrderProcessor processor = new OrderProcessor(
                filePath, price, discount, discountStep,
                fileService, adapterFactory, discountCalculate
        );


        when(fileService.readLines(filePath)).thenReturn(lines);
        when( adapterFactory.getAdapter(filePath)).thenReturn(adapter);
        when(adapter.adapt(lines)).thenReturn(orders);
        when(discountCalculate.calculate(orders, price, discount, discountStep)).thenReturn(results);

        processor.process();

        verify(fileService).readLines(filePath);
        verify(adapterFactory).getAdapter(filePath);
        verify(adapter).adapt(lines);
        verify(discountCalculate).calculate(orders, price, discount, discountStep);

    }
}
