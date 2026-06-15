package configReaderfolder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * Reads values from the config.properties file.
 */
public class readConfig {

    private readConfig() {

    }

    public static Properties prop = new Properties();

    static {
        try {
            FileInputStream fs = new FileInputStream("src/test/java/propertyFile/config.properties");
            prop.load(fs);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read Config File");
        }
    }

    /**
     * Gets the value for the given key.
     * @param key property name
     * @return property value
     */

    public static String getProp(String key) {
        return prop.getProperty(key);
    }

}
