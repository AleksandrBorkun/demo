package com.epam.tf.steps;

import org.openqa.selenium.WebDriver;

import com.epam.tf.pages.MainPage;
import com.epam.tf.pages.SearchPatientsOfForthStagePage;

public class SearchPatientForthStageSteps extends AbstractSteps {

	public SearchPatientForthStageSteps(WebDriver driver) {
		super(driver);

	}

	private SearchPatientsOfForthStagePage searchPage = new SearchPatientsOfForthStagePage(driver);

	public SearchPatientForthStageSteps positiveSearchPatient() {
		log.info("try to fill form and make a search");
		searchPage.fillTheFieldAndMakeSearch();
		return this;
	}

	public SearchPatientForthStageSteps clickEdit() {
		log.info("try to click edit button");
		searchPage.clickEditPatientButton();
		return this;

	}

}
