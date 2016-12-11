package com.epam.tf.tests;

import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.annotations.*;

/**
 * Created by Dzmitry_Bets on 12/6/2016.
 */

//test # 2

@Listeners(ScreenshotExecutor.class)
public class PatientEditPassportDataTest extends BaseTest {


    @BeforeMethod
    public void setUp(){
        super.setUp();
        getPatientDAO().add(patients.get(1));
    }

    @Test
    public void editPatientTest(){
        mainPageSteps.applySearchRequestGlobal()
                .insertSurNameIntoSearchField(patients.get(1).getLastName())
                .applySearchRequest()
                .editPatientData()
                .editPassportData();

    }

    @AfterMethod
    public void tearDown(){
        super.tearDown();
        getPatientDAO().deleteByIdn(patients.get(1).getIdn());
    }

}
