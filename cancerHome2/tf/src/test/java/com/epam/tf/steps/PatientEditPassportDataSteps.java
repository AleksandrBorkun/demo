package com.epam.tf.steps;

import com.epam.tf.entity.TestCase;
import com.epam.tf.pages.EditPassportDataPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nikolay_Golubitsky on 12/9/2016.
 */
public class PatientEditPassportDataSteps extends AbstractSteps{
    private EditPassportDataPage passportDataPage;

    public PatientEditPassportDataSteps(WebDriver driver) {
        super(driver);
    }

    public PatientEditPassportDataSteps editGenderAndState(TestCase testCase){
        passportDataPage.editGender(testCase);
        passportDataPage.editState(testCase);
        return this;
    }

    public PatientEditPassportDataSteps editGender(TestCase testCase){
        passportDataPage.editGender(testCase);
        return this;
    }

    public AbstractSteps clickSaveButton(){
        String NameOfPagePasspot = driver.getWindowHandle();
        passportDataPage.clickSaveButton();
        if(driver.getWindowHandles().size() == 1){
            return new PatientCardPageSteps(driver);
        } else {
            for (String namesOfWindows: driver.getWindowHandles()) {
                if(!namesOfWindows.equals(NameOfPagePasspot)){
                    driver.switchTo().window(namesOfWindows);
                    driver.close();
                    return this;
                }
            }
        }
        return this;
    }

}
