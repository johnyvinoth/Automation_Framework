package org.automation.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.AppiumCondition;
import com.codeborne.selenide.appium.AppiumSelectors;
import com.codeborne.selenide.appium.conditions.CombinedAttribute;
import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.maven.model.building.ModelBuilder;
import org.automation.utils.MobileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.appium.ScreenObject.screen;

public class HomeScreen {
    By AndroidSauceLabBag = AppiumSelectors.byContentDescription("store item");
    By iOsSauceLabBag = AppiumSelectors.withAttribute("name", "store item");

    //identifying an element individually for Android and iOS is not used. Using CombinedBy below.
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy.']")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy.\"]")
    private WebElement copyrightText;


    private CombinedBy copyRightCombined = CombinedBy
            .android(By.xpath("//android.widget.TextView[@text='© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy.']"))
            .ios(By.xpath("//XCUIElementTypeStaticText[@name='© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy.']"));

    public ProductDescriptionScreen clickProduct() throws Exception {
        CombinedBy SauceLabBag = CombinedBy.android(AndroidSauceLabBag).ios(iOsSauceLabBag);
        MobileUtils.clickElement(SauceLabBag,0);
        return screen(ProductDescriptionScreen.class);
    }

    public Boolean checkWhetherCopyrightTextIsPresent() {

        CombinedAttribute attribute = CombinedAttribute.android("text").ios("name");

        try {
            MobileUtils.checkElementText(copyRightCombined,attribute,"© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy.");
            return true;
        } catch (Throwable e) {

            return false;
        }


    }


}
