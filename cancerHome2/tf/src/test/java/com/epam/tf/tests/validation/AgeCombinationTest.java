package com.epam.tf.tests.validation;

import com.epam.tf.entity.Patient;
import com.epam.tf.entity.TestCase;
import com.epam.tf.steps.DiagnosisEditPageSteps;
import com.epam.tf.tests.BaseTest;
import com.epam.tf.tests.testUtils.DataProviders;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Nikolay_Golubitsky on 12/8/2016.
 */
public class AgeCombinationTest extends BaseTest {
    @BeforeClass
    public void initClass(){
        super.initData();
    }

    @Test(dataProvider = "age combination valid", dataProviderClass = DataProviders.class)
    public void ageCombinationValid(TestCase testCase){
        Patient patient = testCase.getPatient();
        Patient basePatient = patients.get(0);
        basePatient.setPersonalNumber(patient.getPersonalNumber());
        basePatient.setFirstName(patient.getFirstName());
        basePatient.setLastName(patient.getLastName());
        basePatient.setPatrName(patient.getPatrName());
        basePatient.setBirthDay(patient.dateSwap());
        patientDAO.deleteByIdn(basePatient.getIdn());
        patientDAO.add(basePatient);
        DiagnosisEditPageSteps editPageSteps =
                mainPageSteps.insertSurNameIntoSearchField(basePatient.getLastName())
                .applySearchRequest().editFirstPatient().createNewDiagnosis()
                .fillDiagnosisData(testCase);
        String result = editPageSteps.saveResult();
        LOG.info(result);
        Assert.assertTrue("".equals(result));
    }
}
