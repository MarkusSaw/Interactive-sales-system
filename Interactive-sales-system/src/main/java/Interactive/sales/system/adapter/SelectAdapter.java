package Interactive.sales.system.adapter;

// Выбор адаптера

public class SelectAdapter  {

    public static OrderAdapter chooseAdapter(String filePath) {
        if (filePath.endsWith(".txt")) {
            return new TXTReaderOrderAdapter();
        } else {
            return new HashReaderOrderAdapter();
        }
    }
}
