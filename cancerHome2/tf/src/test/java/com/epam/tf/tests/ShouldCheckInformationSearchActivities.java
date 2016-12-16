package com.epam.tf.tests;

import com.epam.tf.steps.ListsPageSteps;
import com.epam.tf.steps.RegulatedSearchPageSteps;
import com.epam.tf.steps.SearchByCatalogPageSteps;
import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.epam.tf.data.DataForCatalogSearch.*;

@Listeners(ScreenshotExecutor.class)

public class ShouldCheckInformationSearchActivities extends BaseTest {
	private ListsPageSteps listsPageSteps;
	private SearchByCatalogPageSteps searchByCatalogPageSteps;

	@BeforeClass
	public void cleanLists() {
		super.initData();
		super.setUp();
		listsPageSteps = mainPageSteps.goToListsPage();
		listsPageSteps.removeAllLists();
		super.tearDown();
	}

	@Test(description = "Test № 76 Create a list From Information Search", enabled = true)
	public void oneCanCreateListFromInformationSearch() {
		searchByCatalogPageSteps = mainPageSteps.goToSearchByCatalog();
		searchByCatalogPageSteps
				.fillRequest(FIRST_RAW_DIAGNOSIS, SECOND_RAW_ALL_RECORDS, THIRD_RAW_CODMKB10, FOURTH_RAW_COMPLICE)
				.fillCatalogRequest(FIRST_LINE_CATALOG_LIPS, SECOND_LINE_CATALOG_LIPS, THIRD_LINE_CATALOG_LIPS);
		Assert.assertEquals(searchByCatalogPageSteps.saveResultInList().getActualListName(),
				searchByCatalogPageSteps.getExpectedListName());
	}

	@Test(description = "Test № 77 Creating a simple list of the regulated node search Call the clinic", enabled = true)
	public void oneCanCreateListFromRegulatedSearch() {
		RegulatedSearchPageSteps regulatedSearchPageSteps = mainPageSteps.goToRegulatedPageDispensaryCall();
		listsPageSteps = regulatedSearchPageSteps.addNewList();
		Assert.assertEquals(listsPageSteps.getActualListName(), regulatedSearchPageSteps.getExpectedListName());
	}

	@Test(description = "Test № 78 General check for the mandatory field passport part", enabled = true)
	public void generalCheckFieldPassportPart() {
		searchByCatalogPageSteps = mainPageSteps.goToSearchByCatalog();
		searchByCatalogPageSteps.fillRequest(FIRST_RAW_PASSPORT, THIRD_RAW_SURNAME, FOURTH_RAW_PASSPORT_COMPLICE);
		searchByCatalogPageSteps.setDateField(FIVETH_RAW_PASSPORT_COMPLICE);
		searchByCatalogPageSteps.clickSumbitButton();
		Assert.assertTrue(searchByCatalogPageSteps.checkResultsPresent());
	}

	@Test(description = "Test № 79 General check for the mandatory field Diagnosis", enabled = true)
	public void generalCheckFieldDiagnosis() {
		searchByCatalogPageSteps = mainPageSteps.goToSearchByCatalog();
		searchByCatalogPageSteps.fillRequest(FIRST_RAW_OVERWIEW_OF_DIAGNOSIS,
				SECOND_RAW_ALL_RECORDS_OVERWIEW_OF_DIAGNOSIS, THIRD_RAW_START_DATE_OF_DIAGNOSIS,
				FOURTH_RAW_OF_DIAGNOSIS);
		searchByCatalogPageSteps.setDateField(FIFTH_ADDITIONAL_COMPLICE_OF_DIAGNOSIS);
		searchByCatalogPageSteps.clickSumbitButton();
		Assert.assertTrue(searchByCatalogPageSteps.checkResultsPresent());
	}

	@Test(description = "Test № 80 General check for mandatory field Overview of treatment", enabled = true)
	public void generalCheckFieldOverviewOfTreatment() {
		searchByCatalogPageSteps = mainPageSteps.goToSearchByCatalog();
		searchByCatalogPageSteps.fillRequest(FIRST_RAW_OVERWIEW_OF_TREATMENT,
				SECOND_RAW_ALL_RECORDS_OVERWIEW_OF_TREATMENT, THIRD_RAW_START_DATE_OF_TREATMENT,
				FOURTH_RAW_COMPLICE_OF_TREATMENT);
		searchByCatalogPageSteps.fillRequestFifthRawData();
		searchByCatalogPageSteps.clickSumbitButton();
		Assert.assertTrue(searchByCatalogPageSteps.checkResultsPresent());
	}

	@Test(description = "Test № 81 General check for mandatory field of Clinical group", enabled = true)
	public void generalCheckFieldClinicalGroup() {
		searchByCatalogPageSteps = mainPageSteps.goToSearchByCatalog();
		searchByCatalogPageSteps.fillRequest(FIRST_RAW_CLINICAL_GROUP, SECOND_RAW_ALL_RECORDS_CLINICAL_GROUP,
				THIRD_RAW_START_CLINICAL_GROUPT, FOURTH_RAW_CLINICAL_GROUP);
		searchByCatalogPageSteps.setDateField(FIFTH_ADDITIONAL_RAW_CLINICAL_GROUP);
		searchByCatalogPageSteps.clickSumbitButton();
		Assert.assertTrue(searchByCatalogPageSteps.checkResultsPresent());

	}

	@Test(description = "Test № 82 General check for mandatory General check for the "
			+ "mandatory field Last contact", enabled = true)
	public void generalCheckFieldLastContact() {
		searchByCatalogPageSteps = mainPageSteps.goToSearchByCatalog();
		searchByCatalogPageSteps.fillRequest(FIRST_RAW_LAST_CONTACT, SECOND_RAW_ALL_RECORDS_LAST_CONTACT,
				THIRD_RAW_START_LAST_CONTACT, FOURTH_RAW_LAST_CONTACT);
		searchByCatalogPageSteps.setDateField(FIFTH_ADDITIONAL_RAW_LAST_CONTACT);
		searchByCatalogPageSteps.clickSumbitButton();
		Assert.assertTrue(searchByCatalogPageSteps.checkResultsPresent());
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		listsPageSteps = mainPageSteps.goToListsPage();
		listsPageSteps.removeAllLists();
		super.tearDown();
	}

}
