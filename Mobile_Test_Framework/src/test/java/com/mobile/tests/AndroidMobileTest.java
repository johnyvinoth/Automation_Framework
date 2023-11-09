package com.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.automation.MobileTestBase;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.providers.SauceLabsAndroidProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigurationUtils;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AndroidMobileTest extends MobileTestBase {

//    private static final String ANDROID_DEVICE_NAME= ConfigurationUtils.getData("AndroidDeviceName");
////private static final String ANDROID_DEVICE_NAME="Pixel_7_Pro_API_33";
////    private static final String ANDROID_APP_PATH="Mobile_Framework/apps/android/Android-MyDemoAppRN.1.3.0.build-244.apk";
//    private static final String ANDROID_APP_PATH=ConfigurationUtils.getData("AndroidAPKPath");
    @BeforeClass(groups = "android")
    public static void SetupAndroid() {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,ANDROID_DEVICE_NAME);
//        capabilities.setCapability("app",ANDROID_APP_PATH);


        //Initialize the Appium driver.
        Configuration.browser= SauceLabsAndroidProvider.class.getName();
        SelenideAppium.launchApp();
//        driver = new AndroidDriver(new URL("http://192.168.1.11:4723/"), options);

    }

    @Test
    public static void dummyMobileTest() {
        logger.info("Dummy Android Mobile Test success");
        System.out.println("Dummy Android Mobile Test success");
//        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        $(AppiumBy.accessibilityId("open menu")).click();
    }

    @AfterClass(groups = "android")
    public void tearDownAndroid()
    {
        System.out.println("Dummy Android Mobile Test Exited");
//        driver.quit();
    }
}