package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.Utils.NewWebDriverFactory;
import org.Utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/Features"}
        , glue = {"stepDefinitions"},
//        tags = "@SITest or @SmokeTest",
        tags = "@SmokeTest",
        dryRun = false
)

public class ChromeTestRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
//    public ITestContext testContext;

    //    WebDriverFactory webDriverFactory = WebDriverFactory.getInstance();
//    WebDriverFactory webDriverFactory = new WebDriverFactory();
    NewWebDriverFactory newDriverFactory = new NewWebDriverFactory();


//    @BeforeTest
//    @Parameters({"browserName"})
//    public void setup(@Optional("chrome") String browserName) {
//        System.out.println("Setup starting");
//
////        driver = webDriverFactory.createWebDriver(browserName);
////        driver = newDriverFactory.createWebDriver(browserName);
//
//
//    }


    @AfterTest
    @Parameters({"browserName"})
    public void tearDown(@Optional("chrome") String browserName) {
//        webDriverFactory.quitWebDriver();
//        WebDriverFactory.getInstance().quitWebDriver();
        newDriverFactory.quitWebDriver(browserName);
        System.out.println("Tear down completed");
    }


}