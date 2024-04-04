package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.Utils.WebDriverFactory;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

//@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/Features/padletTestSite.feature"}
        , glue = {"stepDefinitions"},
        dryRun = false


)

public class padletTestSiteRunner extends AbstractTestNGCucumberTests {
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