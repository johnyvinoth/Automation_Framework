package org.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    private static WebDriver driver;
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver createWebDriver(String browserName) {
        if (driver == null) {

            if (browserName.toLowerCase().equals("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.toLowerCase().equals("firefox")) {
                driver = new FirefoxDriver();

            } else if (browserName.toLowerCase().equals("safari")) {
                driver = new SafariDriver();

            }else {
                driver=new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        WebDriverFactory.setWebDriver(driver);

        return WebDriverFactory.getDriver();
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();

    }

    public static void setWebDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static void removeWebDriver() {
        driverThreadLocal.remove();
    }

    public static void quitWebDriver() {
        driver=WebDriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}
