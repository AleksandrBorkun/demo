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

    @FindBy(xpath = ".//a[text()='Действия']")
    private WebElement actionButton;

    @FindBy(xpath = ".//a[text() ='Сменить диспансер']")
    private WebElement changeDispensaryButton;

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
        editButton.click();
    }

    public void clickEditPassportData(){
        editPassportData.click();
    }

    public void clickFirstDateOfDiagnosisUnit() {
        wait.waitForElementIsClickable(firstDateDiagnosisUnit);
        firstDateDiagnosisUnit.click();
      //  waitForLoaderIndicatorDisapearing();
    }

    public DiagnosisTreatmentMainPage goToDiagnosisTreatmentMainPage() {
        wait.waitForElementIsClickable(tabOfDiagnosisTreatment);
        tabOfDiagnosisTreatment.click();
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
