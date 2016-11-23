package com.epam.tf.pages;

import com.epam.tf.utils.ThreadSleep;
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

    @FindBy(xpath = "//a[@class='collapsToggle collapsed']")
    private WebElement diagnosisUnit;

    @FindBy(xpath = "//a[text() = 'Диагнозы']/../../following-sibling::*//li[1]/div[1]/a/span")
    private WebElement firstDateDiagnosisUnit;

    @FindBy(xpath = "//a[text() = 'Лечения']")
    private WebElement tabOfDiagnosisTreatment;

    public void clickDiagnosisUnit() {
        diagnosisUnit.click();
    }

    public void clickFirstDateOfDiagnosisUnit() {
        wait.waitForElementIsClickable(firstDateDiagnosisUnit);
        firstDateDiagnosisUnit.click();
        waitForLoaderIndicatorDisapearing();
    }

    public DiagnosisTreatmentMainPage goToDiagnosisTreatmentMainPage() {
        wait.waitForElementIsClickable(tabOfDiagnosisTreatment);
        tabOfDiagnosisTreatment.click();
        ThreadSleep.waitElement(4000);
        return new DiagnosisTreatmentMainPage(driver);
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
