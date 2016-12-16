package com.epam.tf.pages;

import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dzmitry_Bets on 12/13/2016.
 */
public class NotASpecificIGHPage extends AbstractPage {

    @FindBy(id = "AnalysisDate")
    private WebElement dateOfResearchField;

    @FindBy(xpath = "//a[@data-content='Редактировать']")
    private WebElement editingIGHDiagnoseButton;

    @FindBy(xpath = "//button[text()='Сохранить']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[text()='Добавить']")
    private WebElement addNewDiagnoseButton;

    @FindBy(id = "AntibodiesName-Autocomplete-Button")
    private WebElement antibodyNameButton;

    @FindBy(id = "Result-Autocomplete-Button")
    private WebElement resultButton;

    @FindBy(xpath = "//a[@data-content='Редактировать']/preceding::a[1]")
    private WebElement deleteIGHDiagnoseButton;

    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement confirmDeleteIGHDiagnoseButton;

    @FindBy(xpath = "//label[contains(text(),'Исследования за')]")
    private WebElement resultOfEditingIGHDiagnoseField;


    public String getDateOfSpecificDiagnose (){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(resultOfEditingIGHDiagnoseField);
        String result=resultOfEditingIGHDiagnoseField.getText();
        return result;
    }


    public void deleteSpecificDiagnose(){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(deleteIGHDiagnoseButton);
        deleteIGHDiagnoseButton.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(confirmDeleteIGHDiagnoseButton);
        confirmDeleteIGHDiagnoseButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void fillResultField(){
        wait.waitForElementIsClickable(resultButton);
        ThreadSleep.waitElement(1000);
        resultButton.click();
        ThreadSleep.waitElement(1000);
        selectByText("определен");
    }

    public void fillAntibodyNameField(){
        wait.waitForElementIsClickable(antibodyNameButton);
        antibodyNameButton.click();
        selectByText("Actin");
    }

    public NotASpecificIGHPage(WebDriver driver) {
        super(driver);
    }

    public void fillDateOfDiagnoseField(String date){
        wait.waitForElementIsClickable(dateOfResearchField);
        dateOfResearchField.sendKeys(date);
    }

    public String getDateOfNewResearch(){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(dateOfResearchField);
        String result=dateOfResearchField.getText();
        return result;
    }

    public void editSpecificDiagnose(){
        wait.waitForElementIsClickable(editingIGHDiagnoseButton);
        editingIGHDiagnoseButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void clickSaveDiagnoseButton(){
        wait.waitForElementIsClickable(saveButton);
        saveButton.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(addNewDiagnoseButton);
    }
}
