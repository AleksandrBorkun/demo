package com.epam.tf.steps;

import com.epam.tf.pages.MarksOnClinicalExaminationPage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class MarksOnClinicalExaminationPageSteps extends AbstractSteps {

    MarksOnClinicalExaminationPage marksOnClinicalExaminationPage;

    public MarksOnClinicalExaminationPageSteps(WebDriver driver) {
        super(driver);
        marksOnClinicalExaminationPage = new MarksOnClinicalExaminationPage(driver);
    }

    public int getCountOfClinicalExaminationMarks() {
        log.info("try to get common marks count");
        return marksOnClinicalExaminationPage.getCurrentMarksCount();
    }

    public void createNewClinicalExaminationWithCurrentDate() {
        log.info("Add new Clinical Examination mark");
        marksOnClinicalExaminationPage.addNewClinicalExaminationMarkWithCurrentDate();
    }

    public ArrayList<String> getDataOfFirstClinicalExaminationMark() {
        log.info("try to get list of data of first clinical examination mark");
        return marksOnClinicalExaminationPage.getFirstMarkData();
    }

    public void editClinicalExaminationFirsMark(String period) {
        log.info("edit clinical examination firs mark");
        marksOnClinicalExaminationPage.editClinicalExaminationMark(period);
    }

    public void editClinicalGroup(){
        log.info("edit clinic group");
        marksOnClinicalExaminationPage.editClinicGroup();
    }

    public void deleteClinicalExaminationFirsMark() {
        log.info("delete clinical examination firs mark");
        marksOnClinicalExaminationPage.deleteClinicalExaminationMarkWithCurrentDate();
    }



}
