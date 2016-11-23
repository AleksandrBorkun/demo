package com.epam.tf.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PassportPartArchievePage extends AbstractPage {
    public PassportPartArchievePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='partial']/table/tbody/tr")
    private List<WebElement> archieve;


    public int showArchieve() {
        return archieve.size();
    }
}
