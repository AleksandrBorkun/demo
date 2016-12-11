package com.epam.tf.pages;

import com.epam.tf.entity.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Nikolay_Golubitsky on 12/9/2016.
 * This class describe page which represents ability to manipulate
 * with papient pasport data
 *
 */
public class EditPassportDataPage extends AbstractPage {

    public EditPassportDataPage(WebDriver driver) {
        super(driver);
    }

    //PASSPORT PART

    @FindBy(id = "PatientCardNumber")
    private WebElement cardNumberForm;

    @FindBy(id = "Name_LastName")
    private WebElement lastNameForm;

    @FindBy(id = "Name_FirstName")
    private WebElement firstNameForm;

    @FindBy(id = "Name_MiddleName")
    private WebElement middleNameForm;

    @FindBy(id = "DateOfBirth")
    private WebElement dateOfBirthForm;

    @FindBy(id = "PersonalNumber")
    private WebElement personalNumber;

    @FindBy(id = "Sex-Autocomplete-Button")
    private WebElement sexAutocompleteButton;

    @FindBy(id = "Sex_Autocomplete")
    private WebElement sexInputField;

    @FindBy(id = "CurrentState-Autocomplete-Button")
    private WebElement currentStateAutocompleteButton;

    @FindBy(xpath = "//input[@id='CurrentState_Autocomplete']")
    private WebElement currentStateAutocomplete;

    @FindBy(xpath = "//b[text() = '1']")
    private WebElement aliveState;

    @FindBy(css = "input#Address_ResidencePlaceCode_CatalogueField")
    private WebElement addressResidencePlaceCodeCatalogueField;

    @FindBy(id = "RegistrationDate")
    private WebElement registrationDate;

    @FindBy(id = "Ambulance_Autocomplete")
    private WebElement ambulanceAutocomplete;

    @FindBy(id = "WasPreviouslyRegistered_Autocomplete")
    private WebElement wasPreviouslyRegistredInputField;

    @FindBy(id = "WasPreviouslyRegistered-Autocomplete-Button")
    private WebElement buttonWasPreviouslyRegisteredAutocomplete;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement saveButton;

    public void editGender(TestCase testCase){
        sexInputField.clear();
        sexInputField.sendKeys(testCase.getSex());
    }

    public void editState(TestCase testCase){
        currentStateAutocomplete.clear();
        currentStateAutocomplete.sendKeys(testCase.getNowStage());
    }

    public void clickSaveButton(){
        saveButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    public String getErrormessage(){
        return new String();
    }
}
