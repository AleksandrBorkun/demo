package com.epam.tf.steps;

import com.epam.tf.pages.PatientDiagnosisFormPage;
import org.openqa.selenium.WebDriver;

import com.epam.tf.pages.SearchBySurnamePage;

public class SearchBySurnameSteps extends AbstractSteps{

	public SearchBySurnameSteps(WebDriver driver) {
		super(driver);
	}

	SearchBySurnamePage surnameSearchPage = new SearchBySurnamePage(driver);
	PatientDiagnosisFormPage patientDiagnosFormPage = new PatientDiagnosisFormPage(driver);
	
	public SearchBySurnameSteps goToPatientDiagnosisFormPage(){
		log.info("try to open patient diagnosis edit form");
		surnameSearchPage.clickMainPageEditButton();
		surnameSearchPage.clickEditPatientButton();
	return this;
	}
	
	public SearchBySurnameSteps clickSaveButton(){
		log.info("try to click save button");
		patientDiagnosFormPage.clickSaveButton();
		return this;
	}
	
	public boolean isAddButtonIsVisible(){
		log.info("try to find add button");
		return patientDiagnosFormPage.isAddButtonIsPresent();
		
	}
	
}
