package com.epam.tf.tests;

import com.epam.tf.steps.SearchByCatalogPageSteps;
import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.epam.tf.data.DataForCatalogSearch.*;

@Listeners(ScreenshotExecutor.class)
public class ShouldCheckSearchByCatalog extends BaseTest {
    private SearchByCatalogPageSteps searchByCatalogPageSteps;


    @Test()
    public void searchByCatalogDiagnosis() {
        searchByCatalogPageSteps = mainPageSteps.goToSearchByCatalog();
        searchByCatalogPageSteps
                .fillRequest(FIRST_RAW_DIAGNOSIS, SECOND_RAW_ALL_RECORDS, THIRD_RAW_CODMKB10, FOURTH_RAW_COMPLICE)
                .fillCatalogRequest(FIRST_LINE_CATALOG_LIPS, SECOND_LINE_CATALOG_LIPS, THIRD_LINE_CATALOG_LIPS);
        Assert.assertFalse(searchByCatalogPageSteps.checkResult());
    }

    @Test()
    public void searchByCatalogDiagnosisFromOKPO() {
        searchByCatalogPageSteps = mainPageSteps.goToSearchByCatalog();
        searchByCatalogPageSteps
                .fillRequest(FIRST_RAW_DIAGNOSIS, SECOND_RAW_ALL_RECORDS, THIRD_RAW_FROM_WHERE, FOURTH_RAW_COMPLICE)
                .fillCatalogRequest(THIRD_LINE_CATALOG_DISTRICT, THIRD_LINE_CATALOG_OKPO);
        Assert.assertFalse(searchByCatalogPageSteps.checkResult());
    }

    @Test
    public void oneCanSeeSearchResult(){
        Assert.assertFalse(
                mainPageSteps
                        .goToSearchByCatalog()
                        .fillFragmentField()
                        .fillFragmentAttributeField()
                        .fillRequisiteField()
                        .fillRequisiteAttributeField()
                        .fillDateField()
                        .clickSumbitButton()
                        .getSearchResult() == null);
    }

}
