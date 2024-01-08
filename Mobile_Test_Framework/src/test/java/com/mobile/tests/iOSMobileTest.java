package com.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import org.automation.base.MobileTestBase;
import org.automation.pages.HomeScreen;
import org.managers.AppiumServerManager;
import org.openqa.selenium.By;
import org.providers.SauceLabsiOSProvider;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class iOSMobileTest extends MobileTestBase {
    @BeforeClass(groups = "ios")
    public static void SetupiOS() throws MalformedURLException {

        //Start Appium Server
        AppiumServerManager.startAppiumServer();

          //Initialize the Appium driver.
        Configuration.browser= SauceLabsiOSProvider.class.getName();
        SelenideAppium.launchApp();

//        driver = new IOSDriver(new URL("http://192.168.1.11:4723/"), capabilities);

    }

    @Test(groups = "ios",enabled = false)
    public static void dummyMobileTest() {
        logger.info("Dummy iOS Mobile Test success");
        System.out.println("Dummy iOS Mobile Test success");
//        $$(By.name("store item text")).get(0).click();
        HomeScreen homeScreen=new HomeScreen();
        homeScreen.clickProduct();
    }
      @Test(groups = "ios",enabled = true)
    public static void testCopyrightTextIsPresent()
    {
        HomeScreen homeScreen=new HomeScreen();
        Assert.assertTrue(homeScreen.checkWhetherCopyrightTextIsPresent(),"The Copyright text is not present and/or not displays the expected message");
        System.out.println("The Copyright text is not present and/or not displays the expected message");



    }


//    @AfterClass(groups = "ios")
////    public void tearDownAndroid()
////    {
////        driver.quit();
////    }

     @AfterSuite
    public void closeAppium()
    {
        AppiumServerManager.stopAppiumServer();
    }


}
