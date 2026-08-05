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

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockOrderProcessorTest {

@Mock
OrderProcessor testingProcessor;

@InjectMocks
String filePath;

@InjectMocks
double price;

@InjectMocks
double discount;

@InjectMocks
double discountStep;

@InjectMocks
FileService fileService;

@InjectMocks
OrderAdapterFactory adapterFactory;

@InjectMocks
DiscountCalculate discountCalculate;




    @Test
    void testingProcess ()throws Exception{
        List<String> lines = fileService.readLines(filePath);
        OrderAdapter adapter = adapterFactory.getAdapter(filePath);
        List<DtoOrder> orders = adapter.adapt(lines);
        Map<String, Double> results = discountCalculate.calculate(orders, price, discount, discountStep);
        when(testingProcessor.process()).thenReturn();
    }
}
