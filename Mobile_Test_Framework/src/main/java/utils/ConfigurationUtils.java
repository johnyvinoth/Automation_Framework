package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationUtils {
    private static final String CONFIG_FILE= "MobileConfig.properties";
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
    public static String getAppiumServer(String resourceName)
    {
        return properties.getProperty(resourceName);

    }
    public static String getData(String resourceName)
    {
        return properties.getProperty(resourceName);

    }

}
