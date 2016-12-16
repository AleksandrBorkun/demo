package com.epam.tf.tests;
import com.epam.tf.data.parser.TestCasesParserTreatmentInfo;
import com.epam.tf.entity.Patient;
import com.epam.tf.entity.TestCase;
import com.epam.tf.steps.NewPatientPageSteps;
import com.epam.tf.tests.BaseTest;
import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Dzmitry_Bets on 12/5/2016.
 */


@Listeners(ScreenshotExecutor.class)
public class AddANewPatientWithOtherDataTest extends BaseTest {

    TestCasesParserTreatmentInfo parse = new TestCasesParserTreatmentInfo();


    @DataProvider
    public Object[][] setPatient(){
        return new Object[][]{
                {patients.get(0),parse.getTestCases().get(0)}
        };
    }

    @Test(description = "Test # 1-2-3", dataProvider = "setPatient")
    public void addNewPatientWithPassportData(Patient patient, TestCase testData) throws InterruptedException {

        //add user (data taken from excel)
        mainPageSteps.goToNewPatientForm().populatePatientData(patient);

        NewPatientPageSteps newPatientPageSteps = new NewPatientPageSteps(driver);

        Assert.assertTrue(newPatientPageSteps.isUpperTableContain(patient.getPersonalNumber()));

        newPatientPageSteps.populateDiagnosData(testData);

        newPatientPageSteps.addClinicalGroup("11122016");
    }
}
