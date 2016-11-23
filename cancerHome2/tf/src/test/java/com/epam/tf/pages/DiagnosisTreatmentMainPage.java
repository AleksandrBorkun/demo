package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class DiagnosisTreatmentMainPage extends AbstractPage {
    public DiagnosisTreatmentMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text() = 'Добавить']")
    private WebElement addNewTreatmentButton;

    @FindBy(xpath = "//tr[1]//a[@data-content='Удалить']")
    private WebElement deleteFirstTreatmentMarkButton;

    @FindBy(xpath = "//*[@class='btn btn-success']")
    private WebElement confirmDeleteFirstTreatmentMarkButton;

    @FindBy(xpath = "//li[text() = ' - Нет сведений']")
    private WebElement newInformationTreatmentVariant;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-calendar']")
    private WebElement dateOfStartTreatmentSelectButton;

    @FindBy(xpath = "//tr[1]//td//a[contains(text(), '1')]")
    private WebElement dateOfStartTreatmentVariant;

    @FindBy(id = "InformationTreatment-Autocomplete-Button")
    private WebElement informationTreatmentButton;

    @FindBy(xpath = "//li[text() =' - Лечился амбулаторно']")
    private WebElement informationTreatmenVariant;

    @FindBy(xpath = "//li[text() =' - Обследование']")
    private WebElement characterTreatmenVariant;

    @FindBy(xpath = "//li[text() =' - Не проводилось']")
    private WebElement newCharacterTreatmenVariant;

    @FindBy(xpath = "//*[@id='TypeSpecialTreatment-Autocomplete-Root']//li[text() =' - Не проводилось']")
    private WebElement typeSpecialTreatmentVariant;

    @FindBy(xpath = "//li[text() =' - РНПЦ ОМР']")
    private WebElement ozTypeVariant;

    @FindBy(xpath = "//li[text() =' - Не лечился']")
    private WebElement newOzTypeVariant;

    @FindBy(xpath = "//button[text()='Сохранить']")
    private WebElement saveEditsButton;

    @FindBy(xpath = "//tr[1]//a[@data-content='Редактировать']")
    private WebElement editFirstTreatmentButton;

    @FindBy(xpath = "//a[text() = 'Лечения']")
    private WebElement tabOfDiagnosisTreatment;

    @FindAll(@FindBy(xpath = "//*[@id='partial']//tbody/tr"))
    private List<WebElement> marks;

    @FindAll(@FindBy(xpath = "//*[@id='partial']//*/tr[1]/td"))
    private List<WebElement> firstMarkDataList;

    @FindBy(xpath = "//a[text()='Хирургическое']")
    private WebElement SurgeryTreatmenButton;

    public void addCommonDiagnosisTreatmentData() {
        waitForLoaderIndicatorDisapearing();
        tabOfDiagnosisTreatment.click();
        waitForLoaderIndicatorDisapearing();
        addNewTreatmentButton.click();
        waitForLoaderIndicatorDisapearing();
        dateOfStartTreatmentSelectButton.click();
        waitForLoaderIndicatorDisapearing();
        dateOfStartTreatmentVariant.click();
        waitForLoaderIndicatorDisapearing();
        informationTreatmentButton.click();
        waitForLoaderIndicatorDisapearing();
        informationTreatmenVariant.click();
        clickButtonById("CharacterTreatment-Autocomplete-Button");
        waitForLoaderIndicatorDisapearing();
        characterTreatmenVariant.click();
        clickButtonById("TypeSpecialTreatment-Autocomplete-Button");
        wait.waitForElementIsClickable(typeSpecialTreatmentVariant);
        typeSpecialTreatmentVariant.click();
        clickButtonById("OzType-Autocomplete-Button");
        wait.waitForElementIsClickable(ozTypeVariant);
        ozTypeVariant.click();
        waitForLoaderIndicatorDisapearing();
        saveEditsButton.click();
        waitForLoaderIndicatorDisapearing();
        tabOfDiagnosisTreatment.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void editFirstCommonDiagnosisTreatmentData() {
        editFirstTreatmentButton.click();
        waitForLoaderIndicatorDisapearing();
        informationTreatmentButton.click();
        waitForLoaderIndicatorDisapearing();
        newInformationTreatmentVariant.click();
        waitForLoaderIndicatorDisapearing();
        clickButtonById("CharacterTreatment-Autocomplete-Button");
        waitForLoaderIndicatorDisapearing();
        newCharacterTreatmenVariant.click();
        waitForLoaderIndicatorDisapearing();
        clickButtonById("TypeSpecialTreatment-Autocomplete-Button");
        wait.waitForElementIsClickable(typeSpecialTreatmentVariant);
        typeSpecialTreatmentVariant.click();
        clickButtonById("OzType-Autocomplete-Button");
        waitForLoaderIndicatorDisapearing();
        newOzTypeVariant.click();
        waitForLoaderIndicatorDisapearing();
        saveEditsButton.click();
        waitForLoaderIndicatorDisapearing();
        tabOfDiagnosisTreatment.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void deleteFirstCommonDiagnosisTreatmentDataMark() {
        tabOfDiagnosisTreatment.click();
        waitForLoaderIndicatorDisapearing();
        deleteFirstTreatmentMarkButton.click();
        waitForLoaderIndicatorDisapearing();
        confirmDeleteFirstTreatmentMarkButton.click();
        waitForLoaderIndicatorDisapearing();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public ArrayList<String> getDataOfFirstCommonDiagnosisTreatmentsMark() {
        waitForLoaderIndicatorDisapearing();
        ArrayList<String> dataList = new ArrayList<>();
        for (WebElement element : firstMarkDataList) {
            System.out.println(element.getText());
            dataList.add(element.getText());
        }
        return dataList;
    }

    public int getCurrentCommonDiagnosisTreatmentMarksCount() {
        System.out.println(marks.size());
        return marks.size();
    }

    public void goToSurgeryTreatmentOfFirstCommonTreatmentMark() {
        tabOfDiagnosisTreatment.click();
        waitForLoaderIndicatorDisapearing();
        editFirstTreatmentButton.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(SurgeryTreatmenButton);
        SurgeryTreatmenButton.click();
        waitForLoaderIndicatorDisapearing();
    }

}


