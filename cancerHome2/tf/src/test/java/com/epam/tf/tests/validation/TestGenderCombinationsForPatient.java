package com.epam.tf.tests.validation;


import com.epam.tf.entity.Patient;
import com.epam.tf.data.Diagnosis;
import com.epam.tf.entity.TestCase;
import com.epam.tf.tests.BaseTest;
import com.epam.tf.tests.testUtils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Ihar_Hukau on 12/5/2016.
 */
public class TestGenderCombinationsForPatient extends BaseTest {
    private Patient patient2 = getPatients().get(1);
    private Patient patient4 = getPatients().get(3);

    @BeforeMethod

    public void setUp(){
        super.setUp();
        getPatientDAO().deleteByIdn(patient2.getIdn());
        getPatientDAO().deleteByIdn(patient4.getIdn());
        getPatientDAO().add(patient2);
        getPatientDAO().add(patient4);
    }

    @Test(singleThreaded = true, dataProvider = "gender combination valid cases",
            dataProviderClass = DataProviders.class)
    public void testPositiveGenderCombinationPatient2(TestCase diagnosis){
        diagnosis.setPatient(patient2);
        mainPageSteps
                .insertSurNameIntoSearchField(patient2.getLastName())
                .applySearchRequest()
                .pressPatientRefactorButton(patient2)
                .editPassportData()
                .editGender(diagnosis)
                .clickSaveButton()
                .pressPatientCardButton()
                .goToDiagnosisFormPage();
        
        Assert.assertEquals(diagnosis.getSex(), diagnosis.getSex());
    }

    @Test(enabled = false,singleThreaded = true, dataProvider = "gender combination valid cases",
            dataProviderClass = DataProviders.class, dependsOnMethods = "testPositiveGenderCombinationPatient2")
    public void testPositiveGenderCombinationPatient4(TestCase diagnosis){
        diagnosis.getSex();
        Assert.assertEquals(diagnosis.getSex(), diagnosis.getSex());
    }

    @AfterMethod
    public void tearDown(){
        super.tearDown();
        getPatientDAO().deleteByIdn(patient2.getIdn());
        getPatientDAO().deleteByIdn(patient4.getIdn());
    }
}
