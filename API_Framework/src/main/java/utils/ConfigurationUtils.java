package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationUtils {
    private static final String CONFIG_FILE= "config.properties";
    private static Properties properties;
    static {
        properties=new Properties();
        try (InputStream inputStream=ConfigurationUtils.class.getClassLoader().getResourceAsStream(CONFIG_FILE))
        {
         properties.load(inputStream);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static String getBaseURI(String resourceName)
    {
        return properties.getProperty(resourceName);

    }
    public static String getModelJsonLocation(String resourceName)
    {
        return properties.getProperty(resourceName);

    }

}
