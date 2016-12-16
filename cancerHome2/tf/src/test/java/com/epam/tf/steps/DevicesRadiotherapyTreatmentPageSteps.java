package com.epam.tf.steps;

import com.epam.tf.pages.DevicesRadioTherapyTreatmentPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kiryl_Shyshko on 12/10/2016.
 */
public class DevicesRadiotherapyTreatmentPageSteps extends DiagnosisTreatmentMainPageSteps {
    private DevicesRadioTherapyTreatmentPage devicesRadioTherapyTreatmentPage;

    private final String characterNameAdd = "Послеоперационное";
    private final int characterAdd = 2;
    private final int impactTypeAdd = 2;
    private final int modifierAdd = 2;
    private final int impactZoneAdd = 2;
    private final int affectedOrganAdd = 2;
    private final String doseAdd = "123";

    private final String characterNameEdit = "Самостоятельное радикальное";
    private final int characterEdit = 3;
    private final int impactTypeEdit = 3;
    private final int modifierEdit = 3;
    private final int impactZoneEdit = 2;
    private final int affectedOrganEdit = 2;
    private final String doseEdit = "222";


    public DevicesRadiotherapyTreatmentPageSteps(WebDriver driver) {
        super(driver);
        devicesRadioTherapyTreatmentPage = new DevicesRadioTherapyTreatmentPage(driver);
    }

    public void createFirstDevicesRadiotherapyTreatment(){
        log.info("create devices radiotherapy treatment ");
        devicesRadioTherapyTreatmentPage.editDevicesRadiotherapyTreatment(characterAdd,impactTypeAdd,modifierAdd,impactZoneAdd,affectedOrganAdd,doseAdd);
    }
    public void editDevicesRadiotherapyTreatment(){
        log.info("create devices radiotherapy treatment ");
        devicesRadioTherapyTreatmentPage.editDataCommonButtonClick();
        devicesRadioTherapyTreatmentPage.editDevicesRadiotherapyTreatment(characterEdit,impactTypeEdit,modifierEdit,impactZoneEdit,affectedOrganEdit,doseEdit);
    }

    public  void deleteDevicesRadiotherapyTreatment(){
        log.info("deleting devices radiotherapy treatment");
        devicesRadioTherapyTreatmentPage.deleteDataCommonButtonClick();
        devicesRadioTherapyTreatmentPage.confirmDeleteDevicesRadiotherapyTreatment();
    }

    public boolean isDevicesRadiotherapyCharacterAdded() {
        log.info("checking that devices radiotherapy treatment character added");
        return devicesRadioTherapyTreatmentPage.isDevicesRadiotherapyCharacterPresent(characterNameAdd);
    }

    public boolean isDevicesRadiotherapyCharacterEdited() {
        log.info("checking that devices radiotherapy treatment character added");
        return devicesRadioTherapyTreatmentPage.isDevicesRadiotherapyCharacterPresent(characterNameEdit);
    }

    public boolean isDevicesRadiotherapyTreatmentDeleted() {
        log.info("checking that devices radiotherapy treatment deleted");
        return devicesRadioTherapyTreatmentPage.isDevicesRadiotherapyTreatmentDeleted();
    }
}
