package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static com.epam.tf.utils.ThreadSleep.waitElement;


public class PharmacologyRadiotherapyTreatmentPage extends DiagnosisTreatmentMainPage {

    @FindBy(xpath = ".//*[@id='IzotopCode-Autocomplete-Button']")
    private WebElement pharmacologyDrugButton;
    @FindBys(@FindBy(xpath = ".//*[@id='IzotopCode-Autocomplete-Root']/ul/li"))
    private List<WebElement> pharmacologyDrugList;

    @FindBy(xpath = ".//*[@id='DateOfIntroduction']")
    private WebElement injectionDate;

    @FindBy(xpath = ".//*[@id='Dose']")
    private WebElement dose;

    @FindBy(css = ".form-group>.btn-success")
    private WebElement saveEditsButton;

    @FindBy(xpath = "//button[text()='Удалить']")
    private WebElement confirmDelete;

    @FindBys(@FindBy(xpath = ".//*[@id='partial']//tbody/tr/td"))
    private List<WebElement> pharmacologyRadiotherapyDataTreatmentList;

    @FindBy(css = "#form0>h3")
    private WebElement pharmacologyRadiotherapyTreatmentForm;

    public PharmacologyRadiotherapyTreatmentPage(WebDriver driver) {
        super(driver);
    }

    public void editPharmacologyRadiotherapyTreatment(int pharmacologyDrug, String injectionDate, String dose) {
        waitForLoaderIndicatorDisapearing();

        pharmacologyDrugButton.click();
        pharmacologyDrugList.get(pharmacologyDrug).click();
        waitElement(500);
        this.injectionDate.sendKeys(injectionDate);
        this.dose.clear();
        this.dose.sendKeys(dose);
        saveEditsButton.click();

    }

    public void confirmDeletePharmacologyRadiotherapyTreatment() {
        confirmDelete.click();
    }

    public boolean isPharmacologyRadiotherapyDrugPresent(String drugName){
            waitForLoaderIndicatorDisapearing();
        return pharmacologyRadiotherapyDataTreatmentList.get(0).getText().equals(drugName);
    }
    public boolean isPharmacologyTherapyTreatmentDeleted() {
        waitForLoaderIndicatorDisapearing();
        return pharmacologyRadiotherapyTreatmentForm.isDisplayed();
    }
}
