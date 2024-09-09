package org.Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WebUtils {
    public static final int TIMEOUT = 20;
    public static final int POLLING_INTERVAL = 1;


    public static void Wait(WebDriver driver, long waitTime) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));

    }


    public static WebElement WaitUntilElementIsVibile(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(POLLING_INTERVAL));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static List<WebElement> WaitUntilElementsAreVisible(WebDriver driver, List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(POLLING_INTERVAL));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));

    }

    /*
    Used to wait until the element is clickable
    Args: WebDriver and element locators
     */
    public static WebElement WaitUntilElementIsClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(POLLING_INTERVAL));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public static WebElement WaitUntilElementIsClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(POLLING_INTERVAL));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void pressEnterButton(WebDriver driver) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
        action.perform();
    }

    public static void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(POLLING_INTERVAL));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

public static void clickElementWithJavaScript(WebDriver driver, WebElement element, int timeoutInSeconds, int pollingIntervalInMillis) {
    try {
        // Create a FluentWait instance to repeatedly check if the element is visible
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingIntervalInMillis))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);

        // Wait until the element is visible
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();
            }
        });

        // Once the element is visible, click it using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    } catch (TimeoutException e) {
        throw new TimeoutException("Element was not visible and clickable after " + timeoutInSeconds + " seconds.");
    }
}

}
