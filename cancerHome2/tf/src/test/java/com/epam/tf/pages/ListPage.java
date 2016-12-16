package com.epam.tf.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.epam.tf.utils.ThreadSleep;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ListPage extends AbstractPage{

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='navbar-brand']")
	private WebElement logo;
    
    @FindBy(xpath = "//a[@class='dropdown-toggle btn btn-primary']")
    private WebElement buttonCreateList;

    @FindBy(xpath = "//button[@action='/Lists/List/CreateEmpty']")
    private WebElement buttonEmptyList;

    @FindBy(xpath = "//td/a[@data-ajax='true']")
    private WebElement spanListName;

    @FindBy(xpath = "//a[@data-content='Удалить']")
    private WebElement buttonDeleteList;

    @FindBy(xpath = "//button[text()='Удалить']")
    private WebElement buttonRemoveFromConfirmation;

    @FindBy(xpath = "//a[@data-content='Редактировать']")
    private WebElement buttonEdit;

    @FindAll(@FindBy(xpath = "//a[@data-content='Удалить']"))
    private List<WebElement> removeButtonsList;

    public ListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void createEmptyList(String random){
        buttonCreateList.click();
        buttonEmptyList.click();
        saveList(random);
    }

    public void editOneNoteList() {
		buttonEdit.click();
		ThreadSleep.waitElement(450);
	}
    
    public String getFirstListName() {
        wait.waitForElementIsClickable(spanListName);
        String name = spanListName.getText();
        return name;
    }

    public void removeFirstList(){
        buttonDeleteList.click();
        buttonRemoveFromConfirmation.click();
    }

    public List<WebElement> getRemoveButtonsList(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return removeButtonsList;
    }

    public void turnToListDetails(){
        buttonEdit.click();
    }

    public void goToMainPage() {
		logo.click();
	}

  }
