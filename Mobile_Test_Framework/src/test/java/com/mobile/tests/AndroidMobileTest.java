package com.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.ScreenObject;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import org.automation.base.MobileTestBase;
import org.automation.pages.HomeScreen;
import org.automation.pages.ProductDescriptionScreen;
import org.automation.pages.ShoppingCartScreen;
import org.managers.AppiumServerManager;
import org.providers.SauceLabsAndroidProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AndroidMobileTest extends MobileTestBase {

    @BeforeClass(groups = "android")
    public static void SetupAndroid() {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,ANDROID_DEVICE_NAME);
//        capabilities.setCapability("app",ANDROID_APP_PATH);

        //Start Appium Server
        AppiumServerManager.startAppiumServer();
        //Initialize the Appium driver.
        Configuration.browser = SauceLabsAndroidProvider.class.getName();
        SelenideAppium.launchApp();


    }

    @Test(groups = "android", enabled = false)
    public static void dummyMobileTest() throws Exception {
        logger.info("Dummy Android Mobile Test success");
        System.out.println("Dummy Android Mobile Test success");
//        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
//        $(AppiumBy.accessibilityId("open menu")).click();
        HomeScreen homeScreen = new HomeScreen();
//        homeScreen.clickProduct();
        ProductDescriptionScreen productDescriptionScreen = homeScreen.clickProduct();
    }

    @Test(groups = "android", enabled = true)
    public static void testCopyrightTextIsPresent() {
         HomeScreen homeScreen = new HomeScreen();
        Boolean copyrightTextPresent = homeScreen.checkWhetherCopyrightTextIsPresent();
        if (copyrightTextPresent) {
            System.out.println("The Copyright text is present and displays the expected message");
        } else {
            System.out.println("The Copyright text is not present and/or not displays the expected message");
        }
        Assert.assertTrue(copyrightTextPresent);
    }

    @Test(groups = "android", enabled = true)
    public static void addSauceLabBagToCartTest() throws Exception {
        HomeScreen homeScreen = new HomeScreen();
        ProductDescriptionScreen productDescriptionScreen = homeScreen.clickProduct();
        Assert.assertTrue(productDescriptionScreen.checkProductName("Sauce Labs Backpack"), "The product name doesn't match");
        Assert.assertTrue(productDescriptionScreen.checkProductPrice("$29.99"), "The product price doesn't match");
        Assert.assertTrue(productDescriptionScreen.checkSauceLabBagDescription(), "The product product description doesn't match");
        productDescriptionScreen.clickAddToCartBtn();
        ShoppingCartScreen shoppingCartScreen = productDescriptionScreen.clickShoppingCartBtn();

        sleep(5000);
//        productDescriptionScreen.clickShoppingCartBtn();

    }

    @AfterClass(groups = "android")
    public void tearDownAndroid() {
        System.out.println("Android Mobile Test Exited");
//        driver.quit();
    }

    @AfterSuite
    public void closeAppium() {
        AppiumServerManager.stopAppiumServer();
    }
}