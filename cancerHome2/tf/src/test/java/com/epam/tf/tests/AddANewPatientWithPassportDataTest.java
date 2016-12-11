package com.epam.tf.tests;
import com.epam.tf.entity.Patient;
import com.epam.tf.steps.NewPatientPageSteps;
import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Dzmitry_Bets on 12/5/2016.
 */

//Test # 1

@Listeners(ScreenshotExecutor.class)
public class AddANewPatientWithPassportDataTest extends BaseTest{
    private NewPatientPageSteps newPatientPageSteps;


    @DataProvider
    public Object[][] setPatient(){
        return new Object[][]{
                {patients.get(0)},
                {patients.get(1)},
                {patients.get(2)},
                {patients.get(3)}
        };
    }

    @Test(dataProvider = "setPatient")
    public void oneCanAddNewPatient(Patient patient) throws InterruptedException {

        //add user (data taken from excel)
        mainPageSteps.goToNewPatientForm().populatePatientData(patient);

        Assert.assertTrue(newPatientPageSteps.isTableContain(patient.getPersonalNumber()));

    }
}
