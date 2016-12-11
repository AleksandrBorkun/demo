package com.epam.tf.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Aliaksei_Boltak on 11/21/2016.
 */
public class ShouldCheckGeneticResearchEditing extends BaseTest {

    private static final String SEARCH_REQUEST_SURNAME = "Иванов";
    private static final String DATE_OF_SEARCH = "07.11.2016";
    private static final String DATE_OF_SEARCH_AFTER_EDITING = "12.11.2016";

    @BeforeMethod
    public void addMolecularGeneticDiagnose(){
        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME)
                .applySearchRequest()
                .editPatient()
                .chooseMolecularGeneticDiagnose()
                .fillMolecularGeneticDiagnose(DATE_OF_SEARCH)
                .saveDiagnose()
        ;
    }

    @Test
    public void editingMolecularGeneticDiagnose()  {
        String result = mainPageSteps.editSpecificDiagnose(DATE_OF_SEARCH_AFTER_EDITING)
                .getDateOfSpecificDiagnose();
        Assert.assertTrue(result.contains(DATE_OF_SEARCH_AFTER_EDITING));
    }

    @AfterMethod
    public void deleteSpecificDiagnose(){
        mainPageSteps.deleteSpecificDiagnose()
        ;
    }


}
