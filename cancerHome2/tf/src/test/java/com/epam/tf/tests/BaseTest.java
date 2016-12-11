package com.epam.tf.tests;

import com.epam.tf.entity.Patient;
import com.epam.tf.exception.DAOException;
import com.epam.tf.dao.impl.PatientDAO;
import com.epam.tf.dao.pool.ConnectionPool;
import com.epam.tf.data.*;
import com.epam.tf.data.parser.PatientDataXlsxParser;
import com.epam.tf.driver.FactoryDriver;
import com.epam.tf.property.PropertyProvider;
import com.epam.tf.steps.LoginPageSteps;
import com.epam.tf.steps.MainPageSteps;
import com.epam.tf.utils.ScreenshotExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Listeners(ScreenshotExecutor.class)
public abstract class BaseTest {
    protected MainPageSteps mainPageSteps;
    protected WebDriver driver;
    protected LoginPageSteps loginPageSteps;
    protected final String PATIENT_CARD_NUMBER = "12222-77";
    protected Object[] userData;
    protected PassportData passportData;
    protected DispensaryData dispensaryData;
    protected Map<String, Diagnosis> diagnosisMap = new HashMap<>();
    protected Map<String, ClinicalGroups> clinicalGroupsMap = new HashMap<>();
    protected Map<String, ClinicalExamination> clinicalExaminationMap = new HashMap<>();
    protected Logger LOG = LogManager.getLogger();

    protected PatientDAO patientDAO = new PatientDAO();
    private PatientDataXlsxParser parser = new PatientDataXlsxParser();
    protected List<Patient> patients = parser.getPatientList();


    protected PatientDAO getPatientDAO() {
        return patientDAO;
    }

    protected List<Patient> getPatients(){ return  patients; }

    @BeforeClass
    public void initData() {
        ConnectionPool.getInstance();
        setUserData();
    }
    @AfterClass
    public void closeConnections(){
        try {
            ConnectionPool.getInstance().cleanUp();
        } catch (DAOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @BeforeMethod
    public void setUp() {
        this.driver = FactoryDriver.getInstance();
        this.loginPageSteps = new LoginPageSteps(driver);
        this.loginPageSteps.openLoginPage();
        mainPageSteps = loginPageSteps.authorization(PropertyProvider.getProperty("login"),
                PropertyProvider.getProperty("password"));
    }

    @AfterMethod(alwaysRun = true)
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