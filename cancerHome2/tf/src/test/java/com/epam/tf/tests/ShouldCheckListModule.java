package com.epam.tf.tests;

import com.epam.tf.steps.ListDescriptionPageSteps;
import com.epam.tf.steps.ListsPageSteps;
import com.epam.tf.steps.RegulatedSearchPageSteps;
import com.epam.tf.steps.SearchByCatalogPageSteps;
import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ScreenshotExecutor.class)
public class ShouldCheckListModule extends BaseTest {
	private ListsPageSteps listsPageSteps;
	private ListDescriptionPageSteps listDescriptionPageSteps;
	private SearchByCatalogPageSteps searchByCatalogPageSteps;

	@BeforeClass
	public void cleanLists() {
		super.initData();
		super.setUp();
		listsPageSteps = mainPageSteps.goToListsPage();
		listsPageSteps.removeAllLists();
		super.tearDown();
	}

	
	@Test(description = "Test № 71 Create an empty list", enabled = true)
	public void oneCanCreateEmptyList() throws InterruptedException {
		listsPageSteps = mainPageSteps.goToListsPage();
		listsPageSteps.createEmptyList();
		Assert.assertEquals(listsPageSteps.getActualListName(), listsPageSteps.getExpectedListName());

	}

	@Test(description = "Test № 72 Edit the list of parameters", enabled = true)
	public void editListParameters() throws InterruptedException {
		listsPageSteps = mainPageSteps.goToListsPage();
		listsPageSteps.createEmptyList();
		ListDescriptionPageSteps listDescriptionPageSteps = listsPageSteps.editOneNoteList();
		listDescriptionPageSteps.renameNameList();
		Assert.assertEquals(listDescriptionPageSteps.getActualListName(),listDescriptionPageSteps.getExpectedListName());

	}

	@Test(description = "Test № 73 Deleting records from a list", enabled = true)
	public void oneCanEditList() throws InterruptedException {
		RegulatedSearchPageSteps regulatedSearchPageSteps = mainPageSteps.goToRegulatedPageDispensaryCall();
		listsPageSteps = regulatedSearchPageSteps.addNewList();
		listDescriptionPageSteps = listsPageSteps.turnToListDescription();
		int usersQuantityBeforeRemoving = listDescriptionPageSteps.getPatientCount();
		listDescriptionPageSteps.removeFirstUser();
		Assert.assertEquals(listDescriptionPageSteps.getPatientCount(), usersQuantityBeforeRemoving - 1);
	}

	
	
	@Test(description = "Test № 74 Adding notes to list", enabled = true)
	public void addingNotesList() {

		listsPageSteps = mainPageSteps.goToListsPage();
		listsPageSteps.createEmptyList();
		listsPageSteps.goToMainPage();
		RegulatedSearchPageSteps regulatedSearchPageSteps = mainPageSteps.goToRegulatedPageDispensaryCall();
		listsPageSteps = regulatedSearchPageSteps.addNewList();
		listDescriptionPageSteps = listsPageSteps.turnToListDescription();
		listDescriptionPageSteps.addingNotesToAnotherList();
		listDescriptionPageSteps.getFirstListNameFromDropDownMenu();
		listDescriptionPageSteps.saveChangesInList();
		Assert.assertEquals(listDescriptionPageSteps.getActualNuberOfNotesInMessage(),
				"В существующий список добавлено 1 записей");
		listDescriptionPageSteps.closeActualPopUpWindowNuberOfNotesInMessage();

	}

	@Test(description = "Test № 75 Remove List", enabled = true)
	public void oneCanRemoveList() {
		listsPageSteps = mainPageSteps.goToListsPage();
		listsPageSteps.createEmptyList();
		listsPageSteps.removeFirstList();
		Assert.assertEquals(listsPageSteps.getRemoveButtonsQuantity(), 0);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		listsPageSteps = mainPageSteps.goToListsPage();
		listsPageSteps.removeAllLists();
		super.tearDown();
	}

}
