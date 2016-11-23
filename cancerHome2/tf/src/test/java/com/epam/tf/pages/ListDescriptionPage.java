package com.epam.tf.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListDescriptionPage extends AbstractPage{

    @FindBy(xpath = "//tr[@class='patientItem']//input[@type='checkbox']")
    private WebElement checkboxFirstUser;

    @FindBy(xpath = "//button[@role='CustomDelete']")
    private WebElement buttonRemoveFromList;

    @FindBy(xpath = "//div[@class='modal-content']//button[text()='Удалить']")
    private WebElement buttonRemoveConfirmation;


    @FindBy(xpath = "//div[@class='text-right']")
    private WebElement usersPatientSpan;


    public ListDescriptionPage(WebDriver driver) {
        super(driver);
    }

    public void removeFirstUser(){
        checkboxFirstUser.click();
        buttonRemoveFromList.click();
        buttonRemoveConfirmation.click();
    }

    public int getPatientCount(){
        return parsePatientCountSpan(usersPatientSpan.getText());
    }

    private int parsePatientCountSpan(String text){
        text = text.substring(6);
        text = text.replace(" записей","");
        return Integer.parseInt(text);
    }




}
