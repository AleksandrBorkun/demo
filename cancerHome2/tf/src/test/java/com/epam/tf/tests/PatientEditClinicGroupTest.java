package com.epam.tf.tests;

import com.epam.tf.steps.NewPatientPageSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Dzmitry_Bets on 09/12/2016.
 */
public class PatientEditClinicGroupTest extends BaseTest{
    NewPatientPageSteps newPatientPageSteps;
    @BeforeMethod
    public void setUp(){
        super.setUp();
        getPatientDAO().add(patients.get(1));
    }

    @AfterMethod
    public void tearDown(){
        super.tearDown();
        getPatientDAO().deleteByIdn(patients.get(1).getIdn());
    }

    @Test(description = "test # 16")
    public void editClinicGroupTest() throws InterruptedException {
        mainPageSteps.applySearchRequestGlobal()
                .insertSurNameIntoSearchField(patients.get(1).getLastName())
                .applySearchRequest()
                .editPatientData()
                .editClinicGroupData()
                .editClinicalGroup();

    }


    @Test(description = "test # 17")
    public void deleteClinicGroup() {
        mainPageSteps.applySearchRequestGlobal()
                .insertSurNameIntoSearchField(patients.get(1).getLastName())
                .applySearchRequest()
                .editPatientData()
                .editClinicGroupData()
                .deleteClinicalExaminationFirsMark();

        newPatientPageSteps = new NewPatientPageSteps(driver);

        Assert.assertTrue(newPatientPageSteps.isUpperTableContain("Отсутствуют сведения о клинической группе"));

    }

}
