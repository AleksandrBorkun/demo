package com.epam.tf.tests;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Aliaksei_Boltak on 11/21/2016.
 */
public class ShouldCheckNotSpecificIGHEditing extends BaseTest{

    private static final String SEARCH_REQUEST_SURNAME = "Иванов";
    private static final String DATE_OF_SEARCH = "01.11.2016";
    private static final String DATE_OF_SEARCH_AFTER_EDITING = "11.11.2016";

    @BeforeMethod
    public void addIGHDiagnose(){
        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME)
                .applySearchRequest()
                .editPatient()
                .chooseIGHDiagnose()
                .fillIGHDiagnose(DATE_OF_SEARCH)
                .saveDiagnose()
        ;
    }

    @Test
    public void editingIGHDiagnose()  {
        String result = mainPageSteps.editSpecificDiagnose(DATE_OF_SEARCH_AFTER_EDITING)
                .getDateOfSpecificDiagnose();
        Assert.assertTrue(result.contains(DATE_OF_SEARCH_AFTER_EDITING));
    }

    @AfterMethod
    public void deleteIGHDiagnose(){
        mainPageSteps.deleteSpecificDiagnose()
        ;
    }
}
