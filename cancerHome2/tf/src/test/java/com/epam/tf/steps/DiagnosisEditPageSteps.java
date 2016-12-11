package com.epam.tf.steps;

import com.epam.tf.entity.TestCase;


import com.epam.tf.pages.DiagnosisEditPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nikolay_Golubitsky on 12/6/2016.
 * This class gives possibility to manipulate
 * with {@code DiagnosisEditPage}
 *
 */
public class DiagnosisEditPageSteps extends AbstractSteps {

    private DiagnosisEditPage editPage;

    public DiagnosisEditPageSteps(WebDriver driver) {
        super(driver);
        editPage = new DiagnosisEditPage(driver);
    }

    /**
     * This method adds current values of {@code TestCase} to the required fields
     * with check of test case's strings(if string is empty it will be ignored )
     * @param testCase is instance of {@code TestCase}
     * @return current instance of {@code DiagnosisEditPageSteps}
     */

    public DiagnosisEditPageSteps fillDiagnosisData(TestCase testCase){
        editPage.fillInAllFieldsFromTestCase(testCase);
        return this;
    }

    /**
     * This method adds current values of {@code TestCase} to the required fields
     * without check of test case's strings
     * @param testCase is instance of {@code TestCase}
     * @return current instance of {@code DiagnosisEditPageSteps}
     */

    public DiagnosisEditPageSteps fillDiagnosisDataWithoutStringsCheck(TestCase testCase){
        editPage.fillInAllFieldsFromTestCase(testCase);
        return this;
    }

    /***
     *  Return save result
     * @return result of entered values in form of string
     */

    public String saveResult(){
        return editPage.getErrorMessage();
    }

}
