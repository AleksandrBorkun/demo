package com.epam.tf.tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.epam.tf.utils.ScreenshotExecutor;

@Listeners(ScreenshotExecutor.class)
public class InformationSearchByDiagnos extends BaseTest {

	@Test
	public void startTest() {

		// InformationSearchPage informSearchPage = new
		// InformationSearchPage(driver);

		Assert.assertFalse(mainPageSteps.goToInformationSerchPage().fillFragmentField().fillFragmentAttributeField()
				.fillRequisiteField().fillRequisiteAttributeField().fillDateField().clickSumbitButton()
				.getSearchResult() == null);
	}
}
