package com.epam.tf.tests;

import com.epam.tf.data.*;
import com.epam.tf.driver.FactoryDriver;
import com.epam.tf.property.PropertyProvider;
import com.epam.tf.steps.LoginPageSteps;
import com.epam.tf.steps.MainPageSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTest {
    protected MainPageSteps mainPageSteps;
    protected WebDriver driver;
    protected LoginPageSteps loginPageSteps;
    protected final String PATIENT_CARD_NUMBER = "202401";
    protected Object[] userData;
    protected PassportData passportData;
    protected DispensaryData dispensaryData;
    protected Map<String, Diagnosis> diagnosisMap = new HashMap<>();
    protected Map<String, ClinicalGroups> clinicalGroupsMap = new HashMap<>();
    protected Map<String, ClinicalExamination> clinicalExaminationMap = new HashMap<>();

    @BeforeClass
    public void initData() {
        setUserData();
    }

    @BeforeMethod
    public void setUp() {
        this.driver = FactoryDriver.getInstance();
        this.loginPageSteps = new LoginPageSteps(driver);
        this.loginPageSteps.openLoginPage();
        mainPageSteps = loginPageSteps.authorization(PropertyProvider.getProperty("login"),
                PropertyProvider.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        FactoryDriver.closeDriver();
        this.driver = null;
        this.loginPageSteps = null;
    }

    protected void setUserData() {
        userData = ExcelReader.getUserData(PATIENT_CARD_NUMBER);
        passportData = (PassportData) userData[0];
        dispensaryData = (DispensaryData) userData[1];
        diagnosisMap = (Map<String, Diagnosis>) userData[2];
        clinicalGroupsMap = (Map<String, ClinicalGroups>) userData[3];
        clinicalExaminationMap = (Map<String, ClinicalExamination>) userData[4];
    }

    protected void setUserData(String patientCardNumber) {
        userData = ExcelReader.getUserData(patientCardNumber);
        passportData = (PassportData) userData[0];
        dispensaryData = (DispensaryData) userData[1];
        diagnosisMap = (Map<String, Diagnosis>) userData[2];
        clinicalGroupsMap = (Map<String, ClinicalGroups>) userData[3];
        clinicalExaminationMap = (Map<String, ClinicalExamination>) userData[4];

    }
}