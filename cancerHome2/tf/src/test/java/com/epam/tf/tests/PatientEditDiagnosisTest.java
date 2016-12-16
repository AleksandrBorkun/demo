package com.epam.tf.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Dzmitry_Bets on 09.12.2016.
 */
public class PatientEditDiagnosisTest extends BaseTest{
    @BeforeMethod
    public void setUp(){
        super.setUp();
        getPatientDAO().add(patients.get(2));
    }

    @AfterMethod
    public void tearDown(){
        super.tearDown();
        getPatientDAO().deleteByIdn(patients.get(2).getIdn());
    }

    @Test(description = "test # 5")
    public void editPatientTest() throws InterruptedException {
        mainPageSteps.applySearchRequestGlobal()
                .insertSurNameIntoSearchField(patients.get(2).getLastName())
                .applySearchRequest()
                .editPatientData()
                .editDiagnosisData()
                .goToEditor();

    }

    @Test(description = "test # 6")
    public void deleteNotAMainDiagnosis() throws InterruptedException {
        mainPageSteps.applySearchRequestGlobal()
                .insertSurNameIntoSearchField(patients.get(2).getLastName())
                .applySearchRequest()
                .editPatientData()
                .editDiagnosisData()
                .deleteNotAMainPatientDiagnosis();
    }
}
