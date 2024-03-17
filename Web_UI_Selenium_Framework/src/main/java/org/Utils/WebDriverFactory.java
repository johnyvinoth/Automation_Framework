package org.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getWebDriver(String browserName) {
        if (driver == null) {
            switch (browserName.toLowerCase()) {

                case "chrome": {
                    driver = new ChromeDriver();
                    break;
                }
                case "firefox": {
                    driver = new FirefoxDriver();
                    break;
                }
                case "safari": {
                    driver = new SafariDriver();
                    break;
                }
                default: {
                    driver = new ChromeDriver();
                    break;
                }
            }
        }
        return driver;
    }
    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}
