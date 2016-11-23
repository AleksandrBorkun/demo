package com.epam.tf.tests;

import com.epam.tf.steps.MarksOnClinicalExaminationPageSteps;
import com.epam.tf.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class ShouldCheckEditionOfMarkOnClinicalExamination extends BaseTest {
    private MarksOnClinicalExaminationPageSteps marksOnClinicalExaminationPageSteps;
    private final String SEARCH_REQUEST_SUR_NAME = "Галайкова";
    private ArrayList<String> beforeTestMarkData;
    private ArrayList<String> afterTestMarkData;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SUR_NAME).applySearchRequest();
        marksOnClinicalExaminationPageSteps = mainPageSteps.editPatientData().goToMarksOnClinicalExamination();
    }

    @Test(description = "test № 19 from test library")
    public void EditMarkOnClinicalExamination() {
        beforeTestMarkData = marksOnClinicalExaminationPageSteps.getDataOfFirstClinicalExaminationMark();
        marksOnClinicalExaminationPageSteps.editClinicalExaminationFirsMark("3");
        afterTestMarkData = marksOnClinicalExaminationPageSteps.getDataOfFirstClinicalExaminationMark();
        Assert.assertFalse(beforeTestMarkData.containsAll(afterTestMarkData));
    }

    @AfterMethod
    public void tearDown() {
        marksOnClinicalExaminationPageSteps.editClinicalExaminationFirsMark("1");
        super.tearDown();
    }
}
