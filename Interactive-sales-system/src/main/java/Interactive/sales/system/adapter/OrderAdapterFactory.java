package Interactive.sales.system.adapter;

// Выбор адаптера

public class OrderAdapterFactory {

    public OrderAdapter getAdapter(String filePath) {
        if (filePath.endsWith(".txt")) {
            return new TxtOrderAdapter();
        } else {
            return new HashOrderAdapter();
        }
    }
}
