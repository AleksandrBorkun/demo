package com.epam.tf.tests;

import org.testng.Assert;

import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


/**
 * Created by Dzmitry_Bets on 11/21/2016.
 */
public class NotASpecificIGHDiagnosisTest extends BaseTest {

    private static final String SEARCH_REQUEST_SURNAME = "Иванов";
    private static final String DATE_OF_SEARCH = "01.11.2016";



    @Test(description = "test # 10-11-12")
    public void addIGHDiagnose() throws InterruptedException {
        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME)
                .applySearchRequest()
                .editPatientData()
                .goToIGHNotASpecificDiagnosis()
                .fillIGHDiagnose(DATE_OF_SEARCH)
                .editSpecificDiagnose()
                .fillIGHDiagnose(DATE_OF_SEARCH)
                .deleteSpecificDiagnose();
        Thread.sleep(50000);

    }
}
