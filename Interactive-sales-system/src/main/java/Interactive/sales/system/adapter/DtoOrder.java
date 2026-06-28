package Interactive.sales.system.adapter;

// Модель заказа ,строки создаются в объекты.

import java.time.LocalDateTime;



public class DtoOrder {

    private final LocalDateTime time;
    private final String companyName;
    private final int quantityKg;

    public DtoOrder(LocalDateTime time, String companyName, int quantityKg) {
        this.time = time;
        this.companyName = companyName;
        this.quantityKg = quantityKg;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getQuantityKg() {
        return quantityKg;
    }
}


