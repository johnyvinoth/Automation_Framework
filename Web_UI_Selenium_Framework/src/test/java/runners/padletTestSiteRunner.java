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
    WebDriverFactory webDriverFactory = new WebDriverFactory();

    //   WebDriverFactory webDriverFactory = new WebDriverFactory();
    @BeforeSuite
    public void setup() {
        System.out.println("Setup starting");
//          driver = webDriverFactory.createWebDriver(browserName);
    }


    @AfterSuite
    public void teardown() {
        webDriverFactory.quitWebDriver();
        System.out.println("Tear down completed");
    }

}