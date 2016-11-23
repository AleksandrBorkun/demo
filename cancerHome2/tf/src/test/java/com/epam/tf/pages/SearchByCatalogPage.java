package com.epam.tf.pages;

import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SearchByCatalogPage extends AbstractPage {

    public SearchByCatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@role='fragment']//span")
    private WebElement fragmentPopUp;

    @FindBy(xpath = "//div[@role='attr-fragment']//span")
    private WebElement fragmentAttributePopUp;

    @FindBy(xpath = "//div[@role='requisite']//button")
    private WebElement requisitePopUp;

    @FindBy(xpath = "//div[@role='attr-requisite']//span/button")
    private WebElement requisiteAttributePopUp;

    @FindBy(xpath = "//div[@role='val-requisite']//button")
    private WebElement requisiteValueButton;

    @FindBy(xpath = "//a[text() = 'Поиск по каталогу']")
    private WebElement searchByCatalogPart;

    @FindBy(xpath = "//label[text() = 'Подкласс']//..//span")
    private WebElement subClass;

    @FindBy(xpath = "//label[text() = 'Рубрика']//..//span")
    private WebElement headingButton;

    @FindBy(xpath = "//label[text() = 'Подрубрика']//..//span")
    private WebElement subHeadingButton;

    @FindBy(xpath = "//button[text() = 'Подтвердить']")
    private WebElement submitRequestButton;

    @FindBy(xpath = "//button[contains(text(), 'Поиск')]")
    private WebElement clickSearchFilledRequest;

    @FindBy(xpath = ".//*[@id='District-Autocomplete-Button']")//For Test 63
    private WebElement choseDistrictButton;

    @FindBy(xpath = ".//*[@id='Okpo-Autocomplete-Button']")//For Test 63
    private WebElement choseOKPOButton;

    @FindBy(css = "button.btn.btn-primary[dialogtitle='Новый список']")
    private WebElement buttonSaveInList;

    @FindBy(id = "SearchItems[0]_Fragment-Autocomplete-Button")
    private WebElement fragmentButton;

    @FindBy(xpath = ".//li[text()= 'Диагноз' ]")
    private WebElement selectDiagnosFragmnent;

    @FindBy(id = "SearchItems[0]_FragmentAttribute-Autocomplete-Button")
    private WebElement fragmentAttributeButton;

    @FindBy(xpath = ".//li[text()= 'Все записи' ]")
    private WebElement fragmentAttributeAllRecordingValue;

    @FindBy(id = "SearchItems[0]_Requisite-Autocomplete-Button")
    private WebElement requisiteButton;

    @FindBy(xpath = ".//li[text()= 'Дата установления диагноза' ]")
    private WebElement requisiteDateOfInstalValue;

    @FindBy(id = "SearchItems[0]_Values[0]_RequisiteAttribute-Autocomplete-Button")
    private WebElement requsiteAttributeButton;

    @FindBy(xpath = ".//li[text()= 'меньше' ]")
    private WebElement requsiteAttributeLowerThanValue;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "SearchItems[0]_Values[0]_Value")
    private WebElement dateField;

    @FindBy(xpath = "//tr[@class='patientItem']")
    private List<WebElement> resultList;


    public void clickElementByName(String element){
        driver.findElement(By.xpath("//li[text() = '" + element + "']")).click();
        ThreadSleep.waitElement(350);
    }

    public void openFragmentField() {
        fragmentPopUp.click();
    }

    public void openFragmentAttributeField() {
        fragmentAttributePopUp.click();
        ThreadSleep.waitElement(350);
    }

    public void openRequisiteField() {
        requisitePopUp.click();
        ThreadSleep.waitElement(350);
    }

    public void openRequisiteAttributeField() {
        requisiteAttributePopUp.click();
        ThreadSleep.waitElement(350);
    }

    public void openRequisiteValue() {
        requisiteValueButton.click();
        ThreadSleep.waitElement(1500);
    }

    public void searchByCatalogPart() {
        searchByCatalogPart.click();
        ThreadSleep.waitElement(350);
    }

    public void openSubClass() {
        subClass.click();
        ThreadSleep.waitElement(350);
    }

    public void openHeading() {
        headingButton.click();
        ThreadSleep.waitElement(350);
    }

    public void openSubHeading() {
        subHeadingButton.click();
        ThreadSleep.waitElement(350);
    }

    public void submitRequest() {
        submitRequestButton.click();
        ThreadSleep.waitElement(350);
    }

    public void clickSearchFilledRequest() {
        clickSearchFilledRequest.click();
    }

    public boolean checkResultOfInsertion() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver.findElements(By.xpath("//li[contains(text(), 'Условия поиска не заданы')]")).size() != 0;
    }

    public void choseDistrict(){
        choseDistrictButton.click();
        ThreadSleep.waitElement(350);
    }

    public void choseOKPO() {
        choseOKPOButton.click();
        ThreadSleep.waitElement(350);
    }

    public void fillFragmentField() {
        wait.waitForElementIsClickable(fragmentButton);
        fragmentButton.click();
        wait.waitForElementIsClickable(selectDiagnosFragmnent);
        selectDiagnosFragmnent.click();

    }

    public void fillFragmentAttributeField() {
        wait.waitForElementIsClickable(fragmentAttributeButton);
        fragmentAttributeButton.click();
        wait.waitForElementIsClickable(fragmentAttributeAllRecordingValue);
        fragmentAttributeAllRecordingValue.click();
    }

    public void fillRequisiteField() {
        wait.waitForElementIsClickable(requisiteButton);
        requisiteButton.click();
        requisiteButton.click();
        requisiteButton.click();
        wait.waitForElementIsClickable(requisiteDateOfInstalValue);
        requisiteDateOfInstalValue.click();
    }

    public void fillRequisiteAttributeField() {
        wait.waitForElementIsClickable(requsiteAttributeButton);
        requsiteAttributeButton.click();
        requsiteAttributeButton.click();
        requsiteAttributeButton.click();
        wait.waitForElementIsClickable(requsiteAttributeLowerThanValue);
        requsiteAttributeLowerThanValue.click();
    }

    public void setDateField(String date) {
        dateField.click();
        dateField.clear();
        dateField.sendKeys(date);
    }

    public void clickSumbit() {
        submitButton.click();
    }

    public List<WebElement> getResultList() {
        return resultList;
    }

    public void saveResultInList(){
        buttonSaveInList.click();
    }
}
