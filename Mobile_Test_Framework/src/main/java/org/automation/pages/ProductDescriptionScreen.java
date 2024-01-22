package org.automation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.AppiumCondition;
import com.codeborne.selenide.appium.conditions.CombinedAttribute;
import com.codeborne.selenide.appium.selector.CombinedBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static org.automation.utils.MobileUtils.clickElement;

public class ProductDescriptionScreen {

    private CombinedBy lblproductName = CombinedBy
            .android(By.xpath("//android.widget.TextView[@text='Sauce Labs Backpack']"))
            .ios(By.id("Sauce Labs Backpack"));

    private CombinedBy priceTag = CombinedBy
            .android(By.xpath("//android.widget.TextView[@content-desc='product price']"))
            .ios(By.id("product price"));

    private CombinedBy btnAddToCart = CombinedBy
            .android(By.xpath("//android.widget.TextView[@text='Add To Cart']"))
            .ios((By.id("Add To Cart button")));


    private CombinedBy txtProductDescription = CombinedBy
            .android(By.xpath("//android.widget.TextView[@content-desc='product description']"))
            .ios(By.xpath("//XCUIElementTypeStaticText[@name='product description']"));

    private CombinedBy btnCart = CombinedBy
            .android(By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView"))
            .ios((By.id("tab bar option cart")));


    public Boolean checkProductPrice(String price) {
        CombinedAttribute priceTagAttribute = CombinedAttribute.android("text").ios("value");

        try {
            $(priceTag)
                    .scrollTo()
                    .shouldBe(Condition.visible, Condition.interactable)
                    .shouldHave(AppiumCondition.attribute(priceTagAttribute, String.valueOf(price)));
            String txtPriceTag = $(priceTag)
                    .getText();
            System.out.println("The price tag value is: " + txtPriceTag);
            return true;
        } catch (Throwable e) {
            return false;
        }

    }

    public Boolean checkProductName(String productName) {
        CombinedAttribute productNameAttribute = CombinedAttribute.android("text").ios("value");

        try {
            $(lblproductName)
                    .scrollTo()
                    .shouldBe(Condition.visible, Condition.interactable)
                    .shouldHave(AppiumCondition.attribute(productNameAttribute, productName));
            System.out.println("The product name displayed is :" + $(lblproductName).getText());
            return true;
        } catch (Throwable e) {
            return false;
        }

    }

    public Boolean checkSauceLabBagDescription() {
        CombinedAttribute sauceLabBagDescritpionAttribute = CombinedAttribute.android("text").ios("value");

        try {
            System.out.println("The product description is: " + $(txtProductDescription).getText());
            $(txtProductDescription)
                    .scrollTo()
                    .shouldBe(Condition.visible, Condition.interactable)
                    .shouldHave(AppiumCondition.attribute(sauceLabBagDescritpionAttribute, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."));

            return true;
        } catch (Throwable e) {
            return false;
        }

    }

    public void clickAddToCartBtn() {
//        CombinedAttribute addToCartBtnAttribute = CombinedAttribute.android("text").ios("name");

        try {
//            $(btnAddToCart)
//                    .scrollTo()
//                    .shouldBe(Condition.visible, Condition.interactable)
//                    .click();
            clickElement(btnAddToCart);


        } catch (Throwable e) {
            System.out.println("Error occured while clicking the add to cart button in description page" + e);
        }

    }

    public ShoppingCartScreen clickShoppingCartBtn() {
//        CombinedAttribute shoppingCartBtnAttribute = CombinedAttribute.android("text").ios("name");

        try {
//            $(btnCart)
//                    .scrollTo()
//                    .shouldBe(Condition.visible, Condition.interactable)
//                    .click();
            clickElement(btnCart);
            return screen(ShoppingCartScreen.class);
        } catch (Throwable e) {
            System.out.println("Error occurred while clicking the add to cart button in description page" + e);
        }

        return null;
    }


}
