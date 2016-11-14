package com.epam.tf.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.tf.utils.ScreenshotExecutor;

@Listeners(ScreenshotExecutor.class)
public class SearchPatientForthStage extends BaseTest {

	@Test
	public void searchPatientForthStageTest() {

		mainPageSteps.goToSearchPatientForthStage().positiveSearchPatient().clickEdit();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
