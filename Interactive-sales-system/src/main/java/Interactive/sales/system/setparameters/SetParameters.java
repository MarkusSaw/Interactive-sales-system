package Interactive.sales.system.setparameters;

// Хранит настройки программы (цену, скидку, шаг скидки).

public class SetParameters {

    public enum Inputparameters {

        price(10), discount(50), discountstep(5);

        private final double value;

        Inputparameters(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

    }
}
