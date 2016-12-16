package com.epam.tf.pages;

import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dzmitry_Bets on 12/13/2016.
 */

public class MolecularGeneticPage extends AbstractPage {


    @FindBy(xpath = "//a[@data-content='Редактировать']")
    private WebElement editingMolecularGeneticDiagnoseButton;

    @FindBy(xpath = "//button[text()='Сохранить']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[text()='Добавить']")
    private WebElement addNewDiagnoseButton;

    @FindBy(css = ".control-elements .glyphicon-remove")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement confirmDeleteDiagnoseButton;

    @FindBy(id = "AnalysisDate")
    private WebElement dateOfResearchField;

    @FindBy(id = "AnalysisMethod_Autocomplete")
    private WebElement analysisMethodField;

    @FindBy(id = "AnalysisMethod-Autocomplete-Button")
    private WebElement analysisMethodButton;

    @FindBy(id = "Gene_Autocomplete")
    private WebElement genSampleField;

    @FindBy(id = "Gene-Autocomplete-Button")
    private WebElement genSampleButton;

    @FindBy(id = "GeneticChanges_Autocomplete")
    private WebElement geneticChangesField;

    @FindBy(id = "GeneticChanges-Autocomplete-Button")
    private WebElement geneticsChangesButton;

    @FindBy(id = "ResultOfMolecularGeneticAnalysis_Autocomplete")
    private WebElement resultField;

    @FindBy(id = "ResultOfMolecularGeneticAnalysis-Autocomplete-Button")
    private WebElement resultOfMolecularGeneticAnalysisButton;


    public MolecularGeneticPage(WebDriver driver) {
        super(driver);
    }

    public void fillResultOfMolecularGeneticField(){
        wait.waitForElementIsClickable(resultOfMolecularGeneticAnalysisButton);
        ThreadSleep.waitElement(1000);
        resultOfMolecularGeneticAnalysisButton.click();
        ThreadSleep.waitElement(1000);
        selectByText("Не выявлена");
    }

    public void fillGenChangesField(){
        wait.waitForElementIsClickable(geneticsChangesButton);
        ThreadSleep.waitElement(1000);
        geneticsChangesButton.click();
        ThreadSleep.waitElement(1000);
        selectByText("Мутация");
    }

    public void fillGenSampleField(){
        ThreadSleep.waitElement(1000);
        wait.waitForElementIsClickable(genSampleButton);
        ThreadSleep.waitElement(1000);
        genSampleButton.click();
        selectByText("APC");
    }

    public void fillAnalysisMethodField(){
        wait.waitForElementIsClickable(analysisMethodButton);
        analysisMethodButton.click();
        selectByText("FISH");
    }

    public void fillDateOfMolecularGeneticDiagnoseField (String date){
        wait.waitForElementIsClickable(dateOfResearchField);
        dateOfResearchField.sendKeys(date);
    }

    public String getDateOfNewResearch(){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(dateOfResearchField);
        String result=dateOfResearchField.getText();
        return result;
    }

    public void editMolecularGeneticDiagnose(){
        wait.waitForElementIsClickable(editingMolecularGeneticDiagnoseButton);
        editingMolecularGeneticDiagnoseButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void clickSaveButton(){
        wait.waitForElementIsClickable(saveButton);
        saveButton.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(addNewDiagnoseButton);
    }

    public void clearFields(){
        dateOfResearchField.clear();
        analysisMethodField.clear();
        genSampleField.clear();
        geneticChangesField.clear();
        resultField.clear();
    }

    public void clickDeleteButton(){
        wait.waitForElementIsClickable(deleteButton);
        deleteButton.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(confirmDeleteDiagnoseButton);
        confirmDeleteDiagnoseButton.click();
        waitForLoaderIndicatorDisapearing();
    }

}
