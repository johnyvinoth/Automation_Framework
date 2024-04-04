package org.pages;

import org.Utils.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    private final WebDriver driver;
    @FindBy(css = "button[data-testid='dashAccountMoreButton']")
    private WebElement dashAcctMoreBtn;

    @FindBy(css = "button[data-testid='dashLogoutButton'")
    private WebElement dashLogoutBtn;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logout()
    {
        WebUtils.WaitUntilElementIsClickable(driver,dashAcctMoreBtn);
        dashAcctMoreBtn.click();

        WebUtils.WaitUntilElementIsClickable(driver,dashLogoutBtn);
        dashLogoutBtn.click();

    }
}
