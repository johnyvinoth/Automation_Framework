package com.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import org.automation.base.MobileTestBase;
import org.automation.pages.HomeScreen;
import org.automation.pages.ProductDescriptionScreen;
import org.automation.pages.ShoppingCartScreen;
import org.managers.AppiumServerManager;
import org.openqa.selenium.By;
import org.providers.SauceLabsiOSProvider;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class iOSMobileTest extends MobileTestBase {
    @BeforeClass(groups = "ios")
    public static void SetupiOS() throws MalformedURLException {

        //Start Appium Server
        AppiumServerManager.startAppiumServer();

        //Initialize the Appium driver.
        Configuration.browser = SauceLabsiOSProvider.class.getName();
        SelenideAppium.launchApp();

//        driver = new IOSDriver(new URL("http://192.168.1.11:4723/"), capabilities);

    }

    @Test(groups = "ios", enabled = false)
    public static void dummyMobileTest() {
        logger.info("Dummy iOS Mobile Test success");
        System.out.println("Dummy iOS Mobile Test success");
//        $$(By.name("store item text")).get(0).click();
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.clickProduct();
    }

    @Test(groups = "ios", enabled = false)
    public static void testCopyrightTextIsPresent() {
        HomeScreen homeScreen = new HomeScreen();
        Boolean copyrightTextPresent = homeScreen.checkWhetherCopyrightTextIsPresent();
//        Assert.assertTrue(homeScreen.checkWhetherCopyrightTextIsPresent(),"The Copyright text is not present and/or not displays the expected message");
        if (copyrightTextPresent) {
            System.out.println("The Copyright text is present and displays the expected message");
        } else {
            System.out.println("The Copyright text is not present and/or not displays the expected message");
        }
        Assert.assertTrue(copyrightTextPresent);


    }

    @Test(groups = "ios", enabled = true)
    public static void addSauceLabBagToCartTest() {
        HomeScreen homeScreen = new HomeScreen();
        ProductDescriptionScreen productDescriptionScreen = homeScreen.clickProduct();
        Assert.assertTrue(productDescriptionScreen.checkProductName("Sauce Labs Backpack"), "The product name doesn't match");
        Assert.assertTrue(productDescriptionScreen.checkProductPrice("$29.99"), "The product price doesn't match");
        Assert.assertTrue(productDescriptionScreen.checkSauceLabBagDescription(), "The product product description doesn't match");
        productDescriptionScreen.clickAddToCartBtn();
        ShoppingCartScreen shoppingCartScreen = productDescriptionScreen.clickShoppingCartBtn();
        Assert.assertTrue(shoppingCartScreen.checkProductaddedToCart());

        sleep(5000);


    }


//    @AfterClass(groups = "ios")
////    public void tearDownAndroid()
////    {
////        driver.quit();
////    }

    @AfterSuite
    public void closeAppium() {
        AppiumServerManager.stopAppiumServer();
    }


}
