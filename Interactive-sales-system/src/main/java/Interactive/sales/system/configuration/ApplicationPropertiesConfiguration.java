package Interactive.sales.system.configuration;

// Класс для чтения .properties файлов через библиотеку ResourceBundle.

import java.util.ResourceBundle;

public class ApplicationPropertiesConfiguration {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("application");

    public static String getString(String key) {
        return bundle.getString(key);
    }

    public static double getDouble(String key) {
        return Double.parseDouble(bundle.getString(key));
    }
}
