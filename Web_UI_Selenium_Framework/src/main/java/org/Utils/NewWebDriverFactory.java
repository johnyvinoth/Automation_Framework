package org.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class NewWebDriverFactory {
    private final ThreadLocal<Map<String, WebDriver>> driverMap = ThreadLocal.withInitial(HashMap::new);

//    private NewWebDriverFactory() {
//    }

    public WebDriver createWebDriver(String browserName) {
        WebDriver driver = getWebDriver(browserName);
        if (driver != null) {
            return driver;
        }
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;

        }
        driverMap.get().put(browserName.toLowerCase(), driver);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getWebDriver(String browserName) {
        return driverMap.get().get(browserName.toLowerCase());
    }

    public void quitWebDriver(String browserName) {
        WebDriver driver = getWebDriver(browserName);
        if (driver != null) {
//            driver=null;
            driver.quit();
            driverMap.get().remove(browserName.toLowerCase());
        }

    }


}
