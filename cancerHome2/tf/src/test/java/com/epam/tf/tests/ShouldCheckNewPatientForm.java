package com.epam.tf.tests;

import com.epam.tf.steps.NewPatientPageSteps;
import com.epam.tf.utils.ScreenshotExecutor;
import com.epam.tf.utils.ThreadSleep;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotExecutor.class)
public class ShouldCheckNewPatientForm extends BaseTest{
    private NewPatientPageSteps newPatientPageSteps;
    private final String DIAGNOSIS_DATE = "06.05.2005";

    @Test(enabled = false)
    public void oneCanAddNewPatient(){
        newPatientPageSteps = mainPageSteps.goToNewPatientForm();
        newPatientPageSteps.populatePatientData(passportData, dispensaryData);
        newPatientPageSteps.populateDiagnosData(diagnosisMap.get(DIAGNOSIS_DATE));
    }


}
