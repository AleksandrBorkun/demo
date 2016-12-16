package com.epam.tf.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ExplicitWait {
    private WebDriver driverWait;
    private Wait<WebDriver> wait;

    public ExplicitWait(WebDriver driver) {
        this.driverWait = driver;
        wait = new WebDriverWait(this.driverWait, 10).ignoring(StaleElementReferenceException.class, WebDriverException.class)
                .withMessage("Element was not found by locator ");
    }

    public ExplicitWait(WebDriver driver, int time) {
        this.driverWait = driver;
        wait = new WebDriverWait(driver, time).ignoring(StaleElementReferenceException.class, WebDriverException.class)
                .withMessage("Element was not found by locator ");
    }

    public void waitForElementDisapearing(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Alert waitAlertWindow() throws TimeoutException{
         return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForElementAppearing(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementsAppearing(List<WebElement> elementList){
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }


    public void waitForJQuery(WebDriver driver) {
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return jQuery.active === 0");
            }
        });
    }
}
