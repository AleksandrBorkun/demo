package com.epam.tf.steps;


import com.epam.tf.pages.PharmacologyRadiotherapyTreatmentPage;
import org.openqa.selenium.WebDriver;

public class PharmacologyRadiotherapyTreatmentPageSteps extends  DiagnosisTreatmentMainPageSteps {

    private PharmacologyRadiotherapyTreatmentPage pharmacologyRadiotherapyTreatmentPage;

    private final  String drugNameAdd = "Галлий-67";
    private final int pharmacologyDrugAdd = 1;
    private final String injectionDateAddEdit = "01061999";
    private final String doseAdd="123";

    private final  String drugNameEdit = "Железо-52";
    private final int pharmacologyDrugEdit = 2;
    private final String doseEdit ="213";

    public PharmacologyRadiotherapyTreatmentPageSteps(WebDriver driver) {
        super(driver);
        pharmacologyRadiotherapyTreatmentPage = new PharmacologyRadiotherapyTreatmentPage(driver);
    }

    public void addFirstPharmacologyRadiotherapyTreatment(){
        AbstractSteps.log.info("Create Pharmacology Radiotherapy Treatment");
        pharmacologyRadiotherapyTreatmentPage.editPharmacologyRadiotherapyTreatment(pharmacologyDrugAdd,injectionDateAddEdit,doseAdd);
    }

    public void editFirstPharmacologyRadiotherapyTreatment(){
        log.info("Edit Pharmacology Radiotherapy Treatment");
        pharmacologyRadiotherapyTreatmentPage.editDataCommonButtonClick();
        pharmacologyRadiotherapyTreatmentPage.editPharmacologyRadiotherapyTreatment(pharmacologyDrugEdit,injectionDateAddEdit,doseEdit);
    }

    public  void  deletePharmacologyRadiotherapyTreatment(){
        log.info("Deleting Pharmacology Radiotherapy Treatment");
        pharmacologyRadiotherapyTreatmentPage.deleteDataCommonButtonClick();
        pharmacologyRadiotherapyTreatmentPage.confirmDeletePharmacologyRadiotherapyTreatment();
    }

    public boolean isPharmacologyRadiotherapyTreatmentAdded(){
        log.info("Checking that Pharmacology Radiotherapy Treatment Added");
        return pharmacologyRadiotherapyTreatmentPage.isPharmacologyRadiotherapyDrugPresent(drugNameAdd);
    }
    public boolean isPharmacologyRadiotherapyTreatmentEdit(){
        AbstractSteps.log.info("Checking that Pharmacology Radiotherapy Treatment Edit");
        return pharmacologyRadiotherapyTreatmentPage.isPharmacologyRadiotherapyDrugPresent(drugNameEdit);
    }
    public boolean isPharmacologyRadiotherapyTreatmentDeleted(){
        AbstractSteps.log.info("Checking that Pharmacology Radiotherapy Treatment Deleted");
        return pharmacologyRadiotherapyTreatmentPage.isPharmacologyTherapyTreatmentDeleted();
        }
}
