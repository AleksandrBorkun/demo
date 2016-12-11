package com.epam.tf.steps;

import org.openqa.selenium.WebDriver;

import com.epam.tf.pages.PremilitarySearchPage;

public class PremilitarySearchSteps extends AbstractSteps{

	private PremilitarySearchPage premilitaryPage;
	
	public PremilitarySearchSteps(WebDriver driver) {
		super(driver);
		premilitaryPage = new PremilitarySearchPage(driver);
	}

	
	public boolean fillBirthDateAndClickSearch(String date){
		
		log.info("try to fill Birth Date And Click Search");
		return premilitaryPage.fillBirthDateAndClickSearch(date);
		
	}
}
