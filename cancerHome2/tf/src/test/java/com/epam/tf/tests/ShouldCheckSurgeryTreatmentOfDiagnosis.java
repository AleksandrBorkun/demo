package com.epam.tf.tests;


import com.epam.tf.steps.SurgeryTreatmentOfDiagnosisPageSteps;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ShouldCheckSurgeryTreatmentOfDiagnosis extends BaseTest {
    private SurgeryTreatmentOfDiagnosisPageSteps surgeryTreatmentPageSteps;
    private final String SEARCH_REQUEST_SUR_NAME = "Картавый";
    private final String ADDED_OPERATION_CODE = "Расширенная ларингэктомия";//0104 - Расширенная ларингэктомия
    private final String MODIFIED_OPERATION_CODE = "Лобэктомия";///0405 - Лобэктомия


    @BeforeMethod
    public void setUp() {
        super.setUp();
        getPatientDAO().deleteByIdn(patients.get(5).getIdn());
        getPatientDAO().add(patients.get(5));

        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SUR_NAME).applySearchRequest();
        surgeryTreatmentPageSteps = mainPageSteps.editPatientData()
                .goToDateListOfDiagnoses()
                .goToDiagnosisOfFirstDateMenu()
                .goToTreatmentOfDiagnosisSurgery();
        surgeryTreatmentPageSteps.goToSurgeryTreatmentOfTreatmentMark();
        surgeryTreatmentPageSteps
                .addSurgeryTreatmentOfDiagnosis(ADDED_OPERATION_CODE);

    }

    @Test(priority = 1, description = "Test № 24 from test_library.xls")
    public void addSurgeryTreatmentOfDiagnosis() {

        Assert.assertTrue(surgeryTreatmentPageSteps
                .checkThatDataIsCorrect("0104 - Расширенная ларингэктомия"));
    }

    @Test(priority = 2, description = "Test № 25 from test_library.xls")
    public void editSurgeryTreatmentOfDiagnosis() {
        surgeryTreatmentPageSteps
                .addSurgeryTreatmentOfDiagnosis(MODIFIED_OPERATION_CODE);
        Assert.assertTrue(surgeryTreatmentPageSteps
                .checkThatDataIsCorrect("0405 - Лобэктомия"));
    }

    @Test(priority = 3, description = "Test № 26 from test_library.xls")
    public void deleteSurgeryTreatmentOfDiagnosis() {
        surgeryTreatmentPageSteps.deleteSurgeryTreatmentOfDiagnosis();
        Assert.assertTrue(surgeryTreatmentPageSteps.checkThatDataIsDeleted());
    }

    @AfterClass
    public void tearDown() {
        surgeryTreatmentPageSteps.deleteFirstTreatmentMark();
        super.tearDown();
    }
}
