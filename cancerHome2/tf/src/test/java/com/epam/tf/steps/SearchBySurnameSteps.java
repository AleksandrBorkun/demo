package com.epam.tf.steps;

import org.openqa.selenium.WebDriver;

import com.epam.tf.pages.PatientDiagnosFormPage;
import com.epam.tf.pages.SearchBySurnamePage;

public class SearchBySurnameSteps extends AbstractSteps{

	public SearchBySurnameSteps(WebDriver driver) {
		super(driver);
	}

	SearchBySurnamePage surnameSearchPage = new SearchBySurnamePage(driver);
	PatientDiagnosFormPage patientDiagnosFormPage = new PatientDiagnosFormPage(driver);
	
	public SearchBySurnameSteps goToPatientDiagnosFormPage(){
		log.info("try to open patient diagnos edit form");
		surnameSearchPage.clickMainPageEditButton();
		surnameSearchPage.clickEditButton();
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
	
	public boolean isPatientCardPresent(){
		return surnameSearchPage.isPatientCardPresent();
	}
	
}
