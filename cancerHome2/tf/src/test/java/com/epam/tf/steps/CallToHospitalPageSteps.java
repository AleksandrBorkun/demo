package com.epam.tf.steps;

import org.openqa.selenium.WebDriver;

import com.epam.tf.pages.CallToHospitalPage;

public class CallToHospitalPageSteps extends AbstractSteps{

	private CallToHospitalPage callToHospitalPage;
	
	public CallToHospitalPageSteps(WebDriver driver) {
		super(driver);
		callToHospitalPage = new CallToHospitalPage(driver);
	}

	public boolean fillCallFromFormAndClickSearch(String date){
		log.info("try to fill form");
		callToHospitalPage.fillControlDateField(date);
		log.info("try to search");
		callToHospitalPage.clickSearchButton();
		
		return callToHospitalPage.checkSearchResultList();
		
	}
}
