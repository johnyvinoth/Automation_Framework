package org.pages;

import org.Utils.WebUtils;
import org.automation.WebUITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends WebUITestBase {
    private WebDriver driver;

    @CacheLookup
    @FindBy(css = "button[data-testid='addCommentButton']")
    private List<WebElement> tiles = new ArrayList<>();


    @FindBy(css = "p[data-placeholder='Add comment']")
    private List<WebElement> commentsSection = new ArrayList<>();

    @FindBy(css = "button[data-testid='surfaceAddPostButton']")
    private WebElement addPostButton;

    @FindBy(css = "a[data-testid='appBarAccountAvatar']")
    private WebElement appBarAcctAvatar;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAllTiles() {
        for (WebElement tile : tiles) {
            tile.click();
        }
    }

    public void addComments(String comment) throws InterruptedException {

        if(!tiles.isEmpty())
        {
            for (int i = 0; i < tiles.size(); i++) {
                tiles.get(i).click();
                WebUtils.WaitUntilElementsAreVisible(driver, commentsSection);
//            WebUtils.WaitUntilElementIsClickable(driver,  By.cssSelector("p[data-placeholder='Add comment']"));
                commentsSection.get(i).sendKeys(comment + "_" + Math.random());
                WebUtils.pressEnterButton(driver);
            }
            logger.info("Comments added in the tiles");
        }
        else
        {
            System.out.println("No Tiles to update the comments");
            logger.info("No Tiles to update the comments");
        }
    }

    public void clickAddPostBtn() {
        addPostButton.click();
    }

    public void clickAccountAvatarBtn() {
        appBarAcctAvatar.click();
    }

    public void getTitle() {
        System.out.println("The Title is " + driver.getTitle());
    }
}

