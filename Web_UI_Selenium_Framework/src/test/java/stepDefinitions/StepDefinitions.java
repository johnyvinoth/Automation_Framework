package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Utils.PageObjectManager;
import org.Utils.WebDriverFactory;
import org.Utils.Web_UI_ConfigurationUtils;
import org.openqa.selenium.WebDriver;
import org.pages.LoginPage;
import org.pages.MainPage;
import org.pages.PasswordPage;
import org.testng.Assert;

public class StepDefinitions {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private PasswordPage passwordPage;


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
        driver = WebDriverFactory.createWebDriver(browserName);
//        driver.manage().window().maximize();
        driver.get(Web_UI_ConfigurationUtils.getProperty("padlet_url"));
//        Thread.sleep(2000);
    }

    @When("user logs into the padlet site with valid login")
    public void user_logs_into_the_padlet_site_with_valid_login() throws InterruptedException {
        loginPage = PageObjectManager.getPageObject(driver, LoginPage.class);
        passwordPage = PageObjectManager.getPageObject(driver, PasswordPage.class);

        loginPage.enterTestMailId(Web_UI_ConfigurationUtils.getProperty("padlet_login_id"));
        loginPage.clikcTestContinueBtn();
//        Thread.sleep(1000);
        passwordPage.setTestPasswordInputTxt(Web_UI_ConfigurationUtils.getProperty("padlet_password"));
//        Thread.sleep(2000);
        passwordPage.clickTestLoginBtn();
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
//        mainPage=new MainPage(driver);
        mainPage = PageObjectManager.getPageObject(driver, MainPage.class);
        mainPage.addComments(newComment);
        Thread.sleep(2000);
        System.out.println("user click on Add comment and comment entered is: " + newComment);
    }

    @Then("dashboard page will be displayed")
    public void dashboard_page_will_be_displayed() throws InterruptedException {
        String PageTitle= driver.getTitle();
        Assert.assertEquals(PageTitle, "Dashboard | Padlet");
        System.out.println("Page Title: " + PageTitle);
        Thread.sleep(2000);
    }

    @Then("comment is added to the section")
    public void comment_is_added_to_the_section() {
        System.out.println("Testing");
        mainPage = PageObjectManager.getPageObject(driver, MainPage.class);
        mainPage.getTitle();
//        mainPage.clickAddPostBtn();


    }
    @After
    public void teardown() {
        WebDriverFactory.quitWebDriver();
        System.out.println("Tear down completed");
    }
}