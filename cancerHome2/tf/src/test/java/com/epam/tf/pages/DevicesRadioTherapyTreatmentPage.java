package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static com.epam.tf.utils.ThreadSleep.waitElement;

/**
 * Created by Kiryl_Shyshko on 12/10/2016.
 */
public class DevicesRadioTherapyTreatmentPage extends  DiagnosisTreatmentMainPage{


    @FindBy(xpath = ".//*[@id='CharacterOfRadiationTreatment-Autocomplete-Button']")
    private WebElement charachterRadiotherapyButton;
    @FindBys(@FindBy(xpath = ".//*[@id='CharacterOfRadiationTreatment-Autocomplete-Root']/ul/li"))
    private List<WebElement> characterRadiotherapyList;

    @FindBy(xpath = ".//*[@id='TypeOfImpact-Autocomplete-Button']")
    private  WebElement     typesOfImpactbutton;
    @FindBys(@FindBy(xpath = ".//*[@id='TypeOfImpact-Autocomplete-Root']/ul/li"))
    private List<WebElement> typesOfImpact;

    @FindBy(xpath = ".//*[@id='Modifiers-Autocomplete-Button']")
    private  WebElement    modifiersAutocompliteButton ;
    @FindBys(@FindBy(xpath = ".//*[@id='Modifiers-Autocomplete-Root']/ul/li"))
    private List<WebElement> modifiersAutocomliteList;

    @FindBy(xpath = ".//*[@id='ImpactZone-Autocomplete-Button']")
    private  WebElement  impactZoneButton;
    @FindBys(@FindBy(xpath = ".//*[@id='ImpactZone-Autocomplete-Root']/ul/li"))
    private List<WebElement> impactZones;

    @FindBy(xpath = ".//*[@id='DefeatOrgan-Autocomplete-Button']")
    private  WebElement    affectedOrganButton;

    @FindBys(@FindBy(xpath = ".//*[@id='DefeatOrgan-Autocomplete-Root']/ul/li"))
    private List<WebElement> affectedOrganList;

    @FindBy(xpath = ".//*[@id='SumDoza']")
    private WebElement summaryDose;

    @FindBy(css = ".form-group>.btn-success")
    private WebElement saveEditsButton;

    @FindBys(@FindBy(xpath = ".//*[@id='partial']//tbody/tr/td"))
    private List<WebElement> devicesRadioTherapyDataTreatmentList;

    @FindBy(xpath = "//button[text()='Удалить']")
    private WebElement confirmDelete;

    @FindBy(css = "#form0>h3")
    private WebElement devicesRadiotherapyTreatmentForm;

    public DevicesRadioTherapyTreatmentPage(WebDriver driver) {
        super(driver);
    }

    public void editDevicesRadiotherapyTreatment(int character, int impactType, int modifiers, int impactZone,int affectedOrgan, String dose ){
        waitForLoaderIndicatorDisapearing();

        charachterRadiotherapyButton.click();
        characterRadiotherapyList.get(character).click();

        waitElement(300);
        typesOfImpactbutton.click();
        typesOfImpact.get(impactType).click();

        waitElement(300);
        modifiersAutocompliteButton.click();
        modifiersAutocomliteList.get(modifiers).click();

        waitElement(300);
        impactZoneButton.click();
        impactZones.get(impactZone).click();

        wait.waitForElementIsClickable(affectedOrganButton);
        waitElement(100);
        affectedOrganButton.click();

        affectedOrganList.get(affectedOrgan).click();

        summaryDose.click();
        summaryDose.clear();
        summaryDose.sendKeys(dose);

        saveEditsButton.click();

    }

    public void confirmDeleteDevicesRadiotherapyTreatment() {
        confirmDelete.click();
    }

    public boolean isDevicesRadiotherapyCharacterPresent(String drugName) {
        waitForLoaderIndicatorDisapearing();
        return devicesRadioTherapyDataTreatmentList.get(0).getText().equals(drugName);

    }
    public boolean isDevicesRadiotherapyTreatmentDeleted() {
        waitForLoaderIndicatorDisapearing();
        return devicesRadiotherapyTreatmentForm.isDisplayed();
    }


}
