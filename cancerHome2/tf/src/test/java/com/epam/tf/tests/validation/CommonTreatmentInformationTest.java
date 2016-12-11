package com.epam.tf.tests.validation;

import com.epam.tf.entity.Patient;


import com.epam.tf.entity.TestCase;
import com.epam.tf.data.parser.TestCasesParserFirstSheet;
import com.epam.tf.steps.DiagnosisEditPageSteps;
import com.epam.tf.tests.BaseTest;
import com.epam.tf.tests.testUtils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Nikolay_Golubitsky on 12/5/2016.
 */
public class CommonTreatmentInformationTest extends BaseTest {

    private final static String TITLE = "Карточка пациента - Cancer Register";
    private Patient patient;
    private List<TestCase> testCases;

    @BeforeClass
    public void setUpCases(){
        TestCasesParserFirstSheet parser = new TestCasesParserFirstSheet();
        testCases = parser.getTestCases();

    }

    @BeforeMethod
    public void setUp(){
        super.setUp();
        patient = patients.get(0);
        patientDAO.add(patient);
    }

    @Test(dataProvider = "common info", dataProviderClass = DataProviders.class)
    public void checkCases(TestCase testCase) throws InterruptedException {
        LOG.info("----------------------- Test № " + testCase.getTestCaseNumber()
                + " -----------------------" );
        mainPageSteps.insertSurNameIntoSearchField(patient.getLastName())
                .applySearchRequest().pressFirstRefactorButton().editPassportData().editGenderAndState(testCase).save();
        DiagnosisEditPageSteps editPageSteps =
                mainPageSteps.insertSurNameIntoSearchField(patient.getLastName())
                .applySearchRequest()
                .pressFirstRefactorButton()
                .goToDiagnosisFormPage().goToEditor()
                        .fillDiagnosisDataWithoutStringsCheck(testCase);
        String result = editPageSteps.saveResult();
        String testCaseResult = testCase.getResult().split(" ")[1];
        LOG.info(testCaseResult + " ----- ожидание");
        LOG.info(result + " ----- реальность");
        Assert.assertTrue(result.contains(testCaseResult));
    }

    @Test(enabled = false, dataProvider = "common info valid", dataProviderClass = DataProviders.class)
    public void checkValidCases(TestCase testCase) throws InterruptedException {
        mainPageSteps.insertSurNameIntoSearchField(patient.getLastName())
                .applySearchRequest()
                .pressFirstRefactorButton()
                .goToDiagnosisFormPage()
                .goToEditor()
                .fillDiagnosisData(testCase);
        Assert.assertTrue(driver.getTitle().equals(TITLE));

    }

    @Test(enabled = false, dataProvider = "common info", dataProviderClass = DataProviders.class)
    public void checkCasesWithNewDiagnosis(TestCase testCase) throws InterruptedException {
        DiagnosisEditPageSteps editPageSteps =
                mainPageSteps.insertSurNameIntoSearchField(patient.getLastName())
                        .applySearchRequest().pressFirstRefactorButton().goToDiagnosisFormPage().createNewDiagnosis()
                        .fillDiagnosisDataWithoutStringsCheck(testCase);
        String result = editPageSteps.saveResult();
        String testCaseResult = testCase.getResult().split(" ")[1];
        LOG.info(testCaseResult + " ----- ожидание");
        LOG.info(result + " ----- реальность");
        Assert.assertTrue(result.contains(testCaseResult));
    }

    @AfterMethod
    public void cleanUp(){
        patientDAO.deleteByIdn(patient.getIdn());
    }
}

