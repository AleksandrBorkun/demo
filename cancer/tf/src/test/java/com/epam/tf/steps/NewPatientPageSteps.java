package com.epam.tf.steps;

import com.epam.tf.data.DispensaryData;
import com.epam.tf.data.PassportData;
import com.epam.tf.pages.NewPatientPage;
import org.openqa.selenium.WebDriver;

public class NewPatientPageSteps extends AbstractSteps {

    NewPatientPage newPatientPage;
    public NewPatientPageSteps(WebDriver driver) {
        super(driver);
        newPatientPage = new NewPatientPage(driver);
    }

    public void populatePatientData(PassportData passportData, DispensaryData dispensaryData) {
        log.info("filling passport info");
        newPatientPage.populateIdentify(passportData);
        log.info("filling ");
        newPatientPage.populatePlaceOfLiving(passportData);
        log.info("filling ");
        newPatientPage.populateAdditionalInfo(passportData, dispensaryData);

    }
}
