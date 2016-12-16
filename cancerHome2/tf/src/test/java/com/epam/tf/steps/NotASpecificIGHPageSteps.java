package com.epam.tf.steps;

import com.epam.tf.pages.NotASpecificIGHPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dzmitry_Bets on 12/13/2016.
 */
public class NotASpecificIGHPageSteps extends AbstractSteps {
    private NotASpecificIGHPage notASpecificIGHPage = new NotASpecificIGHPage(driver);

    public NotASpecificIGHPageSteps(WebDriver driver) {
        super(driver);
    }

    public NotASpecificIGHPageSteps fillIGHDiagnose(String date) {
        log.info("Fill IGH not specific diagnose date");
        notASpecificIGHPage.fillDateOfDiagnoseField(date);
        log.info("Fill IGH not specific diagnose antibody name");
        notASpecificIGHPage.fillAntibodyNameField();
        log.info("Fill IGH not specific diagnose result");
        notASpecificIGHPage.fillResultField();
        log.info("save IGH not specific diagnose");
        notASpecificIGHPage.clickSaveDiagnoseButton();
        return this;
    }

    public PatientCardPageSteps deleteSpecificDiagnose() {
        log.info("delete IGH not specific diagnose");
        notASpecificIGHPage.deleteSpecificDiagnose();
        return new PatientCardPageSteps(driver);
    }

    public NotASpecificIGHPageSteps editSpecificDiagnose() {
        log.info("edit IGH not specific diagnose ");
        notASpecificIGHPage.editSpecificDiagnose();
        return this;
    }

    public String getDateOfSpecificDiagnose() {
        log.info("get date of IGH not specific diagnose ");
        String result = notASpecificIGHPage.getDateOfSpecificDiagnose();
        return result;
    }

    public String getDateOfNewResearch() {
        log.info("get date of IGH new research");
        String result = notASpecificIGHPage.getDateOfNewResearch();
        return result;
    }
}
