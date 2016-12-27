package com.epam.tf.tests;

import com.epam.tf.data.parser.Parser;
import com.epam.tf.data.parser.ParserFactory;
import com.epam.tf.entity.*;
import com.epam.tf.dao.impl.PatientDAO;
import com.epam.tf.dao.pool.ConnectionPool;
import com.epam.tf.driver.FactoryDriver;
import com.epam.tf.property.PropertyProvider;
import com.epam.tf.steps.LoginPageSteps;
import com.epam.tf.steps.MainPageSteps;
import com.epam.tf.utils.ScreenshotExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.List;


@Listeners(ScreenshotExecutor.class)
public abstract class BaseTest {

    private LoginPageSteps loginPageSteps;
    protected MainPageSteps mainPageSteps;
    protected List<Patient> patients;
    protected PatientDAO patientDAO;
    WebDriver driver;
    protected Patient patient;
    protected final Logger LOG = LogManager.getLogger();



    protected PatientDAO getPatientDAO() {
        return patientDAO;
    }
    protected List<Patient> getPatients() {
        return patients;
    }

    @BeforeClass
    public void initData() {
        ConnectionPool.getInstance();
        Parser parser = ParserFactory.getParser(ParserFactory.ParserType.PATIENT);
        patientDAO = new PatientDAO();
        patients = parser.getPatientList();
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



}