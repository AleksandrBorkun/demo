package com.epam.tf.pages;

import com.epam.tf.utils.ExplicitWait;
import com.epam.tf.utils.ThreadSleep;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    final WebDriver driver;
    final ExplicitWait wait;
    final Actions actions;

    @FindBy(id = "Name")
    WebElement listNameField;

    @FindBy(xpath = "//button[@type='submit' and @class='btn-success']")
    private WebElement saveButton;

    @FindBy(xpath = ".//button[text()='Подтвердить']")
    private WebElement confirmButton;

    @FindBy(id = "progress")
    private WebElement progressBar;
    
    @FindBy(xpath = "//a[@class = 'glyphicon glyphicon-edit']")
    private WebElement editDataCommonButton;
    
    @FindBy(css = ".glyphicon-remove")
    private WebElement deleteDataCommonButton;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new ExplicitWait(driver);
        this.actions = new Actions(driver);
    }

    public void saveList(String random) {
    	ThreadSleep.waitElement(250);
    	waitForLoaderIndicatorDisapearing();
    	listNameField.clear();
    	ThreadSleep.waitElement(150);
    	listNameField.sendKeys(random);
    	ThreadSleep.waitElement(150);
    	wait.waitForElementIsClickable(saveButton);
    	saveButton.click();
    	waitForLoaderIndicatorDisapearing();
    }

    void waitForLoaderIndicatorDisapearing() {
        ExplicitWait waits = new ExplicitWait(driver, 40);
        if(progressBar.isDisplayed())
            waits.waitForElementDisappearing(By.id("progress"));

    }

    void selectByText(String textToSelect) {
        WebElement element = driver.findElement(By.xpath("//li[contains(text(),'" + textToSelect + "')]"));
        wait.waitForElementIsClickable(element);
        ThreadSleep.waitElement(500);
        element.click();
    }

    protected void selectByExactlyText(String textToSelect, WebElement buttonToSelect) {
        WebElement element = driver.findElement(By.xpath("//button[@id='" + buttonToSelect.getAttribute("id") + "']/../..//li[text()='" + textToSelect + "']"));
        wait.waitForElementIsClickable(element);
        ThreadSleep.waitElement(500);
        element.click();
    }

    public void highlightElement(WebElement element) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        ThreadSleep.waitElement(3000);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    void clickButtonById(String buttonId) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementById('" + buttonId + "').click()");
    }


    void clickConfirmButton() {
        confirmButton.click();
    }

    public void editDataCommonButtonClick() {
        waitForLoaderIndicatorDisapearing();
        wait.waitForJQuery(driver);
        wait.waitForElementIsClickable(editDataCommonButton);
        editDataCommonButton.click();
    }

    public void deleteDataCommonButtonClick() {
        wait.waitForElementIsClickable(deleteDataCommonButton);
        deleteDataCommonButton.click();

    }

    void clickSaveButton() {
        saveButton.click();
    }

}
