package Interactive.sales.system.discountservice;

//Считает стоимость заказов со скидками , возвращает значение цены из enum

import Interactive.sales.system.setparameters.SetParameters;

public class DiscountCalculate extends TemplateCalculate {

    @Override
    public double getPrice() {
        return SetParameters.Inputparameters.price.getValue();
    }

    @Override
    public double getDiscount() {
        return SetParameters.Inputparameters.discount.getValue();
    }

    @Override
    public double getDiscountStep() {
        return SetParameters.Inputparameters.discountstep.getValue();
    }
}