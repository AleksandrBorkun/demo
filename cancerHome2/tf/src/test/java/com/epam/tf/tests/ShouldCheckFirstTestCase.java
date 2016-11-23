package com.epam.tf.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.epam.tf.steps.SearchBySurnameSteps;

public class ShouldCheckFirstTestCase extends BaseTest{
	
	private final static String lastName = "Калиновская";
	private SearchBySurnameSteps searchByLastName = new SearchBySurnameSteps(driver);
	
	@Test
	public void firstStepTest(){
		
		//chek is the main element is present
		Assert.assertTrue(mainPageSteps.isMainElementsPresent());
		
		//check that patient card is displaying 
		Assert.assertTrue(mainPageSteps.getSerchBySurnameForm(lastName).isPatientCardPresent());
		
		//searchByLastName.goToPatientDiagnosFormPage()
		
		
	}

}
