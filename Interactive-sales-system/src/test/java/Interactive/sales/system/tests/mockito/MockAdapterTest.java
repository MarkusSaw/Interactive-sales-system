package Interactive.sales.system.tests.mockito;


import Interactive.sales.system.adapter.OrderAdapter;
import Interactive.sales.system.adapter.OrderAdapterFactory;
import Interactive.sales.system.dto.DtoOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockAdapterTest {

    private final OrderAdapter noworder;

    public MockAdapterTest(OrderAdapter noworder) {
        this.noworder = noworder;
    }

@Mock
OrderAdapter noworder;

    @InjectMocks
    OrderAdapterFactory nowpasteadapter;

@Test
    void adaptGetAdapter(){
    when(noworder.adapt()).thenReturn();

    List<DtoOrder> ok = nowpasteadapter.getAdapter();
    assertTrue(ok);
    verify(noworder).adapt();
}
}
