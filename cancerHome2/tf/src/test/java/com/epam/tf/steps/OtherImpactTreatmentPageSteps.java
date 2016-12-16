package com.epam.tf.steps;

import com.epam.tf.pages.OtherImpactTreatmentPage;
import org.openqa.selenium.WebDriver;


public class OtherImpactTreatmentPageSteps  extends  DiagnosisTreatmentMainPageSteps{

     private OtherImpactTreatmentPage otherImpactTreatmentPage;
    public OtherImpactTreatmentPageSteps(WebDriver driver) {
        super(driver);
        otherImpactTreatmentPage = new OtherImpactTreatmentPage(driver);
    }

    private final String OTHER_IMPACT_TYPE_NAME_ADD_CHECK = "Гипертермия";
    private String OTHER_IMPACT_TYPE_NAME_EDIT_CHECK = "Гипергликемия";
    private String START_END_IMPACT_DATE = "01061999";
    private final int OTHER_IMPACT_TYPE_ADD = 0;
    private final int OTHER_IMPACT_TYPE_EDIT = 1;



    public void addOtherImpactTreatment(){
        log.info("Create Other Impact Treatment");
        otherImpactTreatmentPage.editOtherImpactTreatmentOfdaignosis(OTHER_IMPACT_TYPE_ADD,START_END_IMPACT_DATE,START_END_IMPACT_DATE);
    }

    public void editOtherImpactTreatment(){
        log.info("edit Other Impact Treatment");
        otherImpactTreatmentPage.editDataCommonButtonClick();
        otherImpactTreatmentPage.editOtherImpactTreatmentOfdaignosis(OTHER_IMPACT_TYPE_EDIT,START_END_IMPACT_DATE,START_END_IMPACT_DATE);
    }

    public void deleteOtherImpactTreatment(){
        log.info("Deleting Other Impact Treatment");
        otherImpactTreatmentPage.deleteDataCommonButtonClick();
        otherImpactTreatmentPage.confirmDeleteOtherImpactTreatment();
    }
    public boolean isOtherImpactTreatmentAdded(){
        log.info("checking Other Impact Treatment added");
        return otherImpactTreatmentPage.isOtherImpactTypePresent(OTHER_IMPACT_TYPE_NAME_ADD_CHECK);
    }

    public boolean isOtherImpactTreatmentEdit(){
        log.info("checking Other Impact Treatment edit");
        return otherImpactTreatmentPage.isOtherImpactTypePresent(OTHER_IMPACT_TYPE_NAME_EDIT_CHECK);
    }
    public boolean isOtherImpactTreatmentDeleted(){
        AbstractSteps.log.info("Checking that Other Impact Treatment Deleted");
        return otherImpactTreatmentPage.isOtherImpactTreatmentDeleted();
    }
}
