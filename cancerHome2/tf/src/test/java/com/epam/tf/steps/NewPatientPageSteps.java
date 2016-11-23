package com.epam.tf.steps;

import com.epam.tf.data.Diagnosis;
import com.epam.tf.data.DispensaryData;
import com.epam.tf.data.PassportData;
import com.epam.tf.pages.NewPatientPage;
import org.openqa.selenium.WebDriver;

public class NewPatientPageSteps extends AbstractSteps {

    private NewPatientPage newPatientPage;

    public NewPatientPageSteps(WebDriver driver) {
        super(driver);
        newPatientPage = new NewPatientPage(driver);
    }

    public void populatePatientData(PassportData passportData, DispensaryData dispensaryData) {
        log.info("filling passport info");
        newPatientPage.populateIdentify(passportData);
        log.info("filling place of living");
        newPatientPage.populatePlaceOfLiving(passportData);
        log.info("filling additional info");
        newPatientPage.populateAdditionalInfo(passportData, dispensaryData);
        log.info("click save changes");
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

}
