package com.epam.tf.pages;

import com.epam.tf.entity.Patient;
import com.epam.tf.entity.TestCase;
import com.epam.tf.utils.Random;
import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class NewPatientPage extends AbstractPage {

    public NewPatientPage(WebDriver driver) {
        super(driver);
    }

    //ИДЕНТИФИКАЦИЯ
    //IDENTIFICATION PART

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

    //МЕСТО ЖИТЕЛЬСТВА
    //PLACE OF LIVING PART

    @FindBy(xpath = ".//button[@id='ResidencePlaceCodeDialog']")
    private WebElement codeTersonButton;

    @FindBy(xpath = ".//a[@id='second']")
    private WebElement tersonSearchViaCatalogButton;

    @FindBy(xpath = ".//button[@id='Country-Autocomplete-Button']")
    private WebElement tersonCountryButton;

    @FindBys(@FindBy(xpath = ".//div[@id='Country-Autocomplete-Root']//li"))
    private List<WebElement> tersonListOfCountries;

    @FindBy(xpath = ".//button[@id='Region-Autocomplete-Button']")
    private WebElement tersonRegionButton;

    @FindBys(@FindBy(xpath = ".//div[@id='Region-Autocomplete-Root']//li"))
    private List<WebElement> tersonListOfRegions;

    @FindBy(xpath = ".//button[@id='District-Autocomplete-Button']")
    private WebElement tersonDistrictButton;

    @FindBys(@FindBy(xpath = ".//div[@id='District-Autocomplete-Root']//li"))
    private List<WebElement> tersonListOfDistricts;

    @FindBy(xpath = ".//button[@id='SubDistrict-Autocomplete-Button']")
    private WebElement tersonSubDistrictButton;

    @FindBys(@FindBy(xpath = ".//div[@id='SubDistrict-Autocomplete-Root']//li"))
    private List<WebElement> tersonListOfSubdistricts;

    @FindBy(xpath = ".//button[@id='Place-Autocomplete-Button']")
    private WebElement tersonPlaceButton;

    @FindBys(@FindBy(xpath = ".//div[@id='Place-Autocomplete-Root']//li"))
    private List<WebElement> tersonListOfPlaces;

    @FindBy(xpath = ".//input[@id='Address_ResidencePlaceCode_CatalogueName']")
    private WebElement resultCodeTersonInput;

    //ДРУГИЕ СВЕДЕНИЯ
    //OTHER INFORMATION

    @FindBy(id = "RegistrationDate")
    private WebElement registrationDate;

    @FindBy(id = "Ambulance_Autocomplete")
    private WebElement ambulanceAutocomplete;

    @FindBy(id = "WasPreviouslyRegistered_Autocomplete")
    private WebElement wasPreviouslyRegistredInputField;

    @FindBy(id = "WasPreviouslyRegistered-Autocomplete-Button")
    private WebElement buttonWasPreviouslyRegisteredAutocomplete;


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

    @FindBy(id = "Stage_Autocomplete")
    private WebElement stageInputField;

    @FindBy(id = "Stage-Autocomplete-Button")
    private WebElement phaseToSelectButton;

    @FindBy(id = "T_Autocomplete")
    private WebElement tInputField;

    @FindBy(id = "T-Autocomplete-Button")
    private WebElement tToSelectButton;

    @FindBy(id = "N_Autocomplete")
    private WebElement nInputField;

    @FindBy(id = "N-Autocomplete-Button")
    private WebElement nToSelectButton;

    @FindBy(id = "M_Autocomplete")
    private WebElement mInputField;

    @FindBy(id = "M-Autocomplete-Button")
    private WebElement mToSelectButton;

    @FindBy(id = "Multiply_Autocomplete")
    private WebElement multiplyInputField;

    @FindBy(id = "Multiply-Autocomplete-Button")
    private WebElement multiplyToSelectButton;

    @FindBy(id = "Condition-Autocomplete-Button")
    private WebElement examinationConditionToSelectButton;

    @FindBy(id = "Condition_Autocomplete")
    private WebElement examinationConditionInputField;

    @FindBy(id = "ConfirmMethod-Autocomplete-Button")
    private WebElement confirmationMethodToSelectButton;

    @FindBy(id = "ConfirmMethod_Autocomplete")
    private WebElement confirmationInputField;

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

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement saveButton;

//    private String place = tersonListOfPlaces.get(1).toString();

    public boolean isTableContein(String personalNumber) {
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

    public void fillIdentify(Patient patient) {
        cardNumberForm.sendKeys(Random.getRandomNumber(7));
        lastNameForm.sendKeys(patient.getLastName());
        firstNameForm.sendKeys(patient.getFirstName());
        middleNameForm.sendKeys(patient.getPatrName());
        dateOfBirthForm.sendKeys(patient.dateSwap());
        personalNumber.sendKeys(patient.getPersonalNumber());
        sexInputField.sendKeys(patient.getSex().toString());
        currentStateAutocomplete.sendKeys("1");
    }

    public void fillPlaceOfLivingPart() {
        actions.moveToElement(codeTersonButton).click();
        wait.magicWaiter();
        tersonSearchViaCatalogButton.click();
        wait.magicWaiter();
        tersonCountryButton.click();
        wait.magicWaiter();
        tersonListOfCountries.get(0).click();
        wait.magicWaiter();
        tersonRegionButton.click();
        wait.magicWaiter();
        tersonListOfRegions.get(1).click();
        wait.magicWaiter();
        tersonDistrictButton.click();
        wait.magicWaiter();
        tersonListOfDistricts.get(0).click();
        wait.magicWaiter();
        tersonSubDistrictButton.click();
        wait.magicWaiter();
        tersonListOfSubdistricts.get(1).click();
        wait.magicWaiter();
        tersonPlaceButton.click();
        wait.magicWaiter();
        tersonListOfPlaces.get(1).click();
        wait.magicWaiter();
        clickConfirmButton();
        waitForLoaderIndicatorDisapearing();
    }


    public void fillAdditionalInfo() {
        wasPreviouslyRegistredInputField.clear();
        wasPreviouslyRegistredInputField.sendKeys("0");

    }

    public void fillGeneralDiagnosForm(TestCase testCase) throws InterruptedException {
        mkb10CodeForm.clear();
        mkb10CodeForm.sendKeys(testCase.getMkb10());
        Thread.sleep(5000);
        waitForLoaderIndicatorDisapearing();
        diagnosStartDateForm.sendKeys(testCase.getDateDiag());
        waitForLoaderIndicatorDisapearing();
        pairToSelectButton.sendKeys(testCase.getSignP());
        waitForLoaderIndicatorDisapearing();
    }

    public void fillStages(TestCase testCase) {
        stageInputField.sendKeys(testCase.getStage());
        wait.magicWaiter();
        tInputField.sendKeys(testCase.getT());
        wait.magicWaiter();
        nInputField.sendKeys(testCase.getN());
        wait.magicWaiter();
        mInputField.sendKeys(testCase.getM());
        wait.magicWaiter();
        multiplyInputField.sendKeys(testCase.getPlurality());
        wait.magicWaiter();
    }

    public void fillExamination(TestCase testCase) {
        examinationConditionInputField.sendKeys(testCase.getDetectionRules());
        wait.magicWaiter();
        confirmationInputField.sendKeys(testCase.getAcceptMethod());
        wait.magicWaiter();
        morphologyForm.sendKeys(testCase.getMorphology());
        wait.magicWaiter();

    }

    public void saveData() {
        saveButton.click();
        waitForLoaderIndicatorDisapearing();
    }

//    public Boolean confirmChangingPlaceOfLivingData() {
//        Assert.assertTrue(resultCodeTersonInput.getText().contains(place));
//        return true;
//    }
}