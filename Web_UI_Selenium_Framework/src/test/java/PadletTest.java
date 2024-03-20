import org.Utils.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.*;
import java.security.Key;
import java.util.List;

public class PadletTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test(priority = 0)
    public void testNavigation() throws InterruptedException {
        String url = "https://padlet.com/sakiwod706/write-your-discussion-question-here-ihdxdhi2o821vgdk";
        driver.get(url);
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println("The web page title is: " + title);


    }

    @Test(dependsOnMethods = "testNavigation", priority = 1, enabled = false)
    public void getItems() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"wish-list\"]/div"));

        for (WebElement element : elements) {
            WebElement paragraph = element.findElement(By.tagName("p"));
            String paragraphText = paragraph.getText();

            System.out.println("The text in the paragraph is: " + paragraphText);

        }


    }

    @Test(dependsOnMethods = "testNavigation", priority = 2)
    public void addComment() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.cssSelector("button[data-testid='addCommentButton']"));
        for (int i = 0; i < elements.size(); i++) {

            elements.get(i).click();
//            Thread.sleep(2000);
            WebUtils.WaitUntilElementIsClickable(driver, By.cssSelector("p[data-placeholder='Add comment']"));
            List<WebElement> pelements = driver.findElements(By.cssSelector("p[data-placeholder='Add comment']"));
            pelements.get(i).sendKeys("Test Comment:" + "_" + Math.random());
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).perform();

        }

        Thread.sleep(2000);
    }

public void deleteComments()
{
  List<WebElement> moreActionsbtn=driver.findElements(By.xpath("//button[@data-testid='surfacePostCommentMoreButton']//i"));
//TODO: need to implement actions to delete the comments.
}


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
