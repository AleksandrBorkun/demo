package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PatientCardPage extends AbstractPage {
    public PatientCardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@role='tablist']/li[4]/div[1]/a[1]")
    private WebElement passportPartExpand;

    @FindBy(xpath = "//*[text() = 'Архив отправки вызовов']")
    private WebElement callsArchieveButton;

    @FindBy(xpath = "//a[text() = 'Отметки о диспансеризации']")
    private WebElement marksOnClinicalExamination;

    @FindBy(xpath = "//a[text()='Диагнозы']/../..//span[@class='caret']")
    private WebElement diagnosisUnit;

    @FindBy(xpath = "//a[text() = 'Диагнозы']/../../following-sibling::*//li[1]/div[1]/a/span")
    private WebElement firstDateDiagnosisUnit;

    @FindBy(xpath = "//a[text() = 'Лечения']")
    private WebElement tabOfDiagnosisTreatment;

    @FindBy(xpath = "//a[text() = 'Рецидивы и метастазы']")
    private WebElement tabOfDiagnosisMetastases;

    @FindBy(xpath = "//*[@data-content = 'Редактировать']")
    private WebElement editButton;

    @FindBy(xpath = ".//a[text()='Паспортная часть']")
    private WebElement editPassportData;

    @FindBy(xpath = ".//a[text()='Диагнозы']")
    private WebElement editDiagnosisData;

    @FindBy(xpath = ".//a[text()='Клинические группы']")
    private WebElement editClinicGroup;

    @FindBy(xpath = ".//a[text()='Действия']")
    private WebElement actionButton;

    @FindBy(xpath = ".//a[text() ='Сменить диспансер']")
    private WebElement changeDispensaryButton;

    @FindBy(xpath = "/descendant::span[@class='caret'][4]")
    private WebElement diagnoseMenuButton;

    @FindBy(xpath = "/descendant::span[@class='caret'][5]")
    private WebElement diagnoseListButton;

    @FindBy(xpath = "//a[contains(text(), 'генетические')]")
    private WebElement molecularGeneticDiagnoseButton;

    @FindBy(xpath = "//a[contains(text(), 'ИГХ неспецифические')]")
    private WebElement notSpecificIGHDiagnoseButton;

    @FindBy(xpath = "//a[contains(text(), 'ИГХ специфические')]")
    private WebElement specificIGHDiagnosisButton;


    public void clickMolecularGeneticDiagnoseButton (){
        wait.waitForElementIsClickable(molecularGeneticDiagnoseButton);
        molecularGeneticDiagnoseButton.click();
    }

    public void clickDiagnoseListButton(){
        wait.waitForElementIsClickable(diagnoseListButton);
        diagnoseListButton.click();
    }

    public void clickDiagnoseMenuButton(){
        wait.waitForElementIsClickable(diagnoseMenuButton);
        diagnoseMenuButton.click();
    }

    public void goToNotSpecificIGHDiagnosis(){
        waitForLoaderIndicatorDisapearing();
        notSpecificIGHDiagnoseButton.click();
    }

    public void goToSpecificIGHDiagnosis(){
        waitForLoaderIndicatorDisapearing();
        specificIGHDiagnosisButton.click();
    }

    public void clickChangeDispensaryButton(){
        wait.waitForJQuery(driver);
        actionButton.click();
        wait.waitForJQuery(driver);
        changeDispensaryButton.click();
        wait.waitForJQuery(driver);
    }

    public void clickDiagnosisUnit() {
        diagnosisUnit.click();
    }

    public void clickEditButton() {
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(editButton);
        editButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void clickEditPassportData(){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(editPassportData);
        editPassportData.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void clickEditDiagnosisData(){
        editDiagnosisData.click();
        waitForLoaderIndicatorDisapearing();

    }

    public void clickEditClinicData(){
        editClinicGroup.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void clickFirstDateOfDiagnosisUnit() {
        wait.waitForElementIsClickable(firstDateDiagnosisUnit);
        firstDateDiagnosisUnit.click();
      //  waitForLoaderIndicatorDisapearing();
    }

    public DiagnosisTreatmentMainPage goToDiagnosisTreatmentMainPage() {
        wait.waitForElementIsClickable(tabOfDiagnosisTreatment);
        tabOfDiagnosisTreatment.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForJQuery(driver);
        editButton.click();
        return new DiagnosisTreatmentMainPage(driver);
    }

    public void goToMetastasesMainPage() {
        wait.waitForElementIsClickable(tabOfDiagnosisMetastases);
        tabOfDiagnosisMetastases.click();
    }

    public MarksOnClinicalExaminationPage clickMarksOnClinicalExamination() {
        marksOnClinicalExamination.click();
        return new MarksOnClinicalExaminationPage(driver);
    }

    public void passportPartExpand() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(passportPartExpand));
        passportPartExpand.click();
    }

    public void clickArchieveButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(callsArchieveButton));
        callsArchieveButton.click();
    }


}
