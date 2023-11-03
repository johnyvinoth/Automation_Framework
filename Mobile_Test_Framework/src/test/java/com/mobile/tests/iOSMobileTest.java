package com.mobile.tests;

import io.appium.java_client.ios.IOSDriver;
import org.automation.MobileTestBase;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class iOSMobileTest extends MobileTestBase {
    @BeforeClass(groups = "ios")
    public static void SetupAndroid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");

        driver = new IOSDriver(new URL("http://192.168.1.11:4723/"), capabilities);

    }

    @Test(groups = "ios")
    public static void dummyMobileTest() {
        logger.info("Dummy iOS Mobile Test success");
        System.out.println("Dummy iOS Mobile Test success");
    }


    @AfterClass(groups = "android")
    public void tearDownAndroid()
    {
        driver.quit();
    }


}
