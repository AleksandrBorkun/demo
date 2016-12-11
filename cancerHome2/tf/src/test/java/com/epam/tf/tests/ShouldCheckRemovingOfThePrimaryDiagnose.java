package com.epam.tf.tests;

import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ScreenshotExecutor.class)
public class ShouldCheckRemovingOfThePrimaryDiagnose extends BaseTest {

    private static final String SEARCH_REQUEST_SURNAME = "Иванов";
    private static final String SEARCH_EXPECTED_RESULT = "039. Удаление основного диагноза невозможно";


    @Test
    public void deletePrimaryDiagnoseTest()  {

     String result = mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME)
             .applySearchRequest()
             .editPatient()
             .deletePrimaryDiagnose()
             .confirmDeleteDiagnose()
             .getDeletePrimaryDiagnoseErrorMessage();

        Assert.assertEquals(result, SEARCH_EXPECTED_RESULT);

    }
}