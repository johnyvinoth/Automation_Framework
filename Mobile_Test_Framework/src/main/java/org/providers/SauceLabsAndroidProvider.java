package org.providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.managers.AppiumServerManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import utils.ConfigurationUtils;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsAndroidProvider implements WebDriverProvider {
    private static final String ANDROID_DEVICE_NAME= ConfigurationUtils.getData("AndroidDeviceName");
    private static final String ANDROID_APP_PATH=System.getProperty("user.dir")+ConfigurationUtils.getData("AndroidAPKPath");
    private static final String APPIUM_URL =ConfigurationUtils.getData("AppiumServer");

    //private static final String ANDROID_DEVICE_NAME="Pixel_7_Pro_API_33";
//    private static final String ANDROID_APP_PATH="Mobile_Framework/apps/android/Android-MyDemoAppRN.1.3.0.build-244.apk";
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName(ANDROID_DEVICE_NAME);
        options.setApp(ANDROID_APP_PATH);
        try {
            URL appiumServerUrl= AppiumServerManager.getAppiumServerURL();
            return new AndroidDriver(new URL(APPIUM_URL),options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

//TODO: Need to check why android emulator doesnt start automatically when the code runs
// but iOS emulator does run automatically.

