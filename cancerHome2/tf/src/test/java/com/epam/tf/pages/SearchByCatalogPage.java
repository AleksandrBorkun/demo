package com.epam.tf.pages;

import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

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
    
    @FindBy(xpath = "//li[text() = 'Дата рождения']")
    private WebElement requisiteBirthDateValue;

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
    
    @FindBy(xpath = "//li[text() = 'Паспортная часть']")
    private WebElement fragmentPassportPartValue;

    @FindBy(xpath = ".//li[text()= 'Диагноз' ]")
    private WebElement selectDiagnosFragmnent;

    @FindBy(id = "SearchItems[0]_FragmentAttribute-Autocomplete-Button")
    private WebElement fragmentAttributeButton;
    
    @FindBy(id = "SearchItems[0]_Fragment.Autocomplete")
    private WebElement fragmentField;
    
    @FindBy(id = "SearchItems[0]_FragmentAttribute.Autocomplete")
    private WebElement fragmentAttributeField;
   
    @FindBy(id = "SearchItems[0]_Requisite.Autocomplete")
    private WebElement requisiteField;
    
    @FindBy(id = "SearchItems[0]_Values[0]_RequisiteAttribute.Autocomplete")
    private WebElement requisiteAttributeField;

    @FindBy(xpath = "//li[text()= 'Все записи' ]")
    private WebElement fragmentAttributeAllRecordingValue;
    
    @FindBy(xpath = "//li[text()= 'Есть информация' ]")
    private WebElement fragmentAttributeHasInformationValue;

    @FindBy(id = "SearchItems[0]_Requisite-Autocomplete-Button")
    private WebElement requisiteButton;

    @FindBy(xpath = ".//li[text()= 'Дата установления диагноза' ]")
    private WebElement requisiteDateOfInstalValue;
    
    @FindBy(xpath = "//li[text() = 'Дата операции']")
    private WebElement requisiteOperationDateValue;
    
    @FindBy(xpath = "//li[text() = 'Дата выявления рецидива']")
    private WebElement requisiteFindRecidiveDateValue;
    
    @FindBy(id = "SearchItems[0]_Values[0]_RequisiteAttribute-Autocomplete-Button")
    private WebElement requisiteAttributeButton;

    @FindBy(xpath = ".//li[text()= 'меньше' ]")
    private WebElement requsiteAttributeLowerThanValue;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "SearchItems[0]_Values[0]_Value")
    private WebElement dateField;
    
    @FindBy(xpath  = "//a[@class = 'glyphicon glyphicon-plus-sign']")
    private WebElement addButton;
    
    @FindBy(id = "SearchItems[0]_Values[1]_Operand-Autocomplete-Button")
    private WebElement newTaskButton;
    
    @FindBy(xpath = "//li[text() = 'ИЛИ']")
    private WebElement newTaskButtonOrValue;
    
    @FindBy(xpath = "//li[text() = 'И']")
    private WebElement newTaskButtonANDValue;
   
    @FindBy(id = "SearchItems[0]_Values[1]_RequisiteAttribute-Autocomplete-Button")
    private WebElement addRequisiteAttributeButton;
    
    @FindBy(id = "SearchItems[0]_Values[1]_Value")
    private WebElement addDateField;
    
    @FindBy(id ="addCondition")
    private WebElement addConditionButton;
    
    @FindBy(id = "SearchItems[1]_Fragment.Autocomplete")
    private WebElement addFragmentField;
    
    @FindBy(id = "SearchItems[1]_FragmentAttribute.Autocomplete")
    private WebElement addFragmentAttributeField;
    
    @FindBy(id = "SearchItems[1]_Requisite.Autocomplete")
    private WebElement addRequisiteField;
    
    @FindBy(id = "SearchItems[1]_Values[0]_RequisiteAttribute.Autocomplete")
    private WebElement addRequisiteAttributeField;
    
    @FindBys(@FindBy(xpath = "//tr[@class='patientItem']"))
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

    public void fillAddRequisiteAttributeField() {
        wait.waitForElementIsClickable(addRequisiteAttributeButton);
        addRequisiteAttributeButton.click();
      //  requisiteButton.click();
      //  requisiteButton.click();
        wait.waitForElementIsClickable(requsiteAttributeLowerThanValue);
        requsiteAttributeLowerThanValue.click();
    }
    
    public void fillRequisiteAttributeField() {
        wait.waitForElementIsClickable(requisiteAttributeButton);
        requisiteAttributeButton.click();
        requisiteAttributeButton.click();
        requisiteAttributeButton.click();
        wait.waitForElementIsClickable(requsiteAttributeLowerThanValue);
        requsiteAttributeLowerThanValue.click();
    }

    public void setDateField(String date) {
        dateField.click();
        dateField.clear();
        dateField.sendKeys(date);
    }
    
    public void fillAddConditionFormAs(String fragment, String fragmentAttribute, String requisite, String requisiteAttribute, String date){
    	
    	wait.waitForElementIsClickable(addFragmentField);
    	addFragmentField.click();
    	addFragmentField.sendKeys(fragment);

    	wait.waitForElementIsClickable(addFragmentAttributeField);
    	addFragmentAttributeField.click();
    	addFragmentAttributeField.sendKeys(fragmentAttribute);
    	
    	wait.waitForElementIsClickable(addRequisiteField);
    	addRequisiteField.click();
    	addRequisiteField.sendKeys(requisite);
    	
    	wait.waitForElementIsClickable(addRequisiteAttributeField);
    	addRequisiteAttributeField.click();
    	addRequisiteAttributeField.sendKeys(requisiteAttribute);
    	
    	wait.waitForElementIsClickable(addDateField);
    	addDateField.click();
    	addDateField.sendKeys(date);
    	
    	
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
    
    public void fillDateFieldAs(String date){
    	
    	wait.waitForElementIsClickable(dateField);
    	dateField.click();
    	dateField.clear();
    	dateField.sendKeys(date);
    	
    }
    
    public void fillAddDateFieldAs(String date){
    	
    	wait.waitForElementIsClickable(addDateField);
    	dateField.click();
    	dateField.clear();
    	dateField.sendKeys(date);
    	
    }
    
    public void clickAddButton(){
    	
    	wait.waitForElementIsClickable(addButton);
    	addButton.click();
    	
    }
    
    public void clickNewTaskButton(){
    	
    	wait.waitForElementIsClickable(newTaskButton);
    	newTaskButton.click();
    	
    }
    
    public void clickAddConditionButton(){
    	wait.waitForElementIsClickable(addConditionButton);
    	addConditionButton.click();
    	
    }
    
    
    
    public boolean fillAllFieldAs(String fragment, String requisite, String requisiteAttribute, String date){
    	
    	wait.waitForElementIsClickable(fragmentField);
    	fragmentField.click();
    	fragmentField.clear();
    	fragmentField.sendKeys(fragment);
    	
    	wait.waitForElementIsClickable(fragmentAttributeButton);
    	fragmentAttributeButton.click();
    	wait.waitForElementIsClickable(fragmentAttributeAllRecordingValue);
    	fragmentAttributeAllRecordingValue.click();
    
    	
    	wait.waitForElementIsClickable(requisiteButton);
    	requisiteButton.click();
    	wait.waitForElementIsClickable(requisiteOperationDateValue);
    	requisiteOperationDateValue.click();
    	
    	wait.waitForElementIsClickable(requisiteAttributeField);
    	requisiteAttributeField.click();
    	requisiteAttributeField.clear();
    	requisiteAttributeField.sendKeys(requisiteAttribute);

    	fillDateFieldAs(date);
    	
    	wait.waitForElementIsClickable(submitButton);
    	submitButton.click();
    	
    	wait.waitForElementIsClickable(buttonSaveInList);
    	
    	return !resultList.isEmpty();
    }

    public boolean fillAllFieldAForRecidive(String fragment, String date){
    	
    	wait.waitForElementIsClickable(fragmentField);
    	fragmentField.click();
    	fragmentField.clear();
    	fragmentField.sendKeys(fragment);
    	
    	wait.waitForElementIsClickable(fragmentAttributeButton);
    	fragmentAttributeButton.click();
    	wait.waitForElementIsClickable(fragmentAttributeAllRecordingValue);
    	fragmentAttributeAllRecordingValue.click();
    
    	
    	wait.waitForElementIsClickable(requisiteButton);
    	requisiteButton.click();
    	wait.waitForElementIsClickable(requisiteFindRecidiveDateValue);
    	requisiteFindRecidiveDateValue.click();
    	

    	fillRequisiteAttributeField();

    	fillDateFieldAs(date);
    	
    	wait.waitForElementIsClickable(submitButton);
    	submitButton.click();
    	
    	wait.waitForElementIsClickable(buttonSaveInList);
    	
    	return !resultList.isEmpty();
    }

    public boolean fillAllFieldForPassportPart(String date){
    	
    	wait.waitForElementIsClickable(fragmentButton);
    	fragmentField.click();
    	wait.waitForElementIsClickable(fragmentPassportPartValue);
    	fragmentPassportPartValue.click();
    	
    	wait.waitForElementIsClickable(requisiteButton);
    	requisiteButton.click();
    	wait.waitForElementIsClickable(requisiteBirthDateValue);
    	requisiteBirthDateValue.click();
    
    	fillRequisiteAttributeField();
        
    	fillDateFieldAs(date);
    	
    	wait.waitForElementIsClickable(submitButton);
    	submitButton.click();
    	
    	wait.waitForElementIsClickable(buttonSaveInList);
    	
    	return !resultList.isEmpty();
    }
    

    public boolean fillAllFieldForHasInformation(){
    	
    	wait.waitForElementIsClickable(fragmentButton);
    	fragmentField.click();
    	wait.waitForElementIsClickable(selectDiagnosFragmnent);
    	selectDiagnosFragmnent.click();
    	
    	wait.waitForElementIsClickable(fragmentAttributeButton);
    	fragmentAttributeButton.click();
    	wait.waitForElementIsClickable(fragmentAttributeHasInformationValue);
    	fragmentAttributeHasInformationValue.click();
    	
    	wait.waitForElementIsClickable(submitButton);
    	submitButton.click();
    	
    	wait.waitForElementIsClickable(buttonSaveInList);
    	
    	return !resultList.isEmpty();
    }
    
    public boolean fillAllFieldsForAddOrRequsiteButton(String date){
    	
    	fillFragmentField();
    	fillFragmentAttributeField();
    	fillRequisiteField();
    	fillRequisiteAttributeField();
    	fillDateFieldAs(date);
    	clickAddButton();
    	clickNewTaskButton();
    	wait.waitForElementIsClickable(newTaskButtonOrValue);
    	newTaskButtonOrValue.click();
    	fillAddRequisiteAttributeField();
    	fillAddDateFieldAs(date);
    	clickSumbit();
    	
    	wait.waitForElementIsClickable(buttonSaveInList);
    	
    	
    	return !resultList.isEmpty();
    }
    
    
    public boolean fillAllFieldsForAddANDRequsiteButton(String date){
    	
    	fillFragmentField();
    	fillFragmentAttributeField();
    	fillRequisiteField();
    	fillRequisiteAttributeField();
    	fillDateFieldAs(date);
    	clickAddButton();
    	clickNewTaskButton();
    	wait.waitForElementIsClickable(newTaskButtonANDValue);
    	newTaskButtonANDValue.click();
    	fillAddRequisiteAttributeField();
    	fillAddDateFieldAs(date);
    	clickSumbit();
    	
    	wait.waitForElementIsClickable(buttonSaveInList);
    	
    	
    	return !resultList.isEmpty();
    }
    
    public boolean fillAllFieldsForAddConditionRequsiteButton(String fragment, String fragmentAttribute, String requisite, String requisiteAttribute, String date){
    	
    	fillFragmentField();
    	fillFragmentAttributeField();
    	fillRequisiteField();
    	fillRequisiteAttributeField();
    	fillDateFieldAs(date);
    	clickAddConditionButton();
    	fillAddConditionFormAs(fragment, fragmentAttribute, requisite, requisiteAttribute, date);
    	clickSumbit();
    	
    	wait.waitForElementIsClickable(buttonSaveInList);
    	
    	
    	return !resultList.isEmpty();
    }
    
    
}
