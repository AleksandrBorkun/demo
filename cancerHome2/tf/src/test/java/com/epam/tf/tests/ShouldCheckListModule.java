package com.epam.tf.tests;




import com.epam.tf.steps.ListDescriptionPageSteps;
import com.epam.tf.steps.ListsPageSteps;
import com.epam.tf.steps.RegulatedSearchPageSteps;
import com.epam.tf.steps.SearchByCatalogPageSteps;
import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.epam.tf.data.DataForCatalogSearch.*;

@Listeners(ScreenshotExecutor.class)
public class ShouldCheckListModule extends BaseTest{
    private ListsPageSteps listsPageSteps;
    private ListDescriptionPageSteps listDescriptionPageSteps;
    private SearchByCatalogPageSteps searchByCatalogPageSteps;

    @BeforeClass
    public void cleanLists(){
        super.initData();
        super.setUp();
        listsPageSteps = mainPageSteps.goToListsPage();
        listsPageSteps.removeAllLists();
        super.tearDown();
    }


    @Test
    public void oneCanCreateEmptyList(){
        listsPageSteps = mainPageSteps.goToListsPage();
        listsPageSteps.createEmptyList();
        Assert.assertEquals(listsPageSteps.getActualListName(),listsPageSteps.getExpectedListName());
    }

    @Test
    public void oneCanRemoveList(){
        listsPageSteps = mainPageSteps.goToListsPage();
        listsPageSteps.createEmptyList();
        listsPageSteps.removeFirstList();
        Assert.assertEquals(listsPageSteps.getRemoveButtonsQuantity(),0);
    }

    @Test
    public void oneCanCreateListFromRegulatedSearch(){
        RegulatedSearchPageSteps regulatedSearchPageSteps = mainPageSteps.goToRegulatedPageDispensaryCall();
        listsPageSteps = regulatedSearchPageSteps.addNewList();
        Assert.assertEquals(listsPageSteps.getActualListName(),regulatedSearchPageSteps.getExpectedListName());
    }

    @Test
    public void oneCanCreateListFromInformationSearch(){
        searchByCatalogPageSteps = mainPageSteps.goToSearchByCatalog();
        searchByCatalogPageSteps
                .fillRequest(FIRST_RAW_DIAGNOSIS, SECOND_RAW_ALL_RECORDS, THIRD_RAW_CODMKB10, FOURTH_RAW_COMPLICE)
                .fillCatalogRequest(FIRST_LINE_CATALOG_LIPS, SECOND_LINE_CATALOG_LIPS, THIRD_LINE_CATALOG_LIPS);
        Assert.assertEquals(searchByCatalogPageSteps.saveResultInList().getActualListName(),searchByCatalogPageSteps.getExpectedListName());
    }


    @Test
    public void oneCanEditList(){
        RegulatedSearchPageSteps regulatedSearchPageSteps = mainPageSteps.goToRegulatedPageDispensaryCall();
        listsPageSteps = regulatedSearchPageSteps.addNewList();
        listDescriptionPageSteps = listsPageSteps.turnToListDescription();
        int usersQuantityBeforeRemoving = listDescriptionPageSteps.getPatientCount();
        listDescriptionPageSteps.removeFirstUser();
        Assert.assertEquals(listDescriptionPageSteps.getPatientCount(),usersQuantityBeforeRemoving-1);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        listsPageSteps = mainPageSteps.goToListsPage();
        listsPageSteps.removeAllLists();
        super.tearDown();
    }




}
