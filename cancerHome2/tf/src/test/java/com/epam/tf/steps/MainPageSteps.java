package com.epam.tf.steps;

import com.epam.tf.entity.Patient;
import com.epam.tf.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps extends AbstractSteps {

	private MainPage mainPage;

	/**
	 * New method which transfer to patient's edit page
	 * 
	 * @return new instance of {@code DiagnosisFormPageSteps}
	 */

	public DiagnosisFormPageSteps editFirstPatient() {
		log.info("press refactor button for 1'st element");
		mainPage.clickFirstRefactorButton();
		return new DiagnosisFormPageSteps(driver);
	}

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

	public MainPageSteps applySearchRequestGlobal() {
		log.info("click global Search button");
		mainPage.clickSubmitSearchButtonGlobal();
		return this;
	}

	public MainPageSteps applySearchRequestList() {
		log.info("click Search Sub list  button");
		mainPage.clickListSearchButton();
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

	/**
	 * New method which choose correct patient and transfer to Patient Card Page
	 * 
	 * @return new instance of {@code PatientCardPageSteps}
	 */

	public PatientCardPageSteps pressPatientRefactorButton(Patient patient) {
		log.info("press refactor button for " + patient.getIdn() + " patient idn");
		switch (patient.getIdn().intValue()) {
		case 41:
			mainPage.clickFirstPatientRefactorButton();
			break;
		case 42:
			mainPage.clickSecondPatientRefactorButton();
			break;
		case 43:
			mainPage.clickThirdPatientRefactorButton();
			break;
		case 44:
			mainPage.clickFourthPatientRefactorButton();
			break;
		}
		return new PatientCardPageSteps(driver);
	}

	public MainPageSteps editPatient() {
		log.info("Go to edit patient form");
		mainPage.goToEditPatientForm();
		return this;
	}

	public MainPageSteps deletePrimaryDiagnose() {
		log.info("Click delete diagnose button");
		mainPage.deletePrimaryDiagnose();
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

/*	public CallToHospitalPageSteps goToRegulatedSearchPageCallToHostital() {
		log.info("go to Hospital Page");
		return mainPage.goToRegulatedSearchPageCallToHostital();
	}

	public HaveNoInformationAboutHealingSteps goToHaveNoInformationAboutHealing() {
		log.info("go to Have No Information About Healing");
		return mainPage.goToHaveNoInformationAboutHealing();
	}

	public ConsistingAtTheEndOfThePeriodSteps goToConsistingAtTheEndOfThePeriodpage() {
		
		log.info("go to Consisting At The End Of The Period Page");
		return mainPage.goToConsistingAtTheEndOfThePeriodpage();
		
	}
	
	public SecondNameMistakeSteps goToSecondNameMistakePage() {
		
		log.info("go To Second Name Mistake Page");
		return mainPage.goToSecondNameMistakePage();
		
	}
	
	public PremilitarySearchSteps goToPremilitarySearchPage() {
		log.info("go to Premilitary Search Page");
		return mainPage.goToPremilitarySearchPage();
	}*/
	
	public SearchPatientForthStageSteps goToSearchPatientForthStage() {
		log.info("try to open search form by patient of IV stage");
		mainPage.getRegulatedSearchPatientsOfForthStage();
		return new SearchPatientForthStageSteps(driver);
	}

	public SearchBySurnameSteps getSerchBySurnameForm(String surname) {
		log.info("try to get search by surname form");
		mainPage.getSerchBySurnameForm(surname);
		return new SearchBySurnameSteps(driver);
	}

	public PatientCardPageSteps editPatientData() {
		log.info("go to PatientCardDataPage");
		mainPage.clickEditPatientDataButton();
		return new PatientCardPageSteps(driver);
	}


	public DiagnosisMetastasesMainPageSteps goToMetastasesInfoPage(Patient patient) {
		return insertSurNameIntoSearchField(patient.getLastName()).applySearchRequest().editPatientData()
				.goToDateListOfDiagnoses().goToDiagnosisOfFirstDateMenu().goToMetastasesOfDiagnosis();
	}

	// public NewDispensaryPageSteps goToNewDispensaryPage (Patient patient){
	// return insertSurNameIntoSearchField(patient.getLastName())
	// .applySearchRequest()
	// .editPatientData()
	// .goToNewDispensaryPage();
	// }
}
