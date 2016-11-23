package com.epam.tf.pages;

import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SurgeryTreatmentOfDiagnosisPage extends DiagnosisTreatmentMainPage {
    public SurgeryTreatmentOfDiagnosisPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "OperationCharacter-Autocomplete-Button")
    private WebElement operationCharacterButton;

    @FindBy(xpath = "//li[text() =' - Симптоматическая']")
    private WebElement operationCharacterVariant;

    @FindBy(id = "NameFromCatalogue")
    private WebElement OperationCatalogueInput;//0999 - Другие диагностические операции
    // 0620 - Эндопротезирование

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-calendar']")
    private WebElement operationDateSelectButton;

    @FindBy(xpath = "//tr[1]//td//a[contains(text(), '1')]")
    private WebElement dateOfOperationVariant;

    @FindBy(xpath = "//button[@class='btn-success']")
    private WebElement saveEditsButton;

    @FindBy(xpath = "//a[text()='Удалить']")
    private WebElement deleteMarkButton;

    @FindBy(xpath = "//button[text()='Удалить']")
    private WebElement confirmDeleteMarkButton;

    @FindBy(xpath = "//*[@id='form1']//button[text()='Поиск']")
    private WebElement OperationDialogSerchkButton;

    @FindBy(xpath = "//button[text()='Подтвердить']")
    private WebElement confirmOperationDialogSerchkButton;

    @FindBy(id = "OperationDialog")
    private WebElement OperationCodeButton;

    @FindBy(id = "third")
    private WebElement searchByNameTab;

    @FindBy(id = "Operation_CatalogueField")
    private WebElement operationCodeInput;

    @FindBy(id = "possible-words-table")
    private WebElement possibleWordsTable;

    public void addSurgeryTreatmentOfDiagnosis(String operationCode) {
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(operationCharacterButton);
        operationCharacterButton.click();
        waitForLoaderIndicatorDisapearing();
        ThreadSleep.waitElement(450);
        operationCharacterVariant.click();
        waitForLoaderIndicatorDisapearing();
        OperationCodeButton.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(searchByNameTab);
        searchByNameTab.click();
        waitForLoaderIndicatorDisapearing();
        OperationCatalogueInput.clear();
        OperationCatalogueInput.sendKeys(operationCode);
        waitForLoaderIndicatorDisapearing();
        OperationDialogSerchkButton.click();
        waitForLoaderIndicatorDisapearing();
        confirmOperationDialogSerchkButton.click();
        waitForLoaderIndicatorDisapearing();
        operationDateSelectButton.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(dateOfOperationVariant);
        dateOfOperationVariant.click();
        waitForLoaderIndicatorDisapearing();
        ThreadSleep.waitElement(4500);
        saveEditsButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void deleteSurgeryTreatmentOfDiagnosis(){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(deleteMarkButton);
       deleteMarkButton.click();
        wait.waitForElementIsClickable(confirmDeleteMarkButton);
        confirmDeleteMarkButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    public boolean isDataCorrect(String operationCode) {
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(operationCodeInput);
         if (operationCodeInput.getAttribute("value").contains(operationCode)
                 && deleteMarkButton.isDisplayed()) {
            return true;
        }
        else return false;
    }

    public boolean isDataDeleted() {
        wait.waitForElementIsClickable(operationCodeInput);
       return (operationCodeInput.getAttribute("value").equals(""));
    }

}
