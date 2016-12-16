package com.epam.tf.tests;

import com.epam.tf.steps.DevicesRadiotherapyTreatmentPageSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ShouldCheckDevicesRadiotherapyTreatment extends  BaseTest{
    private final String SEARCH_REQUEST_SURNAME = "Картавый";
    private DevicesRadiotherapyTreatmentPageSteps devicesRadiotherapyTreatmentPageSteps;

    @BeforeMethod
    public void setsUp() {
        getPatientDAO().deleteByIdn(patients.get(5).getIdn());
        getPatientDAO().add(patients.get(5));

        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SURNAME).applySearchRequest();

        devicesRadiotherapyTreatmentPageSteps = mainPageSteps.editPatientData()
                .goToDateListOfDiagnoses()
                .goToDiagnosisOfFirstDateMenu()
                .goToTreatmentOfDiagnosisDevicesRadioTherapy();
        devicesRadiotherapyTreatmentPageSteps.goToDevicesRadiotherapyTreatmentPage();
        devicesRadiotherapyTreatmentPageSteps.createFirstDevicesRadiotherapyTreatment();
    }

    @Test( description = "test_library.xls: Test № 30 add Devices Radiotherapy Treatment ")
    public void addDevicesRadiotherapyTreatmentOfDiagnosis() {

        Assert.assertTrue(devicesRadiotherapyTreatmentPageSteps
                .isDevicesRadiotherapyCharacterAdded());
    }

    @Test( description = "test_library.xls: Test № 31 edit Devices Radiotherapy  Treatment ")
    public void editDevicesRadiotherapyTreatmentOfDiagnosis() {
        devicesRadiotherapyTreatmentPageSteps.editDevicesRadiotherapyTreatment();
      Assert.assertTrue(devicesRadiotherapyTreatmentPageSteps.isDevicesRadiotherapyCharacterEdited());

    }

    @Test( description = "test_library.xls: Test № 32 delete Devices Radiotherapy Treatment ")
    public void deleteDevicesRadiotherapyTreatmentOfDiagnosis() {
        devicesRadiotherapyTreatmentPageSteps.deleteDevicesRadiotherapyTreatment();
        Assert.assertTrue(devicesRadiotherapyTreatmentPageSteps.isDevicesRadiotherapyTreatmentDeleted());

    }
}
