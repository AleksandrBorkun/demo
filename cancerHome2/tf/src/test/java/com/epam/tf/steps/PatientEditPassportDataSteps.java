package com.epam.tf.steps;

import com.epam.tf.entity.TestCase;
import com.epam.tf.pages.EditPassportDataPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nikolay_Golubitsky on 12/9/2016.
 */
public class PatientEditPassportDataSteps extends AbstractSteps{
    private EditPassportDataPage passportDataPage;

    public PatientEditPassportDataSteps(WebDriver driver) {
        super(driver);
        passportDataPage = new EditPassportDataPage(driver);
    }

    public PatientEditPassportDataSteps editGenderAndState(TestCase testCase){
        passportDataPage.editGenderWithByteSexField(testCase);
        passportDataPage.editState(testCase);
        return this;
    }

    public PatientEditPassportDataSteps editGender(TestCase testCase){
        log.info("edit sex in Edit Passport data page");
        passportDataPage.editGender(testCase);
        if(passportDataPage.getGenderDifference()){
            log.info("sex of patient equals the sex in test case, don't change the field");
        } else {
            log.info("sex was edit successful");
        }
        return this;
    }

    public PatientEditPassportDataSteps clickSaveButton(){
        passportDataPage.clickSaveButton();
            if(passportDataPage.getGenderDifference()){
                log.info("Click save button. Input data was saved successful.");
            } else {
                passportDataPage.confirmAlertWindow();
                log.info("Click save button. Continue test with some warnings: ");
                StringBuilder message = passportDataPage.getWarningMessage();
                log.info(message);
            }
        return this;
    }
    public PatientEditPassportDataSteps save(){
        passportDataPage.clickSaveButton();
        return this;
    }

    public PatientCardPageSteps pressPatientCardButton(){
        log.info("Go to Patient Card page");
        passportDataPage.clickGoToPatientCardPageButton();
        return new PatientCardPageSteps(driver);
    }

}
