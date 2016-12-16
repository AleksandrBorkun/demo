package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

/**
 * Created by Kiryl_Shyshko on 12/6/2016.
 */
public class СhemotherapyTreatmentOfDiagnosisPage extends DiagnosisTreatmentMainPage {



    @FindBy(xpath = ".//*[@id='Preparation-Autocomplete-Button']")
    private WebElement chooseDrugButton;

    @FindBys(@FindBy(xpath = ".//*[@id='Preparation-Autocomplete-Root']/ul/li"))
    private List<WebElement> drugs;

    @FindBy(xpath = ".//*[@id='TotalDose']")
    private WebElement totalDose;

    @FindBy(xpath = ".//*[@id='Unit-Autocomplete-Button']")
    private WebElement chooseUnitOfDoseButton;

    @FindBys(@FindBy(xpath = ".//*[@id='Unit-Autocomplete-Root']/ul/li"))
    private List<WebElement> unitsOfDose;

    @FindBy(xpath = ".//button[@id='Method-Autocomplete-Button']")
    private WebElement chooseInjectionMethodButton;

    @FindBys(@FindBy(xpath = ".//*[@id='Method-Autocomplete-Root']//li"))
    private List<WebElement> injectionMethods;

    @FindBy(css = ".form-group>.btn-success")
    private WebElement saveEditsButton;

    @FindBy(xpath = ".//*[@id='partial']/a")
    private WebElement addButton;

    @FindBys(@FindBy(xpath = ".//*[@id='partial']//tbody/tr/td"))
    private List<WebElement> chemotherapyDataTreatmentList;

    @FindBy(xpath = "//button[text()='Удалить']")
    private WebElement confirmDelete;

    @FindBy(css = "#form0>h3")
    private WebElement chemotherapyTreatmentForm;

    public СhemotherapyTreatmentOfDiagnosisPage(WebDriver driver) {
        super(driver);

    }

    public void editChemotherapyTreatmentOfDiagnosis(int drug, String dose, int unitOfDose, int injectionMethod) {
        waitForLoaderIndicatorDisapearing();
        chooseDrugButton.click();
        drugs.get(drug).click();
        totalDose.clear();
        totalDose.sendKeys(dose);

        chooseUnitOfDoseButton.click();
        unitsOfDose.get(unitOfDose).click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chooseInjectionMethodButton.click();
        injectionMethods.get(injectionMethod).click();
        saveEditsButton.click();
    }

    public void confirmDeleteChemotherapyTreatment() {
        confirmDelete.click();
    }

    public boolean isChemotherapyDrugPresent(String drugName) {
        waitForLoaderIndicatorDisapearing();
        return chemotherapyDataTreatmentList.get(0).getText().equals(drugName);

    }

    public boolean isChemotherapyTreatmentDeleted() {
        waitForLoaderIndicatorDisapearing();
        return chemotherapyTreatmentForm.isDisplayed();
    }


}



