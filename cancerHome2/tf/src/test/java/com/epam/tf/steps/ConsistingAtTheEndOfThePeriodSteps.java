package com.epam.tf.steps;

import org.openqa.selenium.WebDriver;

import com.epam.tf.pages.ConsistingAtTheEndOfThePeriodPage;

public class ConsistingAtTheEndOfThePeriodSteps extends AbstractSteps{

	ConsistingAtTheEndOfThePeriodPage consistingPage;
	
	public ConsistingAtTheEndOfThePeriodSteps(WebDriver driver) {
		super(driver);
		consistingPage = new ConsistingAtTheEndOfThePeriodPage(driver);
	}

	public boolean fillReportingFieldAndClickSearch(String date){
		
		log.info("try to fill Reporting Field And Click Search");
		return consistingPage.fillReportingFieldAndClickSearch(date);
		
	}
	
}
