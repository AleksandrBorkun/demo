package com.epam.tf.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by Dzmitry_Bets on 12/12/2016.
 */
public class MolecularGeneticDiagnosisTest extends BaseTest{


    private static final String SEARCH_REQUEST_SURNAME = "Иванов";
    private static final String DATE_OF_SEARCH = "07.11.2016";

    @Test(description = "test # 13-14-15")
    public void addMolecularGeneticDiagnosis() throws InterruptedException {
        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME)
                .applySearchRequest()
                .editPatientData()
                .goToMolecularGeneticDiagnose()
                .fillMolecularGeneticDiagnose(DATE_OF_SEARCH)
                .editMolecularGeneticButton()
                .clearAllFields()
                .fillMolecularGeneticDiagnose(DATE_OF_SEARCH)
                .deleteMolecularDiagnosis();
        Thread.sleep(50000);



    }



}
