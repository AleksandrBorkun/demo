package com.epam.tf.steps;


import com.epam.tf.pages.PatientCardPage;
import org.openqa.selenium.WebDriver;


public class PatientCardPageSteps extends AbstractSteps {

    private PatientCardPage patientCardPage;

    public PatientCardPageSteps(WebDriver driver) {
        super(driver);
        patientCardPage = new PatientCardPage(driver);
    }

    public PassportPartArchievePageSteps choosePassportPart() {
        patientCardPage.passportPartExpand();
        patientCardPage.clickArchieveButton();
        log.info("Choose passport part");
        return new PassportPartArchievePageSteps(driver);
    }

    public MarksOnClinicalExaminationPageSteps goToMarksOnClinicalExamination() {
        log.info("go to Marks on clinical examination");
        patientCardPage.clickMarksOnClinicalExamination();
        return new MarksOnClinicalExaminationPageSteps(driver);
    }

    public PatientCardPageSteps goToDateListOfDiagnoses() {
        log.info("go to list of diagnoses");
        patientCardPage.clickDiagnosisUnit();
        return new PatientCardPageSteps(driver);
    }

    public DiagnosisFormPageSteps goToDiagnosisForm(){
        patientCardPage.clickDiagnosisUnit();
        return new DiagnosisFormPageSteps(driver);
    }

    public PatientCardPageSteps goToDiagnosisOfFirstDateMenu() {
        log.info("go to menu of the first diagnosis date from DateListOfDiagnoses");
        patientCardPage.clickFirstDateOfDiagnosisUnit();
        return new PatientCardPageSteps(driver);
    }

    public SurgeryTreatmentOfDiagnosisPageSteps goToTreatmentOfDiagnosis() {
        log.info("go to the treatment of diagnosis");
        patientCardPage.goToDiagnosisTreatmentMainPage();
        return new SurgeryTreatmentOfDiagnosisPageSteps(driver);
    }

    public DiagnosisFormPageSteps goToDiagnosisFormPage(){
        patientCardPage.clickEditButton();
        return new DiagnosisFormPageSteps(driver);
    }

    public PatientEditPassportDataSteps editPassportData(){
        log.info("go to passport data list");
        patientCardPage.clickEditPassportData();
        return new PatientEditPassportDataSteps(driver);
    }

    public DiagnosisMetastasesMainPageSteps goToMetastasesOfDiagnosis(){
        log.info("go to relapses and metastases data");
        patientCardPage.goToMetastasesMainPage();
        return new DiagnosisMetastasesMainPageSteps(driver);
    }

}
