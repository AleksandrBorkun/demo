package com.epam.tf.tests;

import com.epam.tf.entity.Patient;
import com.epam.tf.exception.DAOException;
import com.epam.tf.steps.DiagnosisMetastasesMainPageSteps;
import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Aliaksei_Astashkevic on 12/5/2016.
 */
@Listeners(ScreenshotExecutor.class)
public class ShouldCheckRecurrencesAndMetastasesData extends BaseTest {
    private DiagnosisMetastasesMainPageSteps diagnosisMetastasesMainPageSteps;
    private Patient patient;

    @BeforeMethod
    public void setup() {
        patient = patients.get(3);
        patientDAO.deleteByIdn(patient.getIdn());
        patientDAO.add(patient);
        diagnosisMetastasesMainPageSteps = mainPageSteps.goToMetastasesInfoPage(patient)
                .fillValidMetastasesData();
    }


    @Test(description = "№39 - Adding information about relapses and metastases")
    public void addRelapsesAndMetastasesData() {
        diagnosisMetastasesMainPageSteps.validateAddingMetastasesData();
    }


    @Test(description = "№40 - Editing information about relapses and metastases")
    public void editRelapsesAndMetastasesData() {
        diagnosisMetastasesMainPageSteps.editMetastasesData()
                .validateEditingMetastasesData();
    }


    @Test(description = "№41 - Deleting information about relapses and metastases")
    public void deleteRelapsesAndMetastasesData() {
        diagnosisMetastasesMainPageSteps
                .deleteMetastasesData()
                .validateDeletingMetastasesData();
    }

    @AfterMethod
    public void teardown() throws DAOException {
        patientDAO.deleteByIdn(patient.getIdn());
    }
}
