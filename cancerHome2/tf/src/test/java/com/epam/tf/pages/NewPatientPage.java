package com.epam.tf.pages;

import com.epam.tf.data.Diagnosis;
import com.epam.tf.data.DispensaryData;
import com.epam.tf.data.PassportData;
import com.epam.tf.utils.ExplicitWait;
import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NewPatientPage extends AbstractPage{

    public NewPatientPage(WebDriver driver) {
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

    @FindBy(id = "WasPreviouslyRegistered-Autocomplete-Button")
    private WebElement buttonWasPreviouslyRegisteredAutocomplete;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement saveButton;

    //DIAGNOSIS PART

    @FindBy(id = "Mkb10Code_CatalogueField")
    private WebElement mkb10CodeForm;

    @FindBy(id = "StartDate")
    private WebElement diagnosStartDateForm;

    @FindBy(id = "Pair-Autocomplete-Button")
    private WebElement pairToSelectButton;

    @FindBy(id = "Text")
    private WebElement diagnoseTextField;

    @FindBy(id = "Source-Autocomplete-Button")
    private WebElement sourceOfInfoToSelectButton;

    @FindBy(id ="Clinic_CatalogueField")
    private WebElement camePlaceForm;

    @FindBy(id = "Stage-Autocomplete-Button")
    private WebElement phaseToSelectButton;

    @FindBy(id = "T-Autocomplete-Button")
    private WebElement tToSelectButton;

    @FindBy(id = "N-Autocomplete-Button")
    private WebElement nToSelectButton;

    @FindBy(id = "M-Autocomplete-Button")
    private WebElement mToSelectButton;

    @FindBy(id = "Multiply-Autocomplete-Button")
    private WebElement multiplyToSelectButton;

    @FindBy(id = "Condition-Autocomplete-Button")
    private WebElement examinationConditionToSelectButton;

    @FindBy(id = "ConfirmMethod-Autocomplete-Button")
    private WebElement confirmationMethodToSelectButton;

    @FindBy(id = "MorphologyCode10_CatalogueField")
    private WebElement morphologyForm;

    @FindBy(id = "ResearchNumber")
    private WebElement researchNumberForm;

    @FindBy(id = "ResearhDate")
    private WebElement researhDateForm;






    public void populateIdentify(PassportData passportData) {
        cardNumberForm.sendKeys(passportData.getPatientCardNumber());
        lastNameForm.sendKeys(passportData.getSurname());
        firstNameForm.sendKeys(passportData.getName());
        middleNameForm.sendKeys(passportData.getPatronymic());
        dateOfBirthForm.sendKeys(passportData.getBirthday());
        personalNumber.sendKeys(passportData.getPersonalNumber());
        sexAutocompleteButton.click();
        selectByText(passportData.getSex());
        actions.clickAndHold(currentStateAutocompleteButton).build().perform();
        ThreadSleep.waitElement(300);
        actions.release(currentStateAutocompleteButton).build().perform();
        ThreadSleep.waitElement(300);
        selectByText(passportData.getCurrentCondition());

    }

    public void populatePlaceOfLiving(PassportData passportData) {
        addressResidencePlaceCodeCatalogueField.sendKeys(passportData.getCodeTersone());
        ThreadSleep.waitElement(300);

    }

    public void populateAdditionalInfo(PassportData passportData, DispensaryData dispensaryData) {
        registrationDate.sendKeys(passportData.getTakeAccountOfDate());
        ambulanceAutocomplete.sendKeys(dispensaryData.getPoliclinic());
        waitForLoaderIndicatorDisapearing();
        ThreadSleep.waitElement(500);
        buttonWasPreviouslyRegisteredAutocomplete.click();
        selectByText(dispensaryData.getBeforeCondition());
    }

    public void populateGeneralDiagnosForm(Diagnosis diagnosis){

        ThreadSleep.waitElement(3000);
        actions.sendKeys(mkb10CodeForm,diagnosis.getCodeICD10()).build().perform();
//        char[] mkb10Code = diagnosis.getCodeICD10().toCharArray();
//        for(char symbol:mkb10Code){
//            mkb10CodeForm.sendKeys(symbol+"");
//            ThreadSleep.waitElement(800);
//        }
        mkb10CodeForm.sendKeys(diagnosis.getCodeICD10());
        diagnosStartDateForm.sendKeys(diagnosis.getDiagnosisDate());
        ThreadSleep.waitElement(400);
        pairToSelectButton.click();
        ThreadSleep.waitElement(400);
        selectByText(diagnosis.getPairingSymptom());
        ThreadSleep.waitElement(400);
        diagnoseTextField.sendKeys(diagnosis.getDiagnosisText());
        ThreadSleep.waitElement(400);
        sourceOfInfoToSelectButton.click();
        ThreadSleep.waitElement(400);
        selectByText(diagnosis.getSourceOfdiagnosisInfo());
        ThreadSleep.waitElement(400);
        camePlaceForm.sendKeys(diagnosis.getCamePlace());
    }

    public void populateStages(Diagnosis diagnosis){
        phaseToSelectButton.click();
        ThreadSleep.waitElement(400);
        selectByText(diagnosis.getPhase());
        ThreadSleep.waitElement(400);
        tToSelectButton.click();
        ThreadSleep.waitElement(400);
        selectByExactlyText(diagnosis.getT(),tToSelectButton);
        ThreadSleep.waitElement(400);
        nToSelectButton.click();
        ThreadSleep.waitElement(400);
        selectByExactlyText(diagnosis.getN(),nToSelectButton);
        ThreadSleep.waitElement(400);
        mToSelectButton.click();
        ThreadSleep.waitElement(400);
        selectByExactlyText(diagnosis.getM(),mToSelectButton);
        ThreadSleep.waitElement(400);
        multiplyToSelectButton.click();
        ThreadSleep.waitElement(400);
        selectByText(diagnosis.getMultiplicity());
        ThreadSleep.waitElement(400);
    }

    public void populateExamination(Diagnosis diagnosis){
        examinationConditionToSelectButton.click();
        ThreadSleep.waitElement(400);
        selectByText(diagnosis.getRevealingTerms());
        ThreadSleep.waitElement(400);
        confirmationMethodToSelectButton.click();
        ThreadSleep.waitElement(400);
        selectByText(diagnosis.getConfirmationMethod());
        ThreadSleep.waitElement(400);
        char[] morphology = diagnosis.getICD10morphology().toCharArray();
        for(char symbol:morphology){
            morphologyForm.sendKeys(symbol+"");
            ThreadSleep.waitElement(800);
        }
        //morphologyForm.sendKeys(diagnosis.getICD10morphology());
        ThreadSleep.waitElement(400);
        researchNumberForm.sendKeys(diagnosis.getMorphologicalStudyRate());
        ThreadSleep.waitElement(400);
        researhDateForm.sendKeys(diagnosis.getDateOfExamination());
    }

    public void saveData(){
        ThreadSleep.waitElement(1000);
        saveButton.click();
        waitForLoaderIndicatorDisapearing();
    }
}
