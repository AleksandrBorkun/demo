package com.epam.tf.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.tf.utils.ScreenshotExecutor;

@Listeners(ScreenshotExecutor.class)
public class ShouldCheckSearchBySurnameAndEditDiagnosOfPatient extends BaseTest{

	private final String surname = "Мармузевич";
	
	@Test
	public void editDiagnosOfPatientPossitiveTest(){
		
		Assert.assertTrue(
			
				mainPageSteps
				.getSerchBySurnameForm(surname)
				.goToPatientDiagnosisFormPage()
				.clickSaveButton()
				.isAddButtonIsVisible());
		
	}
}
