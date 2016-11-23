package com.epam.tf.steps;

import com.epam.tf.pages.SurgeryTreatmentOfDiagnosisPage;
import org.openqa.selenium.WebDriver;


public class SurgeryTreatmentOfDiagnosisPageSteps extends DiagnosisTreatmentMainPageSteps {
    private SurgeryTreatmentOfDiagnosisPage surgeryTreatmentOfDiagnosisPage;

    public SurgeryTreatmentOfDiagnosisPageSteps(WebDriver driver) {
        super(driver);
        surgeryTreatmentOfDiagnosisPage = new SurgeryTreatmentOfDiagnosisPage(driver);
    }

    public void addSurgeryTreatmentOfDiagnosis(String operationCode) {
        log.info("add Surgery Treatment Of Diagnosis for first treatment mark");
        surgeryTreatmentOfDiagnosisPage.addSurgeryTreatmentOfDiagnosis(operationCode);
    }

    public void deleteSurgeryTreatmentOfDiagnosis() {
        log.info("delete Surgery Treatment Of Diagnosis");
        surgeryTreatmentOfDiagnosisPage.deleteSurgeryTreatmentOfDiagnosis();
    }

    public boolean checkThatDataIsCorrect(String operationCode) {
        log.info("check that data is correct");
       return surgeryTreatmentOfDiagnosisPage.isDataCorrect(operationCode);
    }

    public boolean checkThatDataIsDeleted() {
        log.info("check that data is deleted");
       return surgeryTreatmentOfDiagnosisPage.isDataDeleted();
    }



}
