package org.pages;

import org.Utils.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(css = "input[data-testid='usernameInput']")
    private WebElement emailIdInput;

    @FindBy(css = "button[data-testid='continueButton']")
    private WebElement continueBtn;

    @FindBy(css = "input[data-testid='usernameInput']")
    private WebElement testUserName;

    @FindBy(css = "button[data-testid='continueButton']")
    private WebElement testContinueBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public LoginPage enterMailId(String email) {
        WebUtils.WaitUntilElementIsClickable(driver, emailIdInput);
        emailIdInput.sendKeys(email);
        WebUtils.pressEnterButton(driver);
        return this;
    }

    public LoginPage clickContinueBtn() {
        WebUtils.WaitUntilElementIsClickable(driver, continueBtn);
        continueBtn.click();
        return this;
    }

    public LoginPage enterTestMailId(String email) {
        WebUtils.WaitUntilElementIsClickable(driver, testUserName);
//        WebUtils.clickElementWithJavaScript(driver, testUserName,10,1000);
        testUserName.sendKeys(email);
//        WebUtils.pressEnterButton(driver);
        return this;
        //TODO: Currently when chrome and firefox are executed simultaneously, the driver for firefox
        // is still holding driver created for chrome so the elements are not getting identified and if firefox alone exectued
        //then elements are getting located without any issue.

        }

    public LoginPage clickTestContinueBtn() {
        WebUtils.WaitUntilElementIsClickable(driver, testContinueBtn);
        testContinueBtn.click();
        return this;
    }


}
