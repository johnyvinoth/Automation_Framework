package org.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static WebDriver driver;

    public static WebDriver createWebDriver(String browserName) {
        driver = driverThreadLocal.get();
        if (driver == null) {
            if (browserName.toLowerCase().equals("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.toLowerCase().equals("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.toLowerCase().equals("safari")) {
                driver = new SafariDriver();
            } else {
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driverThreadLocal.set(driver);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

}
