package com.epam.tf.pages;

import com.epam.tf.data.DispensaryData;
import com.epam.tf.data.PassportData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPatientPage extends AbstractPage{

    public NewPatientPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Name_LastName")
    private WebElement lastNameForm;
    @FindBy(id = "Name_FirstName")
    private WebElement firstNameForm;
    @FindBy(id = "DateOfBirth")
    private WebElement dateOfBirthForm;
    @FindBy(id = "PersonalNumber")
    private WebElement personalNumber;
    @FindBy(id = "Sex-Autocomplete-Button")
    private WebElement sexAutocompleteButton;
    @FindBy(xpath = "//li[contains(text(), 'мужской')]")
    private WebElement manSexSelection;
    @FindBy(xpath = "//li[contains(text(), 'женский')]")
    private WebElement womanSexSelection;
    @FindBy(xpath = "//button[@id='CurrentState-Autocomplete-Button']")
    private WebElement currentStateAutocompleteButton;
    @FindBy(xpath = "//input[@id='CurrentState_Autocomplete']")
    private WebElement currentStateAutocomplete;
    @FindBy(xpath = "//b[text() = '1']")
    private WebElement aliveState;
    @FindBy(id = "Address_ResidencePlaceCode_CatalogueField")
    private WebElement addressResidencePlaceCodeCatalogueField;
    @FindBy(id = "RegistrationDate")
    private WebElement registrationDate;
    @FindBy(id = "Ambulance_Autocomplete")
    private WebElement ambulanceAutocomplete;
    @FindBy(id = "WasPreviouslyRegistered_Autocomplete")
    private WebElement wasPreviouslyRegisteredAutocomplete;
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement saveButton;


    public void populateIdentify(PassportData passportData) {
        lastNameForm.sendKeys(passportData.getSurname());
        firstNameForm.sendKeys(passportData.getName());
        dateOfBirthForm.sendKeys(passportData.getBirthday());
        personalNumber.sendKeys(passportData.getPersonalNumber());
        sexAutocompleteButton.click();
        manSexSelection.click();
        currentStateAutocomplete.sendKeys(passportData.getCurrentCondition());

    }

    public void populatePlaceOfLiving(PassportData passportData) {
        addressResidencePlaceCodeCatalogueField.sendKeys(passportData.getCodeTersone());

    }

    public void populateAdditionalInfo(PassportData passportData, DispensaryData dispensaryData) {
        registrationDate.sendKeys(passportData.getTakeAccountOfDate());
        ambulanceAutocomplete.sendKeys(dispensaryData.getPoliclinic());
        wasPreviouslyRegisteredAutocomplete.click();
        wasPreviouslyRegisteredAutocomplete.sendKeys(dispensaryData.getBeforeCondition());
        saveButton.click();

    }
}
