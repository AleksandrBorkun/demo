package com.epam.tf.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class OtherImpactTreatmentPage extends DiagnosisTreatmentMainPage {

    @FindBy(xpath = ".//*[@id='Impact-Autocomplete-Button']")
    private WebElement impactTypeButton;

    @FindBys(@FindBy(xpath = ".//*[@id='Impact-Autocomplete-Root']//li"))
    private List<WebElement> impactTypes;

    @FindBy(xpath = ".//*[@id='AnotherStartDate']")
    private WebElement startImpactDate;

    @FindBy(xpath = ".//*[@id='AnotherEndDate']")
    private WebElement endImpactDate;

    @FindBy(css = "#form0>h3")
    private WebElement otherImpactTreatmentForm;

    @FindBy(css = ".form-group>.btn-success")
    private WebElement saveEditsButton;

    @FindBys(@FindBy(xpath = ".//*[@id='partial']//tbody/tr/td"))
    private List<WebElement> otherImpactDataTreatmentList;

    @FindBy(xpath = "//button[text()='Удалить']")
    private WebElement confirmDelete;


    public OtherImpactTreatmentPage(WebDriver driver) {
        super(driver);
    }

    public void editOtherImpactTreatmentOfdaignosis(int impactType, String startImpactDate, String endImpactDate){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(impactTypeButton);
        impactTypeButton.click();
        impactTypes.get(impactType).click();
        this.startImpactDate.sendKeys(startImpactDate);
        this.endImpactDate.sendKeys(endImpactDate);
        saveEditsButton.click();


    }
    public void confirmDeleteOtherImpactTreatment() {
        confirmDelete.click();
    }

    public boolean isOtherImpactTypePresent(String drugName){
        waitForLoaderIndicatorDisapearing();
        return otherImpactDataTreatmentList.get(0).getText().equals(drugName);
    }
    public boolean isOtherImpactTreatmentDeleted(){
        waitForLoaderIndicatorDisapearing();
        return otherImpactTreatmentForm.isDisplayed();
    }

}
