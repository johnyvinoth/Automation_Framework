package org.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Web_UI_ConfigurationUtils {
    private static final String WEB_UI_CONFIG_FILE = "Web_UI_Config.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = Web_UI_ConfigurationUtils.class.getClassLoader().getResourceAsStream(WEB_UI_CONFIG_FILE))
        {
            properties.load(inputStream);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static String getProperty(String resourceName)
    {
        return properties.getProperty(resourceName);
    }

}
