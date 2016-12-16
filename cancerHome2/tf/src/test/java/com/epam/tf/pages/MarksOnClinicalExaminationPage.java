package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MarksOnClinicalExaminationPage extends AbstractPage {
    public MarksOnClinicalExaminationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text() = 'Добавить']")
    private WebElement addNewMarkButton;

    @FindBy(xpath = "//tr[1]//a[@data-content='Редактировать']")
    private WebElement editFirstMarkButton;

    @FindBy(xpath = "//tr[1]//a[@data-content='Удалить']")
    private WebElement deleteFirstMarkButton;

    @FindBy(css = ".modal-footer .btn-success")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-calendar']")
    private WebElement lastContactDateSelectButton;

    @FindBy(id = "ClinicalGroupCode_Autocomplete")
    private WebElement clinicGroupInputField;

    @FindBy(xpath = "//a[@class='ui-state-default ui-state-highlight']")
    private WebElement ContactDateOfCurrentDate;

    @FindBy(id = "ControlPeriod")
    private WebElement periodOfControlInput;

    @FindBy(id = "ModificationDate")
    private WebElement modificationDateInputField;

    @FindBy(id = "ContactMark-Autocomplete-Button")
    private WebElement contactMarkSelectButton;

    @FindBy(xpath = "//li[@class='ui-menu-item'][last()]")
    private WebElement newContactMarkVariant;

    @FindBy(xpath = "//li[text() =' - Явился в диспансер для контрольного осмотра']")
    private WebElement contactMarkVariant;

    @FindBy(xpath = "//li[text() =' - Осмотр в ОЗ по м/ж выездной бригадой']")
    private WebElement typeOfFormControl;

    @FindBy(xpath = "//li[text() =' - Осмотр в РНПЦ ОМР']")
    private WebElement newTypeOfFormControl;

    @FindBy(xpath = "//*[@id='form0']/div[4]/div/button[1]")
    private WebElement saveButton;

    @FindAll(@FindBy(xpath = "//*[@class='table table-striped table-bordered table-hover clickable-table']//tr"))
    private List<WebElement> marks;

    @FindAll(@FindBy(xpath = "//*[@id='partial']//tbody/tr[1]/td"))
    private List<WebElement> firstMarkDataList;

    public ArrayList<String> getFirstMarkData() {
        waitForLoaderIndicatorDisapearing();
        ArrayList<String> dataList = new ArrayList<>();
        for (WebElement element : firstMarkDataList) {
            System.out.println(element.getText());
            dataList.add(element.getText());
        }
        return dataList;
    }

    public int getCurrentMarksCount() {
        waitForLoaderIndicatorDisapearing();
        return marks.size();
    }

    public void editClinicalExaminationMark(String period) {
        editFirstMarkButton.click();
        periodOfControlInput.clear();
        periodOfControlInput.sendKeys(period);
        contactMarkSelectButton.click();
        newContactMarkVariant.click();
        clickButtonById("TypeOfControl-Autocomplete-Button");
        newTypeOfFormControl.click();
        saveButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void editClinicGroup(){
        editFirstMarkButton.click();
        clinicGroupInputField.clear();
        clinicGroupInputField.sendKeys(String.valueOf(new Random().nextInt(3)+2));
        waitForLoaderIndicatorDisapearing();
        modificationDateInputField.clear();
        modificationDateInputField.sendKeys("11112015");
        waitForLoaderIndicatorDisapearing();
        saveButton.click();

    }

    public void addNewClinicalExaminationMarkWithCurrentDate() {
        addNewMarkButton.click();
        lastContactDateSelectButton.click();
        waitForLoaderIndicatorDisapearing();
        wait.waitForElementIsClickable(ContactDateOfCurrentDate);
        ContactDateOfCurrentDate.click();
        periodOfControlInput.clear();
        periodOfControlInput.sendKeys("1");
        contactMarkSelectButton.click();
        contactMarkVariant.click();
        clickButtonById("TypeOfControl-Autocomplete-Button");
        typeOfFormControl.click();
        saveButton.click();
        waitForLoaderIndicatorDisapearing();
    }

    public void deleteClinicalExaminationMarkWithCurrentDate() {
        deleteFirstMarkButton.click();
        confirmDeleteButton.click();
        waitForLoaderIndicatorDisapearing();
    }
}
