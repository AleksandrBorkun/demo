package com.epam.tf.pages;

import com.epam.tf.steps.RegulatedSearchPageSteps;
import com.epam.tf.steps.SearchBySurnameSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {

	@FindBy(xpath = "//a[text()='Списки']")
	private WebElement buttonLists;

	@FindBy(xpath = "//a[text() = 'Новый Пациент']")
	private WebElement newPatientButton;

	@FindBy(id = "LastName")
	private WebElement surNameSearchField;

	@FindBy(xpath = "//button[text() = 'Поиск']")
	private WebElement searchButton;

	@FindBy(xpath = "//td[text() = 'Давыдчик']")
	private WebElement resultSurName;

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

	@FindBy(xpath = "//td[text() = 'Иванов']/..//a[@data-content=\"Редактировать\"]")
	private WebElement editPatientButton;

	@FindBy(xpath = "//*[@data-content=\"Удалить\"]")
	private WebElement deleteDiagnoseButton;

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
	private WebElement EditPatientDataButton;
	
	@FindBy(xpath = "//a[@class = 'btn-user nav-panel-btn']")
	private WebElement userIconButton;
	
	@FindBy(xpath = "//a[@class = 'btn-danger nav-panel-btn']")
	private WebElement exitButton;
	
	@FindBy(xpath = "//div[@class = 'heading active']/span")
	private WebElement searchByNameButton;

	public void clickEditPatientDataButton(){
		EditPatientDataButton.click();
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

	public void deleteDiagnose() {
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
	
	public boolean isNewPatientButtonPresent(){
		wait.waitForElementIsClickable(newPatientButton);
		return newPatientButton.isDisplayed();
	}
	
	public boolean isSearchByNameButtonPresent(){
		wait.waitForElementIsClickable(searchByNameButton);
		return searchByNameButton.isDisplayed();
	}
	
	public boolean isExitButtonPresent(){
		wait.waitForElementIsClickable(exitButton);
		return exitButton.isDisplayed();
	}
	
	public boolean isUserIconPresent(){
		wait.waitForElementIsClickable(userIconButton);
		return userIconButton.isDisplayed();
	}
	
	public boolean isRegulatedSearchButtonPresent(){
		wait.waitForElementIsClickable(regulatedSearch);
		return regulatedSearch.isDisplayed();
	}
	
	public boolean isInformationSearchPresent(){
		wait.waitForElementIsClickable(informationalSearchButton);
		return informationalSearchButton.isDisplayed();
	}
	
	
	
}
