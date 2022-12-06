package com.herokuapp.theinternet.utility;

import com.herokuapp.theinternet.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Utility extends ManageBrowser {
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }
    //** Alert Methods********
    public void switchToAlert() {
        driver.switchTo().alert();
    }
    public void switchToAlertGetText(){
        driver.switchTo().alert().getText();
    }
    public void switchToAlertAccept(){
        driver.switchTo().alert().accept();
    }
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
        // WebElement emailField = driver.findElement(by);
        // emailField.sendKeys(t
    }
    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();}
    // homework 4 method AcceptAllert,dismissAlert, String getTextFromAlert,sendTextToAlert(String text)
    // ****************select class methods*******
    public void TestDropDown(){
        WebElement dropDown= driver.findElement(By.name("String"));
        Select select = new Select(dropDown);}

    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);}
    //this method will select option by Index - like 1.2.3
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }
    //this method will select option by contains text
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }
    //This method will close all windows
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }
    //This method will switch to parent window
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }
    //This method will find that we switch to right window
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
    public void verifyMessage(String expectedMessage,String actualMessage){
        //  Assert.assertEquals(expectedMessage,actualMessage);
    }
    public void verifyExpectedAndActual(By by,String expectedText) {
        String actualText = getTextFromElement(by);
        // Assert.assertEquals(actualText, expectedText);
    }
    public void drangAndDrop(By by, By by1) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(by), driver.findElement(by)).build().perform();}

    //WebElement draggable = driver.findElement(By.id("draggable"));
    //WebElement droppable = driver.findElement(By.id("droppable"));
    //actions.dragAndDrop(draggable, droppable).build().perform();
    //Mouse Hover action method
    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    public void mouseHoverToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public void mouseHoverToElementAndClick(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }//This method will use to wait until  VisibilityOfElementLocated

    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);


        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }
}
