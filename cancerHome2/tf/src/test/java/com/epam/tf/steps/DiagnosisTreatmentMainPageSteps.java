package com.epam.tf.steps;

import com.epam.tf.pages.DiagnosisTreatmentMainPage;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class DiagnosisTreatmentMainPageSteps extends AbstractSteps {
    private DiagnosisTreatmentMainPage diagnosisTreatmentMainPage;

    public DiagnosisTreatmentMainPageSteps(WebDriver driver) {
        super(driver);
        diagnosisTreatmentMainPage = new DiagnosisTreatmentMainPage(driver);
    }

    public int getCountOfTreatmentMarks() {
        log.info("try to get treatment marks count");
        return diagnosisTreatmentMainPage.getCurrentCommonDiagnosisTreatmentMarksCount();
    }

    public ArrayList<String> getDataOfFirstTreatmentMark() {
        log.info("try to get list of data of first clinical treatment mark");
        return diagnosisTreatmentMainPage.getDataOfFirstCommonDiagnosisTreatmentsMark();
    }

    public void editFirstDiagnosisTreatment() {
        log.info("edit treatment for first diagnosis mark");
        diagnosisTreatmentMainPage.editFirstCommonDiagnosisTreatmentData();
    }
    public void addDiagnosisTreatment() {
        log.info("Add new treatment for first diagnosis mark");
        diagnosisTreatmentMainPage.addCommonDiagnosisTreatmentData();
    }

    public void deleteFirstTreatmentMark() {
        log.info("delete firs treatment mark");
        diagnosisTreatmentMainPage.deleteFirstCommonDiagnosisTreatmentDataMark();
    }

    public void goToSurgeryTreatmentOfTreatmentMark() {
        log.info("go To Surgery Treatment Of First Common Treatment Mark");
        diagnosisTreatmentMainPage.goToSurgeryTreatmentOfFirstCommonTreatmentMark();
    }
    public  void goToChemotherapyTreatmentPage() {
        log.info("go To Chemotherapy Treatment Of First Common Treatment Mark");
        diagnosisTreatmentMainPage.goToChemotherapyTreatmentPage();
    }

    public  void goToDevicesRadiotherapyTreatmentPage() {
        log.info("go To Devices Treatment Of First Common Treatment Mark");
        diagnosisTreatmentMainPage.goToDevicesRadioTherapyTreatmentPage();
    }

    public  void goToPharmacologyRadiotherapyTreatmentPage() {
        log.info("go To Pharmacology Treatment Of First Common Treatment Mark");
        diagnosisTreatmentMainPage.goToPharmacologyRadioTherapyTreatmentPage();
    }

    public void goToOtherImpactTreatmentPage(){
        log.info("go To Pharmacology Treatment Of First Common Treatment Mark");
        diagnosisTreatmentMainPage.goToOtherImpactTreatmentPage();
    }

}
