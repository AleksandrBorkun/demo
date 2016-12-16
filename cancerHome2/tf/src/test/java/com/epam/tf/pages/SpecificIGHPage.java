package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

/**
 * Created by Dzmitry_Bets on 12/13/2016.
 */
public class SpecificIGHPage extends AbstractPage {


    @FindBy(xpath = "//a[@data-content='Редактировать']")
    private WebElement editingIGHDiagnoseButton;

    @FindBy(xpath = "//button[text()='Сохранить']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[text()='Добавить']")
    private WebElement addNewDiagnoseButton;

    @FindBy(id = "AnalysisDate")
    private WebElement dateOfResearchField;

    @FindBy(id = "Er")
    private WebElement ErField;

    @FindBy(id = "ErLessThanOne")
    private WebElement ErLessOneCheckBox;

    @FindBy(id = "Er_bal_Autocomplete")
    private WebElement ErIntensityScoreInputField;

    @FindBy(id = "Er_bal-Autocomplete-Button")
    private WebElement ErIntensityScoreButton;

    @FindBy(id = "Pr")
    private WebElement PrField;

    @FindBy(id = "PrLessThanOne")
    private WebElement PrLessOneCheckBox;

    @FindBy(id = "Pr_Bal_Autocomplete")
    private WebElement PrIntensityScoreInputField;

    @FindBy(id = "Pr_Bal-Autocomplete-Button")
    private WebElement PrIntensityScoreButton;

    @FindBy(id = "Her2_Autocomplete")
    private WebElement Her2InputField;

    @FindBy(id = "Her2-Autocomplete-Button")
    private WebElement Her2Button;

    @FindBy(id = "Ki")
    private WebElement Ki67InputField;

    @FindBy(id = "KiLessThanOne")
    private WebElement Ki67CheckBox;

    public SpecificIGHPage(WebDriver driver) {
        super(driver);
    }

    public void fillDateOfDiagnoseField(String date){
        wait.waitForElementIsClickable(dateOfResearchField);
        dateOfResearchField.sendKeys(date);
    }

    public void fillErField(){
        ErField.sendKeys("2");
    }

    public void doMarkErCheckbox(){
        ErLessOneCheckBox.click();
    }

    public void fillErIntensity(){
        ErIntensityScoreInputField.sendKeys(String.valueOf(new Random().nextInt(4)));
    }

    public void fillPrField(){
        PrField.sendKeys("2");
    }

    public void doMarkPrCheckbox(){
        PrLessOneCheckBox.click();
    }

    public void fillPrIntensity(){
        PrIntensityScoreInputField.sendKeys(String.valueOf(new Random().nextInt(4)));
    }

    public void fillHer2(){
        Her2InputField.sendKeys(String.valueOf(new Random().nextInt(4)));
    }

    public void fillKi67(){
        Ki67InputField.sendKeys("2");
    }

    public void doMarkKiCheckbox(){
        Ki67CheckBox.click();
    }

    @FindBy(xpath = "//a[@data-content='Редактировать']/preceding::a[1]")
    private WebElement deleteIGHDiagnoseButton;

    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement confirmDeleteIGHDiagnoseButton;

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

    public void deleteSpecificDiagnose(){
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(deleteIGHDiagnoseButton);
        deleteIGHDiagnoseButton.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(confirmDeleteIGHDiagnoseButton);
        confirmDeleteIGHDiagnoseButton.click();
        waitForLoaderIndicatorDisapearing();
    }



}
