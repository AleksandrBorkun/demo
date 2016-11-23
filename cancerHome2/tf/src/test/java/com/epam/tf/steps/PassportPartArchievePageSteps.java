package com.epam.tf.steps;

import com.epam.tf.pages.PassportPartArchievePage;
import org.openqa.selenium.WebDriver;


public class PassportPartArchievePageSteps extends AbstractSteps {

    private PassportPartArchievePage passportPartPage;

    public PassportPartArchievePageSteps(WebDriver driver) {
        super(driver);
        passportPartPage = new PassportPartArchievePage(driver);
    }


    public int showArchieve()  {
        log.info("Check archieve calls");
        return passportPartPage.showArchieve();
    }


}
