package com.epam.tf.tests;


import com.epam.tf.steps.ChemotherapyTreatmentPageSteps;
import com.epam.tf.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ShouldCheckChemotherapyTreatment extends BaseTest {

    private final String SEARCH_REQUEST_SURNAME = "Картавый";
    private ChemotherapyTreatmentPageSteps chemotherapyTreatmentPageSteps;

    @BeforeMethod
    public void setsUp() {
        getPatientDAO().deleteByIdn(patients.get(5).getIdn());
        getPatientDAO().add(patients.get(5));

        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME).applySearchRequest();

        chemotherapyTreatmentPageSteps = mainPageSteps.editPatientData()
                .goToDateListOfDiagnoses()
                .goToDiagnosisOfFirstDateMenu()
                .goToTreatmentOfDiagnosisChemotherapy();
        chemotherapyTreatmentPageSteps.goToChemotherapyTreatmentPage();
        chemotherapyTreatmentPageSteps
                .createFirstChemotherapyOfDiagnosis();
    }

    @Test( description = "test_library.xls: Test № 27 add Chemotherapy Treatment ")
    public void addChemotherapyTreatmentOfDiagnosis() {

        Assert.assertTrue(chemotherapyTreatmentPageSteps
                .isChemotherapyDrugAdded());
    }

    @Test( description = "test_library.xls: Test № 28 edit Chemotherapy Treatment ")
    public void editChemotherapyTreatmentOfDiagnosis() {
        chemotherapyTreatmentPageSteps.editChemotherapyOfDiagnosis();
        Assert.assertTrue(chemotherapyTreatmentPageSteps.isChemotherapyTreatmentEdited());

    }

    @Test( description = "test_library.xls: Test № 29 delete Chemotherapy Treatment ")
    public void deleteChemotherapyTreatmentOfDiagnosis() {
        chemotherapyTreatmentPageSteps.deleteChemotherapyTreatment();
        Assert.assertTrue(chemotherapyTreatmentPageSteps.isChemotherapyTreatmentDeleted());

    }
}
