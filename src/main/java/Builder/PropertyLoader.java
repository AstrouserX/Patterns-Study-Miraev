package Builder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class PropertyLoader {

    public static String getProperty (String filename, String propertyName) {

        FileInputStream fis;
        Properties property = new Properties();
        String propertyFromFile = null;

        try {
            fis = new FileInputStream("src/main/resources/" + filename);
            property.load(fis);
            propertyFromFile = property.getProperty(propertyName);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        return propertyFromFile;
    }

    public static String getProperty(String propertyName) {
        return getProperty("config.properties", propertyName);
    }
}
