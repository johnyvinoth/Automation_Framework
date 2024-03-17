package org.pages;

import org.Utils.WebUtils;
import org.Utils.Web_UI_ConfigurationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    @FindBy(css = "button[data-testid='addCommentButton']")
    private List<WebElement> tiles = new ArrayList<>();

    @FindBy(css = "p[data-placeholder='Add comment']")
    private List<WebElement> commentsSection = new ArrayList<>();

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

        for(int i = 0; i <tiles.size(); i++)
        {
            tiles.get(i).click();
//            WebUtils.WaitUntilElementIsClickable(driver,commentsSection);
            WebUtils.WaitUntilElementIsClickable(driver,  commentsSection.get(i));
            commentsSection.get(i).sendKeys(comment+Math.random());
//            Actions action = new Actions(driver);
//            action.sendKeys(Keys.ENTER);
//            action.perform();
            WebUtils.pressEnterButton(driver);
        }
//        for(WebElement commentSec: commentsSection)
//        {
//            Thread.sleep(2000);
//            WebUtils.WaitUntilElementIsClickable(driver, commentSec);
//            commentSec.sendKeys(comment+"_"+Math.random());
//            WebUtils.pressEnterButton(driver);
//
//        }
        }

        public void getTitle()
        {
            System.out.println("The Title is " + driver.getTitle());
        }
    }

