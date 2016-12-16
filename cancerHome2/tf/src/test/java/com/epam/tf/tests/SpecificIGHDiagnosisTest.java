package com.epam.tf.tests;

import org.testng.annotations.Test;

/**
 * Created by Dzmitry_Bets on 12/13/2016.
 */
public class SpecificIGHDiagnosisTest extends BaseTest{

    private static final String SEARCH_REQUEST_SURNAME = "Иванов";
    private static final String DATE_OF_SEARCH = "01.11.2016";

    @Test(description = "test # 7-8-9")
    public void addIGHDiagnose() throws InterruptedException {
        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME)
                .applySearchRequest()
                .editPatientData()
                .goToSpecificIGHDiagnosis()
                .fillIGHDiagnose(DATE_OF_SEARCH)
                .editIGHDiagnosis()
                .fillIGHDiagnose("10102016")
                .deleteIGHDiagnosis();

        Thread.sleep(50000);

    }
}
