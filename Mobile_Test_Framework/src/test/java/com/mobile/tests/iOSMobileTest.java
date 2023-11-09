package com.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.automation.MobileTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.providers.SauceLabsAndroidProvider;
import org.providers.SauceLabsiOSProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class iOSMobileTest extends MobileTestBase {
    @BeforeClass(groups = "ios")
    public static void SetupiOS() throws MalformedURLException {
        Configuration.browser= SauceLabsiOSProvider.class.getName();
        SelenideAppium.launchApp();

//        driver = new IOSDriver(new URL("http://192.168.1.11:4723/"), capabilities);

    }

    @Test(groups = "ios")
    public static void dummyMobileTest() {
        logger.info("Dummy iOS Mobile Test success");
        System.out.println("Dummy iOS Mobile Test success");
        $$(By.name("store item text")).get(0).click();
    }


//    @AfterClass(groups = "ios")
////    public void tearDownAndroid()
////    {
////        driver.quit();
////    }


}
