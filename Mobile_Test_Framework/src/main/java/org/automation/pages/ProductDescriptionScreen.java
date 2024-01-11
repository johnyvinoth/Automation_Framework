package org.automation.pages;

import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class ProductDescriptionScreen {

    private CombinedBy priceTag = CombinedBy
            .android(By.id("product price"))
            .ios(By.id("product price"));

    private CombinedBy btnAddToCart = CombinedBy
            .android(By.id("Add To Cart button"))
            .ios((By.id("Add To Cart button")));


    private CombinedBy txtProductDescription = CombinedBy
            .android(By.id("product description"))
            .ios((By.xpath("(//XCUIElementTypeOther[@name='Horizontal scroll bar, 1 page'])[2]")));

    private CombinedBy btnCart = CombinedBy
            .android(By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView"))
            .ios((By.id("tab bar option cart")));

    //TODO: Need to finish the methods for the Product Description page and take one full flow of purchase.

}
