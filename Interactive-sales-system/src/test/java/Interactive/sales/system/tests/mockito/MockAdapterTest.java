package Interactive.sales.system.tests.mockito;


import Interactive.sales.system.adapter.OrderAdapter;
import Interactive.sales.system.adapter.OrderAdapterFactory;
import Interactive.sales.system.adapter.TxtOrderAdapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MockAdapterTest {


    @Mock
    OrderAdapterFactory nowpasteadapter;

    @Test
    void adaptGetAdapter() {
        TxtOrderAdapter adapter = mock(TxtOrderAdapter.class);
        when(nowpasteadapter.getAdapter(anyString())).thenReturn(adapter);
        OrderAdapter result = nowpasteadapter.getAdapter("test.txt");
        assertEquals(adapter, result);
        verify(nowpasteadapter).getAdapter("test.txt");
    }
}
