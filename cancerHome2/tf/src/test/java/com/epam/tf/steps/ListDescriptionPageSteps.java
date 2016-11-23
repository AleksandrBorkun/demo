package com.epam.tf.steps;


import com.epam.tf.pages.ListDescriptionPage;
import org.openqa.selenium.WebDriver;

public class ListDescriptionPageSteps extends AbstractSteps{
    private ListDescriptionPage listDescriptionPage;

    public ListDescriptionPageSteps(WebDriver driver) {
        super(driver);
        listDescriptionPage = new ListDescriptionPage(driver);
    }

    public int getPatientCount(){
        return listDescriptionPage.getPatientCount();
    }


    public void removeFirstUser(){
        listDescriptionPage.removeFirstUser();
    }


}

