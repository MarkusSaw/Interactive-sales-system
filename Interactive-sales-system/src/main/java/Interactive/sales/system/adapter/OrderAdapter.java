package Interactive.sales.system.adapter;

// Правило для всех адаптеров - превращать список строк в список заказов.

import java.util.List;

public interface OrderAdapter {

    List<DtoOrder> adapt(List<String> lines);
}
