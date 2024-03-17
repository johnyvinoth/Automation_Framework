package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Utils.WebDriverFactory;
import org.Utils.WebUtils;
import org.Utils.Web_UI_ConfigurationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.pages.MainPage;
import org.testng.annotations.AfterSuite;

import java.util.List;

public class StepDefinitions {
    private WebDriver driver;
    private MainPage mainPage;
    @Before
    public void setup() {
        System.out.println("Setup starting");
    }
    @BeforeStep
    public void waitBeforeEachStep() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Given("Login to padlet site in {string} browser")
    public void login_to_padlet_site_in_browser(String browserName) throws InterruptedException {
        driver = WebDriverFactory.getWebDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Web_UI_ConfigurationUtils.getProperty("padlet_board_url"));
//        String title = driver.getTitle();
//        System.out.println("The web page title is: " + title);
        Thread.sleep(5000);
    }

    @When("user click on Add comment and enters a new comment {string}")
    public void userClickOnAddCommentAndEntersANewCommentNewComment(String newComment) throws InterruptedException {

//          List<WebElement> elements = driver.findElements(By.cssSelector("button[data-testid='addCommentButton']"));
//        for (int i = 0; i < elements.size(); i++) {
//
//            elements.get(i).click();
//            WebUtils.WaitUntilElementIsClickable(driver, By.cssSelector("p[data-placeholder='Add comment']"));
//            List<WebElement> pelements = driver.findElements(By.cssSelector("p[data-placeholder='Add comment']"));
//            pelements.get(i).sendKeys(newComment);
//            Actions action = new Actions(driver);
//            action.sendKeys(Keys.ENTER).perform();
//
//        }
        mainPage=new MainPage(driver);
//        mainPage.clickAllTiles();
        mainPage.addComments(newComment);
        Thread.sleep(2000);
        System.out.println("user click on Add comment and comment entered is: " + newComment);
    }

    @Then("comment is added to the section")
    public void comment_is_added_to_the_section() {
        System.out.println("Testing");
        mainPage.getTitle();
    }

    @After
    public void teardown() {
        WebDriverFactory.quitWebDriver();
        System.out.println("Tear down completed");
    }
}