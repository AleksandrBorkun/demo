package com.epam.tf.steps;

import com.epam.tf.pages.DiagnosisMetastasesMainPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Aliaksei_Astashkevic on 12/6/2016.
 */
public class DiagnosisMetastasesMainPageSteps extends AbstractSteps {
    private DiagnosisMetastasesMainPage diagnosisMetastasesMainPage;


    public DiagnosisMetastasesMainPageSteps(WebDriver driver) {
        super(driver);
        diagnosisMetastasesMainPage = new DiagnosisMetastasesMainPage(driver);
    }

    public DiagnosisMetastasesMainPageSteps fillValidMetastasesData() {
        log.info("Trying to fill info about metastases");
        diagnosisMetastasesMainPage.fillMetastasesData();
        return this;
    }

    public DiagnosisMetastasesMainPageSteps validateAddingMetastasesData() {
        log.info("Check add information about metastases");
        diagnosisMetastasesMainPage.resultTableContainsValue(diagnosisMetastasesMainPage.getADD_DATE());
        return this;
    }

    public DiagnosisMetastasesMainPageSteps editMetastasesData() {
        log.info("Trying to edit info about metastases");
        diagnosisMetastasesMainPage.editMetastasesData();
        return this;
    }

    public DiagnosisMetastasesMainPageSteps validateEditingMetastasesData() {
        log.info("Check edit information about metastases");
        diagnosisMetastasesMainPage.resultTableContainsValue(diagnosisMetastasesMainPage.getEDIT_DATE());
        return this;
    }

    public DiagnosisMetastasesMainPageSteps deleteMetastasesData() {
        log.info("Trying to delete info about metastases");
        diagnosisMetastasesMainPage.deleteMetastasesData();
        return this;
    }

    public DiagnosisMetastasesMainPageSteps validateDeletingMetastasesData() {
        log.info("Check delete information about metastases");
        diagnosisMetastasesMainPage.elementHasPresented();
        return this;
    }


}
