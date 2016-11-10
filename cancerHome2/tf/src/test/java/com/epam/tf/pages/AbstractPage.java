package com.epam.tf.pages;

import com.epam.tf.utils.ExplicitWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected ExplicitWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new ExplicitWait(driver);

    }


}
