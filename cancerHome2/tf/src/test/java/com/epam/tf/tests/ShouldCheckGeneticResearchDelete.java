package com.epam.tf.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Aliaksei_Boltak on 11/21/2016.
 */
public class ShouldCheckGeneticResearchDelete extends BaseTest {

    private static final String SEARCH_REQUEST_SURNAME = "Иванов";
    private static final String DATE_OF_SEARCH = "07.11.2016";

    @BeforeMethod
    public void addMolecularGeneticDiagnose() {
         mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME)
                .applySearchRequest()
                .editPatient()
                .chooseMolecularGeneticDiagnose()
                .fillMolecularGeneticDiagnose(DATE_OF_SEARCH)
                .saveDiagnose();
    }

    @Test
    public void deleteMolecularGeneticDiagnose(){
        String result= mainPageSteps.deleteSpecificDiagnose().getDateOfNewResearch();
        Assert.assertTrue(result.equals(""));
    }

}
