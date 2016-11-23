package com.epam.tf.steps;

import com.epam.tf.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps extends AbstractSteps {

	private MainPage mainPage;

	public MainPageSteps(WebDriver driver) {
		super(driver);
		mainPage = new MainPage(driver);
	}

	public NewPatientPageSteps goToNewPatientForm() {
		log.info("go to New Patient Page");
		mainPage.goToNewPatientForm();
		return new NewPatientPageSteps(driver);
	}

	public ListsPageSteps goToListsPage() {
		log.info("go to Lists Page");
		mainPage.goToListsPage();
		return new ListsPageSteps(driver);
	}

	public MainPageSteps insertSurNameIntoSearchField(String searchRequestSurName) {
		log.info("insert search request into search field");
		mainPage.insertSurNameIntoSearchField(searchRequestSurName);
		return this;
	}

	public MainPageSteps applySearchRequest() {
		log.info("click Search button");
		mainPage.clickSubmitSearchButton();
		return this;
	}

	public String getSearchResultBySurName(String surName) {
		log.info("try to get result - SurName");
		return mainPage.getSearchResultBySurName(surName);
	}

	public SearchByCatalogPageSteps goToSearchByCatalog() {
		log.info("go to Search By Catalog Page");
		mainPage.goToSearchByCatalog();
		return new SearchByCatalogPageSteps(driver);
	}

	public RegulatedSearchPageSteps goToRegulatedPageDispensaryCall() {
		log.info("go to Dispensary call from regulated menu on the main page");
		return mainPage.goToRegulatedSearchPagePatientWithoutInfo();
	}

	public UsersPageSteps goToUsersPage() {
		log.info("go to users page");
		mainPage.goToUsersPage();
		return new UsersPageSteps(driver);
	}

	public PatientCardPageSteps pressFirstRefactorButton() {
		log.info("press refactor button for 1'st element");
		mainPage.clickFirstRefactorButton();
		return new PatientCardPageSteps(driver);
	}

	public MainPageSteps editPatient() {
		log.info("Go to edit patient form");
		mainPage.goToEditPatientForm();
		return this;
	}

	public MainPageSteps deleteDiagnose() {
		log.info("Click delete diagnose button");
		mainPage.deleteDiagnose();
		return this;
	}

	public MainPageSteps confirmDeleteDiagnose() {
		log.info("Click confirm delete diagnose button");
		mainPage.confirmDeleteDiagnose();
		return this;
	}

	public String getDeletePrimaryDiagnoseErrorMessage() {
		log.info("Get error message");
		return mainPage.getErrorMessage();
	}

	public SearchPatientForthStageSteps goToSearchPatientForthStage() {
		log.info("try to open search form by patient of IV stage");
		mainPage.getRegulatedSearchPatientsOfForthStage();
		return new SearchPatientForthStageSteps(driver);
	}
	
	public SearchBySurnameSteps getSerchBySurnameForm(String surname){
		log.info("try to get search by surname form");
		mainPage.getSerchBySurnameForm(surname);
		return new SearchBySurnameSteps(driver);
	}

	public PatientCardPageSteps editPatientData(){
		log.info("go to PatientCardDataPage");
		mainPage.clickEditPatientDataButton();
		return new PatientCardPageSteps(driver);
	}
	
	public boolean isMainElementsPresent(){
		
		return mainPage.isExitButtonPresent()
				&&mainPage.isInformationSearchPresent()
				&&mainPage.isNewPatientButtonPresent()
				&&mainPage.isRegulatedSearchButtonPresent()
				&&mainPage.isSearchByNameButtonPresent()
				&&mainPage.isUserIconPresent();
	}

}
