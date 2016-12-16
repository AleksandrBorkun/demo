package com.epam.tf.tests;


import com.epam.tf.steps.PharmacologyRadiotherapyTreatmentPageSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShouldCheckPharmacologyRadiotherapyTreatment extends BaseTest {
    private final String SEARCH_REQUEST_SURNAME = "Картавый";
    private PharmacologyRadiotherapyTreatmentPageSteps pharmacologyRadiotherapyTreatmentPageSteps;

    @BeforeMethod
    public void setsUp() {
        getPatientDAO().deleteByIdn(patients.get(5).getIdn());
        getPatientDAO().add(patients.get(5));

        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME).applySearchRequest();

        pharmacologyRadiotherapyTreatmentPageSteps = mainPageSteps.editPatientData()
                .goToDateListOfDiagnoses()
                .goToDiagnosisOfFirstDateMenu()
                .goToTreatmentOfDiagnosisPharmacologyRadioTherapy();
        pharmacologyRadiotherapyTreatmentPageSteps.goToPharmacologyRadiotherapyTreatmentPage();
        pharmacologyRadiotherapyTreatmentPageSteps.addFirstPharmacologyRadiotherapyTreatment();
    }

    @Test( description = "test_library.xls: Test № 33 add Pharmacology Radiotherapy Treatment ")
    public void addPharmacologyRadiotherapyTreatmentOfDiagnosis() {

        Assert.assertTrue(pharmacologyRadiotherapyTreatmentPageSteps
                .isPharmacologyRadiotherapyTreatmentAdded());
    }
    @Test( description = "test_library.xls: Test № 34 edit Pharmacology Radiotherapy  Treatment ")
    public void editPharmacologyRadiotherapyTreatmentOfDiagnosis() {
        pharmacologyRadiotherapyTreatmentPageSteps.editFirstPharmacologyRadiotherapyTreatment();
        Assert.assertTrue(pharmacologyRadiotherapyTreatmentPageSteps.isPharmacologyRadiotherapyTreatmentEdit());

    }

    @Test( description = "test_library.xls: Test № 35 delete Pharmacology Radiotherapy Treatment ")
    public void deletePharmacologyRadiotherapyTreatmentOfDiagnosis() {
        pharmacologyRadiotherapyTreatmentPageSteps.deletePharmacologyRadiotherapyTreatment();
        Assert.assertTrue(pharmacologyRadiotherapyTreatmentPageSteps.isPharmacologyRadiotherapyTreatmentDeleted());

    }

}
