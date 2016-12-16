package com.epam.tf.steps;

import com.epam.tf.pages.MolecularGeneticPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dzmitry_Bets on 12/13/2016.
 */

public class MolecularGeneticPageSteps extends AbstractSteps {
    private MolecularGeneticPage molecularGeneticPage = new MolecularGeneticPage(driver);


    public MolecularGeneticPageSteps(WebDriver driver) {
        super(driver);
    }

    public MolecularGeneticPageSteps fillMolecularGeneticDiagnose(String date) {
        log.info("Fill molecular genetic diagnose date");
        molecularGeneticPage.fillDateOfMolecularGeneticDiagnoseField(date);
        log.info("Fill analysis method field");
        molecularGeneticPage.fillAnalysisMethodField();
        log.info("Fill  gen sample field");
        molecularGeneticPage.fillGenSampleField();
        log.info("Fill  gen changes field");
        molecularGeneticPage.fillGenChangesField();
        log.info("Fill  result of molecular research field");
        molecularGeneticPage.fillResultOfMolecularGeneticField();
        molecularGeneticPage.clickSaveButton();
        return this;
    }

    public MolecularGeneticPageSteps editMolecularGeneticButton(){
        log.info("click editing MolecularGenetic diagnosis");
        molecularGeneticPage.editMolecularGeneticDiagnose();
        return this;
    }

    public MolecularGeneticPageSteps clearAllFields(){
        log.info("clear all of fields");
        molecularGeneticPage.clearFields();
        return this;
    }

    public MolecularGeneticPageSteps deleteMolecularDiagnosis(){
        log.info("delete MolecularGenetic Diagnosis");
        molecularGeneticPage.clickDeleteButton();
        return this;
    }








}
