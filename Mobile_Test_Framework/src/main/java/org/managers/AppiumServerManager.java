package org.managers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.net.URL;

public class AppiumServerManager {

    private static AppiumDriverLocalService service;

    public static void startAppiumServer()
    {
        String nodePath="/usr/local/lib/node_modules/appium/build/lib/main.js";


        service=new AppiumServiceBuilder().withAppiumJS(new File(nodePath))
                .withTimeout(Duration.ZERO.withSeconds(300))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withLogFile(new File("appium.log"))
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .build()
        ;
        service.start();
    }
    public static URL getAppiumServerURL()
    {
        if(service==null || !service.isRunning())
        {
            startAppiumServer();
        }
        try {
            return new URL(service.getUrl().toString());

        }catch (MalformedURLException e)
        {
            throw new RuntimeException("Failed to get Appium server URL",e);
        }
    }
    public static void stopAppiumServer()
    {
        if(service!=null || service.isRunning())
        {
            service.stop();
        }


    }
}
