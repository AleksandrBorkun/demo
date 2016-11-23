package com.epam.tf.steps;

import org.openqa.selenium.WebDriver;

import com.epam.tf.pages.PatientDiagnosFormPage;
import com.epam.tf.pages.SearchPatientsOfForthStagePage;

public class SearchPatientForthStageSteps extends AbstractSteps {

	public SearchPatientForthStageSteps(WebDriver driver) {
		super(driver);

	}

	private PatientDiagnosFormPage diagnosEditorForm = new PatientDiagnosFormPage(driver);
	private SearchPatientsOfForthStagePage searchPage = new SearchPatientsOfForthStagePage(driver);

	public SearchPatientForthStageSteps positiveSearchPatient() {
		log.info("try to fill form and make a search");
		searchPage.fillTheFieldAndMakeSearch();
		return this;
	}

	public SearchPatientForthStageSteps clickEdit() {
		log.info("try to click edit button");
		searchPage.clickEditPatientButton();
		diagnosEditorForm.goToEditor();
		return this;

	}

	public SearchPatientForthStageSteps clickSaveButton() {
		log.info("try to save all change");
		diagnosEditorForm.clickSaveButton();
		return this;
	}

	public boolean isAddButtonIsPresent() {
		log.info("try to find add button");
		return diagnosEditorForm.isAddButtonIsPresent();
	}

}
