package com.epam.tf.pages;

import com.epam.tf.steps.CallToHospitalPageSteps;
import com.epam.tf.steps.ConsistingAtTheEndOfThePeriodSteps;
import com.epam.tf.steps.HaveNoInformationAboutHealingSteps;
import com.epam.tf.steps.PremillitarySearchSteps;
import com.epam.tf.steps.RegulatedSearchPageSteps;
import com.epam.tf.steps.SecondNameMistakeSteps;
import com.epam.tf.utils.ThreadSleep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[text()='Списки']")
    private WebElement buttonLists;

    @FindBy(xpath = "//a[text() = 'Новый Пациент']")
    private WebElement newPatientButton;

    @FindBy(id = "LastName")
    private WebElement surNameSearchField;

    @FindBy(xpath = "//a[text()='Поиск']")
    private WebElement searchButtonGlobal;

    @FindBy(css = ".list-search")
    private WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Регламентированный поиск')]")
    private WebElement regulatedSearchMenu;

    @FindBy(xpath = "//span[contains(text(),'Контроль диспансеризации')]")
    private WebElement regulatedSearchDispensaryControlMenu;

    @FindBy(xpath = "//a[@data-ajax='true' and text()='Пациенты, о которых нет сведений']")
    private WebElement regulatedSearchPatientsWithoutInfo;

    @FindBy(xpath = "//a[text() = 'Информационный поиск']")
    private WebElement informationalSearchButton;

    @FindBy(xpath = "//a[text()='Администрирование']")
    private WebElement administratorsButton;

    @FindBy(xpath = "//a[text() = 'Пользователи']")
    private WebElement usersButton;

    @FindBy(xpath = "//td[@class='control-elements']/a[1]")
    private WebElement firstElementRefactorButton;

    @FindBy(xpath = "//a[@data-content='Редактировать']")
    private WebElement editPatientButton;

    @FindBy(xpath = "//*[@data-content='Удалить']")
    private WebElement deleteDiagnoseButton;

	@FindBy(xpath = ".//td[text() = '30000']/following-sibling::*")
	private WebElement firstPatientRefactorButton;

	@FindBy(xpath = ".//td[text() = '30123']/following-sibling::*")
	private WebElement firstPatientSixRefactorButton;

	@FindBy(xpath = ".//td[text() = '42']/following-sibling::*")
	private WebElement secondPatientRefactorButton;

	@FindBy(xpath = ".//td[text() = '43']/following-sibling::*")
	private WebElement thirdPatientRefactorButton;

	@FindBy(xpath = ".//td[text() = '44']/following-sibling::*")
	private WebElement fourthPatientRefactorButton;

    @FindBy(xpath = "//button[text() = 'Удалить']")
    private WebElement confirmDeleteDiagnoseButton;

    @FindBy(xpath = "//li[text() = '039. Удаление основного диагноза невозможно']")
    private WebElement resultMessageField;

    @FindBy(xpath = "//ul[@class = 'app-users']/li[2]/div/a")
    private WebElement lastAnalysisDiagnose;

    @FindBy(xpath = "//a[text()='Больные IV стадии']")
    private WebElement patientsOfForthStage;

    @FindBy(xpath = "//div[@class = 'scrollable-cell']/ul/li[4]/div/a")
    private WebElement regulatedSearch;

    @FindBy(xpath = "//a[@class='glyphicon glyphicon-edit']")
    private WebElement editPatientDataButton;

    @FindBy(xpath = ".//div[@id='patients']//h3")
	private WebElement patientInfoLOGO;
    
    @FindBy(xpath = "//button[@class='btn-success list-search cancel']")
    private WebElement listSearchButton;
    
	@FindBy(xpath = "//a[@data-ajax-url='/Search/ReglamentSearch/CallToDispensary']")
	private WebElement callToHospitalButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Анализ сведений о лечении')]")
	private WebElement informationAboutLastAnalyse;

	@FindBy(xpath = "//a[text() = 'Не имеющие сведений о лечении']")
	private WebElement haveNoInformationAboutHealingButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Другие регламентированные списки')]")
	private WebElement otherRegulatedSearchButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Допризывники (для военкоматов)')]")
	private WebElement premilitaryButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Дополнительные списки для анализа информации в БД')]")
	private WebElement otherBonusListForDB;
	
	@FindBy(xpath = "//a[contains(text(), 'Ошибка в отчестве')]")
	private WebElement secondNameMistake;
	
	@FindBy(xpath = "//span[contains(text(), 'Состоящие на учете (анализ клинической группы)')]")
	private WebElement staingAtClinicalGroup;
	
	@FindBy(xpath = "//a[contains(text(), 'Состоящие на учете на конец периода')]")
	private WebElement staingAtLastPeriod;


	public void clickEditPatientDataButton(){
		editPatientDataButton.click();
	}

	public void clickFirstPatientRefactorButton() {
		firstPatientRefactorButton.click();
	}

	public void clickFirstPatientSexRefactorButton(){
		firstPatientSixRefactorButton.click();
	}

	public void clickSecondPatientRefactorButton() {
		secondPatientRefactorButton.click();
	}

	public void clickThirdPatientRefactorButton() {
		thirdPatientRefactorButton.click();
	}

	public void clickFourthPatientRefactorButton() {
		fourthPatientRefactorButton.click();
	}

	public void clickFirstRefactorButton() {
		firstElementRefactorButton.click();
	}

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void goToNewPatientForm() {
		newPatientButton.click();
	}

	public void goToListsPage() { 
		ThreadSleep.waitElement(150);
		wait.waitForElementIsClickable(buttonLists);
		buttonLists.click();
	}

	public void insertSurNameIntoSearchField(String searchRequestSurName) {
		surNameSearchField.sendKeys(searchRequestSurName);
	}

	public void clickSubmitSearchButtonGlobal() {
		searchButtonGlobal.click();
	}

	public void clickSubmitSearchButton() {
		searchButton.click();
	}

	public String getSearchResultBySurName(String surName) {
		return driver.findElement(By.xpath("//td[text() = '" + surName + "']")).getText();
	}

	public void goToSearchByCatalog() {
		informationalSearchButton.click();
	}

	public void getRegulatedSearchPatientsOfForthStage() {
		wait.waitForElementIsClickable(regulatedSearchMenu);
		regulatedSearchMenu.click();
		wait.waitForElementIsClickable(lastAnalysisDiagnose);
		lastAnalysisDiagnose.click();
		wait.waitForElementIsClickable(patientsOfForthStage);
		patientsOfForthStage.click();
	}

	public RegulatedSearchPageSteps goToRegulatedSearchPagePatientWithoutInfo() {
		regulatedSearchMenu.click();
		regulatedSearchDispensaryControlMenu.click();
		wait.waitForElementIsClickable(regulatedSearchPatientsWithoutInfo);
		regulatedSearchPatientsWithoutInfo.click();
		return new RegulatedSearchPageSteps(driver);
	}

	public void goToUsersPage() {
		administratorsButton.click();
		usersButton.click();
	}

	public void goToEditPatientForm() {
		wait.waitForElementIsClickable(editPatientButton);
		editPatientButton.click();
	}

	public void deletePrimaryDiagnose() {
		wait.waitForElementIsClickable(deleteDiagnoseButton);
		deleteDiagnoseButton.click();
	}

	public void confirmDeleteDiagnose() {
		wait.waitForElementIsClickable(confirmDeleteDiagnoseButton);
		confirmDeleteDiagnoseButton.click();
	}

	public String getErrorMessage() {
		wait.waitForElementIsClickable(resultMessageField);
		return resultMessageField.getText();
	}

	public void getSearchBySurnameForm(String surname) {
		wait.waitForElementIsClickable(surNameSearchField);
		surNameSearchField.click();
		surNameSearchField.clear();
		surNameSearchField.sendKeys(surname);
		wait.waitForElementIsClickable(searchButton);
		searchButton.click();
	}

	public void confirmDeletingPatient() {
			wait.waitForElementIsClickable(searchButton);
			Assert.assertTrue(patientInfoLOGO.getText().contains("Нет информации"));
	}

	public CallToHospitalPageSteps goToRegulatedSearchPageCallToHospital() {
 		regulatedSearchMenu.click();
 		regulatedSearchDispensaryControlMenu.click();
 		waitForLoaderIndicatorDisapearing();
 		wait.waitForElementAppearing(callToHospitalButton);
 		callToHospitalButton.click();
 
 		return new CallToHospitalPageSteps(driver);
 	}
 
 	public HaveNoInformationAboutHealingSteps goToHaveNoInformationAboutHealing() {
 
 		regulatedSearchMenu.click();
 		wait.waitForElementIsClickable(informationAboutLastAnalyse);
 		informationAboutLastAnalyse.click();
 		wait.waitForElementIsClickable(haveNoInformationAboutHealingButton);
 		haveNoInformationAboutHealingButton.click();
 
 		return new HaveNoInformationAboutHealingSteps(driver);
 	}
 
 	public PremillitarySearchSteps goToPremillitarySearchPage() {
 
 		regulatedSearchMenu.click();
 		wait.waitForElementIsClickable(otherRegulatedSearchButton);
 		otherRegulatedSearchButton.click();
 		wait.waitForElementIsClickable(premilitaryButton);
 		premilitaryButton.click();
 
 		return new PremillitarySearchSteps(driver);
 	}
 
 	public SecondNameMistakeSteps goToSecondNameMistakePage() {
 
 		regulatedSearchMenu.click();
 		wait.waitForElementIsClickable(otherBonusListForDB);
 		otherBonusListForDB.click();
 		wait.waitForElementIsClickable(secondNameMistake);
 		secondNameMistake.click();
 
 		return new SecondNameMistakeSteps(driver);
 	}
 	
 	
 	public ConsistingAtTheEndOfThePeriodSteps goToConsistingAtTheEndOfThePeriodpage() {
 
 		regulatedSearchMenu.click();
 		wait.waitForElementIsClickable(staingAtClinicalGroup);
 		staingAtClinicalGroup.click();
 		wait.waitForElementIsClickable(staingAtLastPeriod);
 		staingAtLastPeriod.click();
 
 		return new ConsistingAtTheEndOfThePeriodSteps(driver);
 	}
}
