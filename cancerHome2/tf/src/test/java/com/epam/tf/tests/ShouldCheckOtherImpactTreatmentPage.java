package com.epam.tf.tests;


import com.epam.tf.steps.OtherImpactTreatmentPageSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShouldCheckOtherImpactTreatmentPage extends BaseTest {
    private final String SEARCH_REQUEST_SURNAME = "Картавый";
    private OtherImpactTreatmentPageSteps otherImpactTreatmentPageSteps;

    @BeforeMethod
    public void setsUp() {
        getPatientDAO().deleteByIdn(patients.get(5).getIdn());
        getPatientDAO().add(patients.get(5));

        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME).applySearchRequest();

        otherImpactTreatmentPageSteps = mainPageSteps.editPatientData()
                .goToDateListOfDiagnoses()
                .goToDiagnosisOfFirstDateMenu()
                .goToTreatmentOfDiagnosisOtherImpact();
        otherImpactTreatmentPageSteps.goToOtherImpactTreatmentPage();
        otherImpactTreatmentPageSteps.addOtherImpactTreatment();

    }

    @Test( description = "test_library.xls: Test № 36 add Other Impact Treatment ")
    public void addPharmacologyRadiotherapyTreatmentOfDiagnosis() {

        Assert.assertTrue(otherImpactTreatmentPageSteps
                .isOtherImpactTreatmentAdded());
    }
    @Test( description = "test_library.xls: Test № 37 edit Other Impact Treatment ")
    public void editPharmacologyRadiotherapyTreatmentOfDiagnosis() {
        otherImpactTreatmentPageSteps.editOtherImpactTreatment();
        Assert.assertTrue(otherImpactTreatmentPageSteps.isOtherImpactTreatmentEdit());

    }

    @Test( description = "test_library.xls: Test № 38 delete Other Impact Treatment ")
    public void deletePharmacologyRadiotherapyTreatmentOfDiagnosis() {
        otherImpactTreatmentPageSteps.deleteOtherImpactTreatment();
        Assert.assertTrue(otherImpactTreatmentPageSteps.isOtherImpactTreatmentDeleted());

    }

}
