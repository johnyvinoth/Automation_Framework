package org.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class WebUtils {
    public static final int TIMEOUT = 10;
    public static final int POLLING_INTERVAL = 1;

    public static void Wait(WebDriver driver, Duration waitTime) {

        driver.manage().timeouts().implicitlyWait(waitTime);

    }

    public static WebElement WaitUntilElementIsVibile(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(POLLING_INTERVAL));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static WebElement WaitUntilElementIsClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(POLLING_INTERVAL));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public static List<WebElement> WaitUntilElementIsClickable(WebDriver driver, List<WebElement> locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(POLLING_INTERVAL));
        return wait.until(ExpectedConditions.visibilityOfAllElements(locator));

    }
        public static WebElement WaitUntilElementIsClickable(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(POLLING_INTERVAL));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
    public static void pressEnterButton(WebDriver driver)
    {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
        action.perform();
    }


}
