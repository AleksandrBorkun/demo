package com.epam.tf.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps {

    protected static final Logger log = LogManager.getRootLogger();

    protected WebDriver driver;

    public AbstractSteps(WebDriver driver) {
        this.driver = driver;
    }
}
