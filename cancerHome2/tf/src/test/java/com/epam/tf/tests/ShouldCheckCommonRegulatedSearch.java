package com.epam.tf.tests;

import org.testng.annotations.Test;

public class ShouldCheckCommonRegulatedSearch extends BaseTest {

	private final String date = "02.2002";
	private final String dateTwo = "02.2000";
	private final String date3 = "2000";
	private final String date4 = "01.2000";
	private final String date5 = "01.2002";

	/// -------------------- ### 90 ### ------------------------- ///
	@Test
	public void test() {

		mainPageSteps.goToRegulatedSearchPageCallToHostital().fillCallFromFormAndClickSearch(date);

	}

	/// -------------------- ### 92 ### ------------------------- ///

	@Test
	public void test2() {

		mainPageSteps.goToHaveNoInformationAboutHealing().fillDateAndClickSearch(dateTwo);
	}

	/// -------------------- ### 93 ### ------------------------- ///

	@Test
	public void test3() {

		mainPageSteps.goToConsistingAtTheEndOfThePeriodpage().fillReportingFieldAndClickSearch(date3);

	}

	/// -------------------- ### 94 ### ------------------------- ///

	@Test
	public void test4() {

		mainPageSteps.goToPremilitarySearchPage().fillBirthDateAndClickSearch(date4);

	}

	/// -------------------- ### 95 ### ------------------------- ///

	@Test
	public void test5() {

		mainPageSteps.goToSecondNameMistakePage().fillRegistrationDateFromAndClickSearch(date5);

	}

}
