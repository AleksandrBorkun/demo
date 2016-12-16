package com.epam.tf.steps;

import com.epam.tf.pages.AbstractPage;
import com.epam.tf.pages.SpecificIGHPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dzmitry_Bets on 12/13/2016.
 */

public class SpecificIGHPageSteps extends AbstractSteps {

    private SpecificIGHPage specificIGHPage = new SpecificIGHPage(driver);

    public SpecificIGHPageSteps(WebDriver driver) {
        super(driver);
    }

    public SpecificIGHPageSteps fillIGHDiagnose(String date){
        log.info("Fill specific IGH diagnose date");
        specificIGHPage.fillDateOfDiagnoseField(date);
        log.info("");
        specificIGHPage.doMarkErCheckbox();
        specificIGHPage.doMarkPrCheckbox();
        specificIGHPage.doMarkKiCheckbox();
        specificIGHPage.clickSaveDiagnoseButton();
        return this;
    }

    public SpecificIGHPageSteps editIGHDiagnosis(){
        specificIGHPage.editSpecificDiagnose();
        return this;
    }

    public SpecificIGHPageSteps deleteIGHDiagnosis(){
        specificIGHPage.deleteSpecificDiagnose();
        return this;
    }





}
