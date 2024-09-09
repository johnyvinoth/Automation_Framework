package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.Utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/Features"}
        , glue = {"stepDefinitions"},
//        tags = "@SITest or @SmokeTest",
        tags = "@SmokeTest",
        dryRun = false
)

public class FireFoxTestRunner extends AbstractTestNGCucumberTests {
    private WebDriver driver;
        WebDriverFactory webDriverFactory = new WebDriverFactory();
//    WebDriverFactory webDriverFactory = new WebDriverFactory();

    @BeforeTest
    @Parameters({"browserName"})
    public void setup(@Optional("chrome") String browserName) {
        System.out.println("Setup starting");

        driver = webDriverFactory.createWebDriver(browserName);

    }


    @AfterTest
    public void teardown() {
        //        webDriverFactory.quitWebDriver();
        webDriverFactory.quitWebDriver();
                System.out.println("Tear down completed");
    }

}