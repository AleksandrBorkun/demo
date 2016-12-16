package com.epam.tf.steps;

import com.epam.tf.pages.PatientDiagnosisFormPage;
import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nikolay_Golubitsky on 12/8/2016.
 */
public class DiagnosisFormPageSteps extends AbstractSteps {

    private PatientDiagnosisFormPage diagnosisFormPage;

    public DiagnosisFormPageSteps(WebDriver driver) {
        super(driver);
        diagnosisFormPage = new PatientDiagnosisFormPage(driver);
    }
    public DiagnosisEditPageSteps createNewDiagnosis(){
        diagnosisFormPage.createNewDiagnosis();
        ThreadSleep.waitElement(2000);
        return new DiagnosisEditPageSteps(driver);
    }

    public DiagnosisEditPageSteps goToEditor(){
        diagnosisFormPage.goToEditor();
        return new DiagnosisEditPageSteps(driver);
    }

    public PatientCardPageSteps deleteNotAMainPatientDiagnosis(){
        log.info("delete not a main patient diagnosis");
        diagnosisFormPage.deleteDiagnosis();
        diagnosisFormPage.clickConfirmDeleteButton();
        return new PatientCardPageSteps(driver);
    }


}
