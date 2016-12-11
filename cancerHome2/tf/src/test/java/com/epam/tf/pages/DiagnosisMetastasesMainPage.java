package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Aliaksei_Astashkevic on 12/6/2016.
 */
public class DiagnosisMetastasesMainPage extends AbstractPage {
    WebDriverWait myWait = new WebDriverWait(driver, 20);

    public DiagnosisMetastasesMainPage(WebDriver driver) {
        super(driver);
    }

    private final String ADD_DATE = "08.08.2013";
    private final String EDIT_DATE = "12.12.2013";

    @FindBy(xpath = "//label[@for='DetectionDate']/..//input")
    private WebElement detectionDateInput;

    @FindBy(xpath = ".//div[@id='Process-Autocomplete-Root']//button")
    private WebElement arisingProcessButton;

    @FindBys(@FindBy(xpath = "//div[@id='Process-Autocomplete-Root']//ul//li"))
    private List<WebElement> arisingProcessList;

    @FindBy(xpath = ".//div[@id='AffectedArea-Autocomplete-Root']//button")
    private WebElement affectedAreaButton;

    @FindBys(@FindBy(xpath = "//div[@id='AffectedArea-Autocomplete-Root']//ul//li"))
    private List<WebElement> affectedAreaList;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = ".//button[@role='cancel-edit-btn']")
    private WebElement cancelButton;

    @FindBy(xpath = ".//div[@class='main-patient-data']//table//td[1]")
    private WebElement resultTable;

    @FindBy(xpath = "//a[contains(@class, 'glyphicon-edit')]")
    private WebElement editMetastasesDataButton;

    @FindBy(xpath = "//a[contains(@class, 'glyphicon-remove')]")
    private WebElement deleteMetastasesDataButton;

    @FindBy(xpath = ".//div[@class='bootstrap-dialog-footer']//button[contains(@class, btn-success)]")
    private WebElement popupDeleteButton;

    public void fillMetastasesData() {
        detectionDateInput.clear();
        detectionDateInput.sendKeys(ADD_DATE);
        arisingProcessButton.click();
        wait.waitForJQuery(driver);
        arisingProcessList.get(1).click();
        wait.waitForJQuery(driver);
        saveButton.click();
    }

    public void editMetastasesData() {
        wait.waitForJQuery(driver);
        editMetastasesDataButton.click();
        detectionDateInput.clear();
        detectionDateInput.sendKeys(EDIT_DATE);
        arisingProcessButton.click();
        wait.waitForJQuery(driver);
        arisingProcessList.get(0).click();
        wait.waitForJQuery(driver);
        saveButton.click();
    }

    public void deleteMetastasesData() {
        wait.waitForJQuery(driver);
        deleteMetastasesDataButton.click();
        wait.waitForJQuery(driver);
        popupDeleteButton.click();
    }


    public String getADD_DATE() {
        return ADD_DATE;
    }

    public String getEDIT_DATE() {
        return EDIT_DATE;
    }

    public Boolean resultTableContainsValue(String date) {
        wait.waitForJQuery(driver);
        Assert.assertTrue(resultTable.getText().contains(date));
        return true;
    }

    public Boolean elementHasPresented() {
        wait.waitForJQuery(driver);
        Assert.assertTrue(arisingProcessButton.isDisplayed());
        return true;
    }

}
