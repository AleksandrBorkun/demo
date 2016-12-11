package com.epam.tf.steps;

import com.epam.tf.entity.Patient;
import com.epam.tf.data.Diagnosis;
import com.epam.tf.pages.NewPatientPage;
import org.openqa.selenium.WebDriver;

public class NewPatientPageSteps extends AbstractSteps {

    private NewPatientPage newPatientPage;


    public NewPatientPageSteps(WebDriver driver) {
        super(driver);
        newPatientPage = new NewPatientPage(driver);
    }

    public void populatePatientData(Patient patient) throws InterruptedException {
        log.info("filling passport info");
        newPatientPage.populateIdentify(patient);
        log.info("filling place of living");
        newPatientPage.populatePlaceOfLiving();
        log.info("filling additional info");
        newPatientPage.populateAdditionalInfo();
        log.info("click save changes");
        Thread.sleep(5000);
        newPatientPage.saveData();
    }

    public void populateDiagnosData(Diagnosis diagnosis){
        log.info("filling general diagnosis form");
        newPatientPage.populateGeneralDiagnosForm(diagnosis);
        log.info("filling stages");
        newPatientPage.populateStages(diagnosis);
        log.info("filling examination");
        newPatientPage.populateExamination(diagnosis);
        log.info("click save changes");
        newPatientPage.saveData();
    }

    public void addClinicalGroup(String date){
        log.info("add clinical group");
        newPatientPage.addClinicalGroup(date);
        log.info("click save changes");
        newPatientPage.saveData();
    }

    public boolean isTableContain(String personalNumber){
        return newPatientPage.isTableContein(personalNumber);
    }

}
