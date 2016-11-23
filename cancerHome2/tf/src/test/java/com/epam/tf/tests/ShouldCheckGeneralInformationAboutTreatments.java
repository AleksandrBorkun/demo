package com.epam.tf.tests;

import com.epam.tf.steps.DiagnosisTreatmentMainPageSteps;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;


public class ShouldCheckGeneralInformationAboutTreatments extends BaseTest {
    private DiagnosisTreatmentMainPageSteps diagnosisTreatmentMainPageSteps;
    private final String SEARCH_REQUEST_SUR_NAME = "Нарейко";
    private int beforeTestMarksCount;
    private int afterTestMarksCount;
    private ArrayList<String> beforeTestMarkData;
    private ArrayList<String> afterTestMarkData;

    @BeforeClass
    public void setUp() {
        super.setUp();
        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SUR_NAME).applySearchRequest();
        diagnosisTreatmentMainPageSteps = mainPageSteps.editPatientData()
                .goToDateListOfDiagnoses()
                .goToDiagnosisOfFirstDateMenu()
                .goToTreatmentOfDiagnosis();
    }

    @Test(priority = 1, description = "Test № 21 from test_library.xls")
    public void addNewDiagnosisTreatment() {
        beforeTestMarksCount = diagnosisTreatmentMainPageSteps.getCountOfTreatmentMarks();
        diagnosisTreatmentMainPageSteps.addDiagnosisTreatment();
        afterTestMarksCount = diagnosisTreatmentMainPageSteps.getCountOfTreatmentMarks();
        Assert.assertTrue(beforeTestMarksCount < afterTestMarksCount);
    }

    @Test(priority = 2, description = "Test № 22 from test_library.xls")
    public void editDiagnosisTreatment() {
        beforeTestMarkData = diagnosisTreatmentMainPageSteps.getDataOfFirstTreatmentMark();
        diagnosisTreatmentMainPageSteps.editFirstDiagnosisTreatment();
        afterTestMarkData = diagnosisTreatmentMainPageSteps.getDataOfFirstTreatmentMark();
        Assert.assertFalse(beforeTestMarkData.containsAll(afterTestMarkData));
    }

    @Test(priority = 3, description = "Test № 23 from test_library.xls")
    public void deleteDiagnosisTreatmentMark() {
        beforeTestMarksCount = diagnosisTreatmentMainPageSteps.getCountOfTreatmentMarks();
        diagnosisTreatmentMainPageSteps.deleteFirstTreatmentMark();
        afterTestMarksCount = diagnosisTreatmentMainPageSteps.getCountOfTreatmentMarks();
        Assert.assertTrue(beforeTestMarksCount > afterTestMarksCount);
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
