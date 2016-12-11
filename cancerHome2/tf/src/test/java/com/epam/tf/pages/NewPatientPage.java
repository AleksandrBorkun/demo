package com.epam.tf.pages;

import com.epam.tf.entity.Patient;
import com.epam.tf.data.Diagnosis;
import com.epam.tf.utils.Random;
import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPatientPage extends AbstractPage {

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

    @FindBy(id = "Clinic_CatalogueField")
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

    ///////////add clinical group
    @FindBy(xpath = "//a[text()='Списки']")
    private WebElement listButton;

    @FindBy(xpath = "//a[contains(text(),'Черновики')]")
    private WebElement draftList;

    @FindBy(xpath = "/descendant::a[last()]")
    private WebElement editLastCreatedPatient;

    @FindBy(xpath = "//a[contains(text(),'Клинические группы')]")
    private WebElement listOfClinicalGroups;

    @FindBy(id = "ClinicalGroupCode-Autocomplete-Button")
    private WebElement clinicalGroupsButton;

    @FindBy(id = "ModificationDate")
    private WebElement modificationDateField;

    ////////////search new patient
    @FindBy(xpath = "//a[text()='Поиск']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[text()='Поиск по ФИО']")
    private WebElement searchBySurnameButton;

    @FindBy(id = "LastName")
    private WebElement searchBysurnameField;

    @FindBy(xpath = "//button[text()='Поиск']")
    private WebElement startSearchButton;

    @FindBy(css = ".table-patient-data")
    private WebElement tablePatientData;


    public boolean isTableContein(String personalNumber){
        return tablePatientData.getText().contains(personalNumber);
    }

    public void addClinicalGroup(String date) {
        wait.waitForElementIsClickable(listOfClinicalGroups);
        listOfClinicalGroups.click();
        waitForLoaderIndicatorDisapearing();
        ThreadSleep.waitElement(1000);
        wait.waitForElementIsClickable(clinicalGroupsButton);
        ThreadSleep.waitElement(1000);
        clinicalGroupsButton.click();
        selectByText("2-я");
        modificationDateField.sendKeys(date);
        ThreadSleep.waitElement(1000);
        waitForLoaderIndicatorDisapearing();
    }

    public void populateIdentify(Patient patient) {
        cardNumberForm.sendKeys(Random.getRandomNumber(7));
        lastNameForm.sendKeys(patient.getLastName());
        firstNameForm.sendKeys(patient.getFirstName());
        middleNameForm.sendKeys(patient.getPatrName());
        dateOfBirthForm.sendKeys(patient.dateSwap());
        personalNumber.sendKeys(patient.getPersonalNumber());
        sexInputField.sendKeys(patient.getSex().toString());
        currentStateAutocomplete.sendKeys("1");
    }

    public void populatePlaceOfLiving() {
        addressResidencePlaceCodeCatalogueField.sendKeys("1533413000000");
    }

    public void populateAdditionalInfo() {
        wasPreviouslyRegistredInputField.clear();
        wasPreviouslyRegistredInputField.sendKeys("0");

    }

    public void populateGeneralDiagnosForm(Diagnosis diagnosis) {
        char[] mkb10Code = diagnosis.getCodeICD10().toCharArray();
        for (char symbol : mkb10Code) {
            mkb10CodeForm.sendKeys(symbol + "");
            ThreadSleep.waitElement(1000);
        }
        diagnosStartDateForm.sendKeys(diagnosis.getDiagnosisDate());
        ThreadSleep.waitElement(1000);
        pairToSelectButton.click();
        ThreadSleep.waitElement(1000);
        selectByText(diagnosis.getPairingSymptom());
        ThreadSleep.waitElement(1000);
        diagnoseTextField.sendKeys(diagnosis.getDiagnosisText());
        ThreadSleep.waitElement(1000);
        sourceOfInfoToSelectButton.click();
        ThreadSleep.waitElement(1000);
        selectByText(diagnosis.getSourceOfdiagnosisInfo());
        ThreadSleep.waitElement(1000);
        char[] camePlace = diagnosis.getCamePlace().toCharArray();
        for (char symbol : camePlace) {
            camePlaceForm.sendKeys(symbol + "");
            ThreadSleep.waitElement(1000);

        }
    }

    public void populateStages(Diagnosis diagnosis) {
        phaseToSelectButton.click();
        ThreadSleep.waitElement(1000);
        selectByText(diagnosis.getPhase());
        ThreadSleep.waitElement(1000);
        tToSelectButton.click();
        ThreadSleep.waitElement(1000);
        selectByExactlyText(diagnosis.getT(), tToSelectButton);
        ThreadSleep.waitElement(1000);
        nToSelectButton.click();
        ThreadSleep.waitElement(1000);
        selectByExactlyText(diagnosis.getN(), nToSelectButton);
        ThreadSleep.waitElement(1000);
        mToSelectButton.click();
        ThreadSleep.waitElement(1000);
        selectByExactlyText(diagnosis.getM(), mToSelectButton);
        ThreadSleep.waitElement(1000);
        multiplyToSelectButton.click();
        ThreadSleep.waitElement(1000);
        selectByText(diagnosis.getMultiplicity());
    }

    public void populateExamination(Diagnosis diagnosis) {
        examinationConditionToSelectButton.click();
        ThreadSleep.waitElement(1000);
        selectByText(diagnosis.getRevealingTerms());
        ThreadSleep.waitElement(1000);
        confirmationMethodToSelectButton.click();
        ThreadSleep.waitElement(1000);
        selectByText(diagnosis.getConfirmationMethod());
        ThreadSleep.waitElement(1000);
        char[] morphology = diagnosis.getICD10morphology().toCharArray();
        for (char symbol : morphology) {
            morphologyForm.sendKeys(symbol + "");
            ThreadSleep.waitElement(1000);
        }
        ThreadSleep.waitElement(1000);
        researchNumberForm.sendKeys(diagnosis.getMorphologicalStudyRate());
        ThreadSleep.waitElement(1000);
        researhDateForm.sendKeys(diagnosis.getDateOfExamination());
    }

    public void saveData() {

        saveButton.click();

        waitForLoaderIndicatorDisapearing();

    }
}