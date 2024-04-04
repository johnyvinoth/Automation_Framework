package runners;

//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
//import cucumber.api.testng;
import io.cucumber.testng.CucumberOptions;
import org.Utils.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
//import cucumber.api.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/Features"}
        , glue = {"stepDefinitions"},
        tags = "@SITest or @SmokeTest",
        dryRun = false
)

public class ChromeTestRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void setup() {
        System.out.println("Setup starting");
    }


    @AfterSuite
    public void teardown() {
        WebDriverFactory.quitWebDriver();
        System.out.println("Tear down completed");
    }

}