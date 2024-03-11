import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.automation.WebUITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class webpage_Test extends WebUITestBase {
    @Test(enabled = true)
    @Step("Test Step")
    @Description("Test Description")
    public void TestFireFox() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        String title=driver.getTitle();
        System.out.printf(title);
        Assert.assertTrue(true);
        Thread.sleep(2000);
        logger.info("FireFox browser Test successful");
        driver.quit();
    }
    @Test(enabled = true)
    public void TestChrome() throws InterruptedException
    {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.google.com");
        String title=chromeDriver.getTitle();
        System.out.printf(title);
        Thread.sleep(2000);
        logger.info("Chrome browser Test successful");
        chromeDriver.quit();

    }
    @Test(enabled = true)
    public void TestSafari() throws InterruptedException
    {
        WebDriver safariDriver = new SafariDriver();
        safariDriver.manage().window().maximize();
        safariDriver.get("https://www.google.com");
        String title=safariDriver.getTitle();
        System.out.printf(title);
        Thread.sleep(2000);
        logger.info("Safari browser Test successful");
        safariDriver.quit();

    }

//    Question asked many times in Hackkerrank online test.
    public void TestHackkerrank(WebDriver driver, String pageUrl)
    {
// Navigate to the given URL
        driver.get(pageUrl);
// Find the input element and enter the value.

        driver.findElement(By.id("fname")).sendKeys("Fizz");
        driver.findElement(By.id("lname")).sendKeys("Bizz");
        driver.findElement(By.id("email")).sendKeys("hackerrank@hackerrank.com");
        driver.findElement(By.id("password")).sendKeys("lemetin@Hrw");
        driver.findElement(By.id("c_password")).sendKeys("c_lemetin@Hrw");


//        Click the submit button
        driver.findElement(By.xpath("//button[text()='Register'])")).click();

    }



}
