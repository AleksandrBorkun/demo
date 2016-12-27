package com.epam.tf.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps {

    static final Logger log = LogManager.getRootLogger();

    final WebDriver driver;

    AbstractSteps(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderSteps goToHeader() {
        log.info("Go to Header");
        return new HeaderSteps(driver);
    }
}
