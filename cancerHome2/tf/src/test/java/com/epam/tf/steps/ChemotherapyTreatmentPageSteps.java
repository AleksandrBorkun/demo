package com.epam.tf.steps;

import com.epam.tf.pages.СhemotherapyTreatmentOfDiagnosisPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kiryl_Shyshko on 12/7/2016.
 */
public class ChemotherapyTreatmentPageSteps extends DiagnosisTreatmentMainPageSteps {
    private СhemotherapyTreatmentOfDiagnosisPage сhemotherapyTreatmentOfDiagnosisPage;

    private  String drugNameAdd ="6-Меркаптопурин";
    private final int drugAdd = 3;
    private final String doseAdd = "12";
    private final int unitOfDoseAdd = 2;
    private final int injectionMethodAdd = 4;

    private  String drugNameEdit ="6-MP";
    private final int drugEdit = 2;
    private final String doseEdit = "22";
    private final int UnitOfDoseEdit = 3;
    private final int injectionMethodEdit = 3;

    public ChemotherapyTreatmentPageSteps(WebDriver driver) {
        super(driver);
        сhemotherapyTreatmentOfDiagnosisPage = new СhemotherapyTreatmentOfDiagnosisPage(driver);
    }

    public void createFirstChemotherapyOfDiagnosis() {
       log.info("Create Chemotherapy treatment in Diagnosis Page");
        сhemotherapyTreatmentOfDiagnosisPage.editChemotherapyTreatmentOfDiagnosis(drugAdd, doseAdd, unitOfDoseAdd, injectionMethodAdd);
    }

    public void editChemotherapyOfDiagnosis() {
        log.info("Edit Chemotherapy treatment in Diagnosis Page");
        сhemotherapyTreatmentOfDiagnosisPage.editDataCommonButtonClick();
        сhemotherapyTreatmentOfDiagnosisPage.editChemotherapyTreatmentOfDiagnosis(drugEdit, doseEdit, UnitOfDoseEdit, injectionMethodEdit);
    }

    public void addChemotherapyOfDiagnosis(){
        log.info("Add Chemotherapy treatment in Diagnosis Page ");
        сhemotherapyTreatmentOfDiagnosisPage.addDataCommonButton();
        сhemotherapyTreatmentOfDiagnosisPage.editChemotherapyTreatmentOfDiagnosis(drugAdd, doseAdd, unitOfDoseAdd, injectionMethodAdd);
    }
    public void deleteChemotherapyTreatment(){
       log.info("Deleting Chemotherapy Treatment");
        сhemotherapyTreatmentOfDiagnosisPage.deleteDataCommonButtonClick();
        сhemotherapyTreatmentOfDiagnosisPage.confirmDeleteChemotherapyTreatment();
    }

    public boolean isChemotherapyDrugAdded() {
       log.info("checking that сhemotherapy treatment drug added");
        return сhemotherapyTreatmentOfDiagnosisPage.isChemotherapyDrugPresent(drugNameAdd);
    }

    public boolean isChemotherapyTreatmentEdited() {
        log.info("checking that сhemotherapy treatment  present");
        return сhemotherapyTreatmentOfDiagnosisPage.isChemotherapyDrugPresent(drugNameEdit);
    }

    public boolean isChemotherapyTreatmentDeleted() {
       log.info("checking that сhemotherapy drug deleted");
        return  сhemotherapyTreatmentOfDiagnosisPage.isChemotherapyTreatmentDeleted();
    }
}
