package org.automation.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.AppiumCondition;
import com.codeborne.selenide.appium.conditions.CombinedAttribute;
import com.codeborne.selenide.appium.selector.CombinedBy;

import static com.codeborne.selenide.Selenide.$;

public class MobileUtils {
    public static void clickElement(CombinedBy combinedByElement) throws Exception
    {
        $(combinedByElement)
                .scrollTo()
                .shouldBe(Condition.visible,Condition.interactable)
                .click();
    }
     public static void checkElementVisible(CombinedBy combinedByElement) throws Exception
    {
        $(combinedByElement)
                .scrollTo()
                .shouldBe(Condition.visible,Condition.interactable);

    }
     public static boolean checkElementText(CombinedBy combinedByElement, CombinedAttribute combinedAttributeToCompare, String textToCompare) throws Exception
    {
        try{
            $(combinedByElement)
                    .scrollTo()
                    .shouldBe(Condition.visible, Condition.interactable)
                    .shouldHave(AppiumCondition.attribute(combinedAttributeToCompare, textToCompare));
            return true;
        }
        catch (Throwable e)
        {
            return false;
        }
    }

    //TODO: Need to complete the reusable methods and modify existing POM to call the reuable methods.

}
