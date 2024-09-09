package org.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    private static WebDriverFactory instance = null;

//    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private ThreadLocal<WebDriver> driverThreadLocal = ThreadLocal.withInitial(() -> null);
//    private ThreadLocal<Map<String,WebDriver> > driverThreadLocal = ThreadLocal.withInitial(HashMap::new);


//    private WebDriverFactory() {
//
//    }
//
//    public static WebDriverFactory getInstance() {
//        if (instance == null) {
//            instance = new WebDriverFactory();
//        }
//        return instance;
//    }

    //private static WebDriver driver;
    public  WebDriver createWebDriver(String browserName) {

        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
            } else {
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driverThreadLocal.set(driver);
        }
        System.out.println("Create Web Driver is called for the browser " + browserName);
        return driverThreadLocal.get();
    }

    public WebDriver getDriver() {
        System.out.println("getDriver method is called" + driverThreadLocal.toString());
//        driverThreadLocal.set(driver);
        return driverThreadLocal.get();
    }

    public void quitWebDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
//            driver=null;
            driver.quit();
            driverThreadLocal.set(null);
        }
    }

    public void quitWebDriver(WebDriver driver) {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
