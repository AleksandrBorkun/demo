package com.epam.tf.pages;

import com.epam.tf.entity.TestCase;
import com.epam.tf.steps.PatientCardPageSteps;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.Test;

import java.util.List;

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

    @FindBy(xpath = "//a[text()='Диагнозы']")
    private WebElement goToPatientCardPageButton;

    @FindBy(xpath = ".//*[@id='Sex-Autocomplete-Button']")
    private WebElement buttonGenderSelect;

    @FindBy(xpath = ".//li[text() = ' - женский']")
    private WebElement womanSelect;

    @FindBy(xpath = ".//li[text() = ' - мужской']")
    private WebElement manSelect;


    @FindBys(@FindBy(xpath = ".//*[@id='validationErorCollapse']//li"))
    private List<WebElement> validationWarningList;

    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement alertWindow;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    private WebElement confirmAlert;

    @FindBy(xpath = "//div[@class='panel-title']/a")
    private WebElement validationWarnings;

    private Boolean genderDifference = false;

    public Boolean getGenderDifference() {
        return genderDifference;
    }

    public void editGender(TestCase testCase){
        String sex = testCase.getSex();
        String sexInputString = sexInputField.getAttribute("value");
        if(sexInputString.equals(sex)) {
            genderDifference = true;
            return;
        }

        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(buttonGenderSelect);
        clickButtonGenderSelect();

        if(sex.contains("1 - мужской")){
            wait.waitForElementIsClickable(manSelect);
            manSelect.click();
        } else if(sex.contains("2 - женский")){
            wait.waitForElementIsClickable(womanSelect);
            womanSelect.click();
        }
        waitForLoaderIndicatorDisapearing();
    }

    public void editGenderWithByteSexField(TestCase testCase){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(buttonGenderSelect);
        clickButtonGenderSelect();
        Byte sexByte = testCase.getPatient().getSex();

        if(sexByte == 1){
            wait.waitForElementIsClickable(manSelect);
            manSelect.click();
        } else{
            wait.waitForElementIsClickable(womanSelect);
            womanSelect.click();
        }
    }

    private void clickButtonGenderSelect(){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(buttonGenderSelect);
        waitForLoaderIndicatorDisapearing();
        buttonGenderSelect.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void editState(TestCase testCase){
        currentStateAutocomplete.clear();
        currentStateAutocomplete.sendKeys(testCase.getPatient().getState());
    }

    public void clickSaveButton(){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(saveButton);
        waitForLoaderIndicatorDisapearing();
        saveButton.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementAppearing(saveButton);
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(saveButton);
    }

    public void clickGoToPatientCardPageButton(){
        waitForLoaderIndicatorDisapearing();
        waitForLoaderIndicatorDisapearing();
        goToPatientCardPageButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    private void getAlertWindowForGender(){
           wait.waitForElementAppearing(alertWindow);
    }

    public void confirmAlertWindow(){
        getAlertWindowForGender();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(confirmAlert);
        confirmAlert.click();
        waitForLoaderIndicatorDisapearing();
    }


    public StringBuilder getWarningMessage(){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementAppearing(validationWarnings);
        wait.waitForElementIsClickable(validationWarnings);
        validationWarnings.click();
        StringBuilder errors = new StringBuilder();
        wait.waitForElementsAppearing(validationWarningList);
        for (WebElement liElement: validationWarningList) {
            wait.waitForElementAppearing(liElement);
            errors.append(liElement.getText());
        }
        return errors;
    }
}
