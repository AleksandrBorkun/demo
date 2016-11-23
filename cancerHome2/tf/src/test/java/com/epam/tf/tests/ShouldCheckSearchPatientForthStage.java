package com.epam.tf.tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.tf.utils.ScreenshotExecutor;

@Listeners(ScreenshotExecutor.class)
public class ShouldCheckSearchPatientForthStage extends BaseTest {

	@Test
	public void searchPatientForthStageTest() {

		Assert.assertTrue(
				
				mainPageSteps
				.goToSearchPatientForthStage()
				.positiveSearchPatient()
				.clickEdit()
				.clickSaveButton()
				.isAddButtonIsPresent());
	}

}
