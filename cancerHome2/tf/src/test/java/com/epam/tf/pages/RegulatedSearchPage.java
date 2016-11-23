package com.epam.tf.pages;


import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegulatedSearchPage extends AbstractPage{

    @FindBy(id = "ReportingYear")
    private WebElement controlYearField;

    @FindBy(id = "Dispensary_Autocomplete")
    private WebElement dispensaryField;

    @FindBy(css = ".btn.btn-primary.list-search.pull-right")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@dialogtitle='Новый список']")
    private WebElement buttonSaveInList;

    @FindBy(id = "Name")
    private WebElement listnameField;

    @FindBy(xpath = "//*[@type='submit' and text()='Сохранить']")
    private WebElement buttonSaveList;

    public RegulatedSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchForDispensaryCall(String year){
        controlYearField.sendKeys(year);
        searchButton.click();
    }

    public void saveSearchResultInList(String random){
        buttonSaveInList.click();
        listnameField.clear();
        listnameField.sendKeys(random);
        buttonSaveList.click();
        waitForLoaderIndicatorDisapearing();
    }



}
