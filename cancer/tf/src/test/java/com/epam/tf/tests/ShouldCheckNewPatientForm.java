package com.epam.tf.tests;

import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotExecutor.class)
public class ShouldCheckNewPatientForm extends BaseTest{

    @Test(enabled = false)
    public void oneCanAddNewPatient(){
        mainPageSteps.goToNewPatientForm()
                .populatePatientData(passportData, dispensaryData);
    }


}
