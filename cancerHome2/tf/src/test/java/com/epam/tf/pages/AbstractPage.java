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
    protected WebDriver driver;
    protected ExplicitWait wait;
    protected Actions actions;


    @FindBy(css = ".ui-autocomplete.ui-front.ui-menu.ui-widget.ui-widget-content")
    protected WebElement selectblock;

    @FindBy(id = "Name")
    protected WebElement listNameField;

    @FindBy(xpath = "//button[@type='submit' and @class='btn-success']")
    protected WebElement buttonSave;

    @FindBy(xpath = "//a[@class = 'glyphicon glyphicon-edit']")
    private WebElement editDataCommonButton;

    @FindBy(css = ".glyphicon-remove")
    private WebElement deleteDataCommonButton;

    @FindBy(xpath = ".//*[@id='partial']/a")
    private WebElement addDataCommonButton;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new ExplicitWait(driver);
        this.actions = new Actions(driver);
    }

    public void saveList(String random) {
    	listNameField.clear();
    	listNameField.sendKeys(random);
        buttonSave.click();
    }

    protected void waitForLoaderIndicatorDisapearing() {
        ExplicitWait waits = new ExplicitWait(driver, 25);
        waits.waitForElementDisapearing(By.id("progress"));
    }

    protected void selectByText(String textToSelect) {
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

    public void clickButtonById(String buttonId) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementById('" + buttonId + "').click()");
    }

    public void editDataCommonButtonClick() {
        editDataCommonButton.click();
    }

    public void deleteDataCommonButtonClick() {
        wait.waitForElementIsClickable(deleteDataCommonButton);
        deleteDataCommonButton.click();
    }

    public void addDataCommonButton(){
        wait.waitForElementIsClickable(addDataCommonButton);
        addDataCommonButton.click();
    }

}
