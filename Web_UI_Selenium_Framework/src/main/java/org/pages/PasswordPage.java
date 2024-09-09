package org.pages;

import org.Utils.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {

    private final WebDriver driver;
    @FindBy(css = "button[data-testid='loginButton']")
    private WebElement loginBtn;
    @FindBy(css = "input[data-testid='passwordInput']")
    private WebElement passwordInputTxt;

    @FindBy(css = "input[data-testid='passwordInput']")
    private WebElement testPasswordInputTxt;

    @FindBy(css = "button[data-testid='loginButton']")
    private WebElement testLoginBtn;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public PasswordPage setPasswordInputTxt(String passwordTxt) {
        WebUtils.WaitUntilElementIsClickable(driver, passwordInputTxt);
        passwordInputTxt.sendKeys(passwordTxt);
        WebUtils.pressEnterButton(driver);
        return this;
    }

    public PasswordPage setTestPasswordInputTxt(String passwordTxt) {
        WebUtils.WaitUntilElementIsClickable(driver, testPasswordInputTxt);
        testPasswordInputTxt.sendKeys(passwordTxt);
//        WebUtils.pressEnterButton(driver);
        return this;
    }

    public PasswordPage clickLoginBtn() {
        WebUtils.WaitUntilElementIsClickable(driver, loginBtn);
        loginBtn.click();
        return this;
    }

    public PasswordPage clickTestLoginBtn() {
        WebUtils.WaitUntilElementIsClickable(driver, testLoginBtn);
        testLoginBtn.click();
        return this;
    }
}
