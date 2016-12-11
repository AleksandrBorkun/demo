package com.epam.tf.steps;

import org.openqa.selenium.WebDriver;

import com.epam.tf.pages.HaveNoInformationAboutHealingPage;

public class HaveNoInformationAboutHealingSteps extends AbstractSteps{

	private HaveNoInformationAboutHealingPage haveNoInformationPage;
	
	public HaveNoInformationAboutHealingSteps(WebDriver driver) {
		super(driver);
		haveNoInformationPage = new HaveNoInformationAboutHealingPage(driver);
	}

	public boolean fillDateAndClickSearch(String date){
		
		log.info("try to fill date and make search");
		return haveNoInformationPage.fillDateAndClickSearch(date);
		
	}
	
	
}
