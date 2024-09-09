package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Utils.*;
import org.openqa.selenium.WebDriver;
import org.pages.DashboardPage;
import org.pages.LoginPage;
import org.pages.MainPage;
import org.pages.PasswordPage;
import org.testng.Assert;


public class StepDefinitions {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private DashboardPage dashboardPage;


    //    NewWebDriverFactory newDriverFactory = new NewWebDriverFactory();
    WebDriverFactory webDriverFactory = new WebDriverFactory();

    @BeforeStep

    public void waitBeforeEachStep() throws InterruptedException {
        Thread.sleep(1000);

    }


    @Given("Login to padlet site in {string} browser")
    public void login_to_padlet_site_in_browser(String broserName) {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createWebDriver(broserName);
        driver.get(Web_UI_ConfigurationUtils.getProperty("padlet_url"));
    }


    @Given("Login to padlet test site")
    public void login_to_padlet_test_site() throws InterruptedException {
//        WebDriverFactory webDriverFactory = new WebDriverFactory();
//        driver=new WebDriverFactory().getDriver();

//        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getDriver();
        driver.get(Web_UI_ConfigurationUtils.getProperty("padlet_url"));
    }

    @When("user logs into the padlet site with valid login")
    public void user_logs_into_the_padlet_site_with_valid_login() throws InterruptedException {
        loginPage = PageObjectManager.getPageObject(driver, LoginPage.class);
        passwordPage = PageObjectManager.getPageObject(driver, PasswordPage.class);

//        loginPage.enterTestMailId(Web_UI_ConfigurationUtils.getProperty("padlet_login_id"));
//        loginPage.clikcTestContinueBtn();
//        passwordPage.setTestPasswordInputTxt(Web_UI_ConfigurationUtils.getProperty("padlet_password"));
//        passwordPage.clickTestLoginBtn();

        loginPage
                .enterTestMailId(Web_UI_ConfigurationUtils.getProperty("padlet_login_id"))
                .clickTestContinueBtn();
        passwordPage
                .setTestPasswordInputTxt(Web_UI_ConfigurationUtils.getProperty("padlet_password"))
                .clickTestLoginBtn();
    }


    @When("user click on Add comment and enters a new comment {string}")
    public void userClickOnAddCommentAndEntersANewCommentNewComment(String newComment) throws InterruptedException {
        mainPage = PageObjectManager.getPageObject(driver, MainPage.class);
        mainPage.addComments(newComment);
        Thread.sleep(2000);
        System.out.println("user click on Add comment and comment entered is: " + newComment);
    }

    @Then("dashboard page will be displayed")
    public void dashboard_page_will_be_displayed() throws InterruptedException {
        WebUtils.waitForPageLoad(driver);
        Thread.sleep(5000);
        String PageTitle = driver.getTitle();
        Assert.assertEquals(PageTitle, "Dashboard | Padlet");
        System.out.println("Page Title: " + PageTitle);
        WebUtils.waitForPageLoad(driver);
    }

    @Then("comment is added to the section")
    public void comment_is_added_to_the_section() {
        System.out.println("Testing");
        mainPage = PageObjectManager.getPageObject(driver, MainPage.class);
        mainPage.getTitle();
    }

    @Then("user logout from the padlet site")
    public void user_logout_from_the_padlet_site() {
        dashboardPage = PageObjectManager.getPageObject(driver, DashboardPage.class);
        dashboardPage.logout();
        webDriverFactory.quitWebDriver(driver);

    }


}