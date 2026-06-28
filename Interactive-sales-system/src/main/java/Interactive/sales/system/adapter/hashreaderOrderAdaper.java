package Interactive.sales.system.adapter;

//Читает файлы без типа  и преваращает в объект Order

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class hashreaderOrderAdaper implements OrderAdapter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public List<DtoOrder> adapt(List<String> lines) {
        List<DtoOrder> orders = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split("#");

            LocalDateTime time = LocalDateTime.parse(parts[0], FORMATTER);
            String company = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            orders.add(new DtoOrder(time, company, quantity));
        }
        return orders;
    }
}

