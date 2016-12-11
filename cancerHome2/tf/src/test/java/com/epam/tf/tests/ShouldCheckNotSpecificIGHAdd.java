package com.epam.tf.tests;

import org.testng.Assert;

import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


/**
 * Created by Aliaksei_Boltak on 11/21/2016.
 */
public class ShouldCheckNotSpecificIGHAdd extends BaseTest {

    private static final String SEARCH_REQUEST_SURNAME = "Иванов";
    private static final String DATE_OF_SEARCH = "01.11.2016";



    @Test
    public void addIGHDiagnose()  {
        String result= mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME)
                .applySearchRequest()
                .editPatient()
                .chooseIGHDiagnose()
                .fillIGHDiagnose(DATE_OF_SEARCH)
                .saveDiagnose()
                .getDateOfSpecificDiagnose();
        Assert.assertTrue(result.contains(DATE_OF_SEARCH));
    }

    @AfterMethod
    public void deleteIGHDiagnose(){
        mainPageSteps.deleteSpecificDiagnose()
        ;
    }

}
