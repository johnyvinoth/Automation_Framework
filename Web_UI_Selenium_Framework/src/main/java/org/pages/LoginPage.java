package org.pages;

import org.Utils.WebUtils;
import org.openqa.selenium.By;
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

    public void enterMailId(String email) {
        WebUtils.WaitUntilElementIsClickable(driver, emailIdInput);
        emailIdInput.sendKeys(email);
        WebUtils.pressEnterButton(driver);
    }

    public void clikcContinueBtn() {
        WebUtils.WaitUntilElementIsClickable(driver, continueBtn);
        continueBtn.click();
    }

       public void enterTestMailId(String email) {
        WebUtils.WaitUntilElementIsClickable(driver, testUserName);
        testUserName.sendKeys(email);
//        WebUtils.pressEnterButton(driver);
    }

    public void clikcTestContinueBtn() {
        WebUtils.WaitUntilElementIsClickable(driver, testContinueBtn);
        testContinueBtn.click();
    }


}
