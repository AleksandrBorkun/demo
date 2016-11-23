package com.epam.tf.tests;

import com.epam.tf.steps.MarksOnClinicalExaminationPageSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Test can not be started, because bug is not fixed
 * (when you remove the clinical examination mark
 * is removed the patient)
 */
@Test(enabled = false)
public class ShouldCheckAdditionAndDeletionOfTheNewMarksOnClinicalExamination extends BaseTest {
    private MarksOnClinicalExaminationPageSteps marksOnClinicalExaminationPageSteps;
    private final String SEARCH_REQUEST_SUR_NAME = "Галайкова";
    private int beforeTestMarksCount;
    private int afterTestMarksCount;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SUR_NAME).applySearchRequest();
        marksOnClinicalExaminationPageSteps = mainPageSteps.editPatientData().goToMarksOnClinicalExamination();
        beforeTestMarksCount = marksOnClinicalExaminationPageSteps.getCountOfClinicalExaminationMarks();
    }

    @Test(description = "Test № 18 from test_library.xls")
    public void createClinicalExaminationMark() {
        marksOnClinicalExaminationPageSteps.createNewClinicalExaminationWithCurrentDate();
        afterTestMarksCount = marksOnClinicalExaminationPageSteps.getCountOfClinicalExaminationMarks();
        Assert.assertTrue(beforeTestMarksCount < afterTestMarksCount);
    }

    @Test(dependsOnMethods = "createClinicalExaminationMark", description = "Test № 20 from test_library.xls")
    public void deleteClinicalExaminationMark() {
        beforeTestMarksCount = marksOnClinicalExaminationPageSteps.getCountOfClinicalExaminationMarks();
        marksOnClinicalExaminationPageSteps.deleteClinicalExaminationFirsMark();
        afterTestMarksCount = marksOnClinicalExaminationPageSteps.getCountOfClinicalExaminationMarks();
        Assert.assertTrue(beforeTestMarksCount > afterTestMarksCount);
    }

}
