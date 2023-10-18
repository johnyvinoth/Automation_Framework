import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class webpage_Test {
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
        driver.quit();
    }
    @Test(enabled = false)
    public void TestChrome() throws InterruptedException
    {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.google.com");
        String title=chromeDriver.getTitle();
        System.out.printf(title);
        Thread.sleep(2000);
        chromeDriver.quit();

    }
    @Test(enabled = false)
    public void TestSafari() throws InterruptedException
    {
        WebDriver safariDriver = new SafariDriver();
        safariDriver.manage().window().maximize();
        safariDriver.get("https://www.google.com");
        String title=safariDriver.getTitle();
        System.out.printf(title);
        Thread.sleep(2000);
        safariDriver.quit();

    }
}
