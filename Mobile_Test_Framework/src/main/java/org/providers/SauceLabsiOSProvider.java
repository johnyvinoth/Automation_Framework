package org.providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import utils.ConfigurationUtils;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsiOSProvider implements WebDriverProvider {
    private static final String IOS_DEVICE_NAME= ConfigurationUtils.getData("iOSDeviceName");
    private static final String IOS_APP_PATH=System.getProperty("user.dir")+ConfigurationUtils.getData("iOSAPKPath");
    private static final String APPIUM_URL =ConfigurationUtils.getData("AppiumServer");
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        XCUITestOptions options = new XCUITestOptions();
//        options.setPlatformName("ios");
//        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName(IOS_DEVICE_NAME);
        options.setApp(IOS_APP_PATH);
        try {
            return new IOSDriver(new URL(APPIUM_URL),options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
