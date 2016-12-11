package com.epam.tf.pages;

import com.epam.tf.steps.CallToHospitalPageSteps;
import com.epam.tf.steps.ConsistingAtTheEndOfThePeriodSteps;
import com.epam.tf.steps.HaveNoInformationAboutHealingSteps;
import com.epam.tf.steps.PremilitarySearchSteps;
import com.epam.tf.steps.RegulatedSearchPageSteps;
import com.epam.tf.steps.SecondNameMistakeSteps;
import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	@FindBy(xpath = "//a[text()='Списки']")
	private WebElement buttonLists;

	@FindBy(xpath = "//a[text() = 'Новый Пациент']")
	private WebElement newPatientButton;

	@FindBy(id = "LastName")
	private WebElement surNameSearchField;

	@FindBy(xpath = "//button[text() = 'Поиск']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[text()='Поиск']")
	private WebElement searchButtonGlobal;

	@FindBy(xpath = "//button[@class='btn-success list-search cancel']")
	private WebElement listSearchButton;

	@FindBy(xpath = "//span[contains(text(),'Регламентированный поиск')]")
	private WebElement regulatedSearchMenu;

	@FindBy(xpath = "//span[contains(text(), 'Другие регламентированные списки')]")
	private WebElement otherRegulatedSearchButton;

	@FindBy(xpath = "//span[contains(text(), 'Дополнительные списки для анализа информации в БД')]")
	private WebElement otherBonusListForDB;

	@FindBy(xpath = "//a[contains(text(), 'Ошибка в отчестве')]")
	private WebElement secondNameMistake;

	@FindBy(xpath = "//a[contains(text(), 'Допризывники (для военкоматов)')]")
	private WebElement premilitaryButton;

	@FindBy(xpath = "//span[contains(text(), 'Состоящие на учете (анализ клинической группы)')]")
	private WebElement staingAtClinicalGroup;

	@FindBy(xpath = "//a[contains(text(), 'Состоящие на учете на конец периода')]")
	private WebElement staingAtLastPeriod;

	@FindBy(xpath = "//a[contains(text(),'Вызов в диспансер')]")
	private WebElement callToHospitalButton;

	@FindBy(xpath = "//span[contains(text(), 'Анализ сведений о лечении')]")
	private WebElement informationAboutLastAnalyse;

	@FindBy(xpath = "//a[text() = 'Не имеющие сведений о лечении']")
	private WebElement haveNoInformationAboutHealingButton;

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

	@FindBy(xpath = ".//td[text() = '41']/following-sibling::*")
	private WebElement firstPatientRefactorButton;

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

	@FindBy(xpath = "/descendant::span[@class='caret'][4]")
	private WebElement diagnoseMenuButton;

	@FindBy(xpath = "/descendant::span[@class='caret'][5]")
	private WebElement diagnoseListButton;

	@FindBy(xpath = "")
	private WebElement metastasesButton;

	@FindBy(xpath = "//a[contains(text(), 'ИГХ неспецифические')]")
	private WebElement notSpecificIGHDiagnoseButton;

	@FindBy(id = "AnalysisDate")
	private WebElement dateOfResearchField;

	@FindBy(id = "AntibodiesName-Autocomplete-Button")
	private WebElement antibodyNameButton;

	@FindBy(id = "Result-Autocomplete-Button")
	private WebElement resultButton;

	@FindBy(xpath = "//button[text()='Сохранить']")
	private WebElement saveButton;

	@FindBy(xpath = "//a[text()='Добавить']")
	private WebElement addNewDiagnoseButton;

	@FindBy(xpath = "//a[@data-content='Редактировать']/preceding::a[1]")
	private WebElement deleteIGHDiagnoseButton;

	@FindBy(xpath = "//button[contains(text(),'Удалить')]")
	private WebElement confirmDeleteIGHDiagnoseButton;

	@FindBy(xpath = "//a[@data-content='Редактировать']")
	private WebElement editingIGHDiagnoseButton;

	@FindBy(xpath = "//label[contains(text(),'Исследования за')]")
	private WebElement resultOfEditingIGHDiagnoseField;

	@FindBy(xpath = "//a[contains(text(), 'генетические')]")
	private WebElement molecularGeneticDiagnoseButton;

	@FindBy(id = "AnalysisMethod-Autocomplete-Button")
	private WebElement analysisMethodButton;

	@FindBy(id = "Gene-Autocomplete-Button")
	private WebElement genSampleButton;

	@FindBy(id = "GeneticChanges-Autocomplete-Button")
	private WebElement geneticsChangesButton;

	@FindBy(id = "ResultOfMolecularGeneticAnalysis-Autocomplete-Button")
	private WebElement resultOfMolecularGeneticAnalysisButton;

	public void clickMolecularGeneticDiagnoseButton() {
		wait.waitForElementIsClickable(molecularGeneticDiagnoseButton);
		molecularGeneticDiagnoseButton.click();
	}

	public void fillDateOfMolecularGeneticDiagnoseField(String date) {
		wait.waitForElementIsClickable(dateOfResearchField);
		dateOfResearchField.sendKeys(date);
	}

	public void fillAnalysisMethodField() {
		wait.waitForElementIsClickable(analysisMethodButton);
		analysisMethodButton.click();
		selectByText("FISH");
	}

	public void fillGenSampleField() {
		ThreadSleep.waitElement(1000);
		wait.waitForElementIsClickable(genSampleButton);
		ThreadSleep.waitElement(1000);
		genSampleButton.click();
		selectByText("APC");
	}

	public void fillGenChangesField() {
		wait.waitForElementIsClickable(geneticsChangesButton);
		ThreadSleep.waitElement(1000);
		geneticsChangesButton.click();
		ThreadSleep.waitElement(1000);
		selectByText("Мутация");
	}

	public void fillResultOfMolecularGeneticField() {
		wait.waitForElementIsClickable(resultOfMolecularGeneticAnalysisButton);
		ThreadSleep.waitElement(1000);
		resultOfMolecularGeneticAnalysisButton.click();
		ThreadSleep.waitElement(1000);
		selectByText("Не выявлена");
	}

	public void clickDiagnoseMenuButton() {
		wait.waitForElementIsClickable(diagnoseMenuButton);
		diagnoseMenuButton.click();
	}

	public void clickDiagnoseListButton() {
		wait.waitForElementIsClickable(diagnoseListButton);
		diagnoseListButton.click();
	}

	public void clickIGHNotSpecificDiagnoseButton() {
		wait.waitForElementIsClickable(notSpecificIGHDiagnoseButton);
		notSpecificIGHDiagnoseButton.click();
	}

	public void fillDateOfDiagnoseField(String date) {
		wait.waitForElementIsClickable(dateOfResearchField);
		dateOfResearchField.sendKeys(date);
	}

	public void fillAntibodyNameField() {
		wait.waitForElementIsClickable(antibodyNameButton);
		antibodyNameButton.click();
		selectByText("Actin");
	}

	public void fillResultField() {
		wait.waitForElementIsClickable(resultButton);
		ThreadSleep.waitElement(1000);
		resultButton.click();
		ThreadSleep.waitElement(1000);
		selectByText("определен");
	}

	public void clickSaveDiagnoseButton() {
		wait.waitForElementIsClickable(saveButton);
		saveButton.click();
		waitForLoaderIndicatorDisapearing();
		wait.waitForElementIsClickable(addNewDiagnoseButton);
	}

	public void deleteSpecificDiagnose() {
		waitForLoaderIndicatorDisapearing();
		wait.waitForElementIsClickable(deleteIGHDiagnoseButton);
		deleteIGHDiagnoseButton.click();
		waitForLoaderIndicatorDisapearing();
		wait.waitForElementIsClickable(confirmDeleteIGHDiagnoseButton);
		confirmDeleteIGHDiagnoseButton.click();
		waitForLoaderIndicatorDisapearing();
	}

	public void editSpecificDiagnose(String date) {
		wait.waitForElementIsClickable(editingIGHDiagnoseButton);
		editingIGHDiagnoseButton.click();
		waitForLoaderIndicatorDisapearing();
		fillDateOfDiagnoseField(date);
		clickSaveDiagnoseButton();
	}

	public String getDateOfSpecificDiagnose() {
		waitForLoaderIndicatorDisapearing();
		wait.waitForElementIsClickable(resultOfEditingIGHDiagnoseField);
		String result = resultOfEditingIGHDiagnoseField.getText();
		return result;
	}

	public String getDateOfNewResearch() {
		waitForLoaderIndicatorDisapearing();
		wait.waitForElementIsClickable(dateOfResearchField);
		String result = dateOfResearchField.getText();
		return result;
	}

	public void clickEditPatientDataButton() {
		editPatientDataButton.click();
	}

	public void clickFirstPatientRefactorButton() {
		firstPatientRefactorButton.click();
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

	public void clickListSearchButton() {
		listSearchButton.click();
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

	public CallToHospitalPageSteps goToRegulatedSearchPageCallToHostital() {
		regulatedSearchMenu.click();
		regulatedSearchDispensaryControlMenu.click();
		// wait.waitForElementIsClickable(callToHospitalButton);
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

	public PremilitarySearchSteps goToPremilitarySearchPage() {

		regulatedSearchMenu.click();
		wait.waitForElementIsClickable(otherRegulatedSearchButton);
		otherRegulatedSearchButton.click();
		wait.waitForElementIsClickable(premilitaryButton);
		premilitaryButton.click();

		return new PremilitarySearchSteps(driver);
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

	public void getSerchBySurnameForm(String surname) {
		wait.waitForElementIsClickable(surNameSearchField);
		surNameSearchField.click();
		surNameSearchField.clear();
		surNameSearchField.sendKeys(surname);
		wait.waitForElementIsClickable(searchButton);
		searchButton.click();
	}

}
