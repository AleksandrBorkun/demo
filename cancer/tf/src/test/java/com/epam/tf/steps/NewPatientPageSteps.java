package com.epam.tf.steps;

import com.epam.tf.entity.Patient;
import com.epam.tf.entity.TestCase;
import com.epam.tf.pages.NewPatientPage;
import org.openqa.selenium.WebDriver;

public class NewPatientPageSteps extends AbstractSteps {

    private final NewPatientPage newPatientPage;


    public NewPatientPageSteps(WebDriver driver) {
        super(driver);
        newPatientPage = new NewPatientPage(driver);
    }

    public void fillPatientData(Patient patient) throws InterruptedException {
        log.info("Filling passport info");
        newPatientPage.fillIdentify(patient);
        log.info("Filling place of living");
        newPatientPage.fillPlaceOfLivingPart();
        log.info("Filling additional info");
        newPatientPage.fillAdditionalInfo();
        log.info("Click save changes");
        Thread.sleep(5000);
        newPatientPage.saveData();
    }

    public void fillingDiagnosisData(TestCase testCase) throws InterruptedException {
        log.info("Filling general diagnosis form");
        newPatientPage.fillGeneralDiagnosForm(testCase);
        log.info("Filling stages");
        newPatientPage.fillStages(testCase);
        log.info("Filling examination");
        newPatientPage.fillExamination(testCase);
        log.info("Click save changes");
        newPatientPage.saveData();
    }

    public void addClinicalGroup(String date){
        log.info("add clinical group");
        newPatientPage.addClinicalGroup(date);
        log.info("click save changes");
        newPatientPage.saveData();
    }

    public NewPatientPageSteps fillPlaceOfLivingPart(){
        log.info("Filling place of living part");
        newPatientPage.fillPlaceOfLivingPart();
        return this;
    }

//    public NewPatientPageSteps confirmChangingPlaceOfLivingData(){
//        log.info("Confirm changing place of living part");
//        newPatientPage.confirmChangingPlaceOfLivingData();
//        return this;
//    }

    public boolean isUpperTableContain(String personalNumber){
        return newPatientPage.isTableContein(personalNumber);
    }

}
