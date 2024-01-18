package org.automation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.conditions.CombinedAttribute;
import com.codeborne.selenide.appium.selector.CombinedBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class ShoppingCartScreen {

    private CombinedBy product = CombinedBy
            .android(By.xpath("(//XCUIElementTypeOther[@name='Sauce Labs Backpack $29.99 \uDB81\uDCCF \uDB81\uDCCF \uDB81\uDCCF \uDB81\uDCCF \uDB81\uDCCF Color:'])[1]"))
            .ios(By.xpath("(//XCUIElementTypeOther[@name='Sauce Labs Backpack $29.99 \uDB81\uDCCF \uDB81\uDCCF \uDB81\uDCCF \uDB81\uDCCF \uDB81\uDCCF Color:'])[1]"));


    public Boolean checkProductaddedToCart() {
        CombinedAttribute productListing = CombinedAttribute.android("text").ios("label");

        try {
//            System.out.println("The shopping cart value is: "+ $(product).getText());

            $(product)
                    .scrollTo()
                    .shouldBe(Condition.interactable, Condition.visible);
            return true;
        } catch (Throwable e) {
            return false;
        }

    }
}
