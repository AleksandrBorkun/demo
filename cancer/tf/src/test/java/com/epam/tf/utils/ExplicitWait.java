package com.epam.tf.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ExplicitWait {
    private final WebDriver driverWait;
    private final Wait<WebDriver> wait;

    public ExplicitWait(WebDriver driver) {
        this.driverWait = driver;
        wait = new WebDriverWait(this.driverWait, 90).ignoring(StaleElementReferenceException.class, WebDriverException.class)
                .withMessage("Element was not found by locator ");
}

    public ExplicitWait(WebDriver driver, int time) {
        this.driverWait = driver;
        wait = new WebDriverWait(driver, time).ignoring(StaleElementReferenceException.class, WebDriverException.class)
                .withMessage("Element was not found by locator ");
    }

    public void waitForElementDisappearing(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementAppearing(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForElementsAppearing(List<WebElement> elementList){
        new WebDriverWait(driverWait, 5).until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public void waitForJQuery(WebDriver driver) {

        new WebDriverWait(driver, 15).until((ExpectedCondition<Boolean>) d -> {
            JavascriptExecutor js = (JavascriptExecutor) d;
            return (Boolean) (js != null ? js.executeScript("return jQuery.active === 0") : null);
        });
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    public void magicWaiter(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
