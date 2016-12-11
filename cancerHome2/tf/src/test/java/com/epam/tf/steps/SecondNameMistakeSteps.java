package com.epam.tf.steps;

import org.openqa.selenium.WebDriver;

import com.epam.tf.pages.SecondNameMistakePage;

public class SecondNameMistakeSteps extends AbstractSteps{

	private SecondNameMistakePage secondNameMistekePage;
	
	public SecondNameMistakeSteps(WebDriver driver) {
		super(driver);
		secondNameMistekePage = new SecondNameMistakePage(driver);		
	}
	
	public boolean fillRegistrationDateFromAndClickSearch(String date){
		
		log.info("try to fill Registration Date From And Click Search");
		
		return secondNameMistekePage.fillRegistrationDateFromAndClickSearch(date);
	}
}
