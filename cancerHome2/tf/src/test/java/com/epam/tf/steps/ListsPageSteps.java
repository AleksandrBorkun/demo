package com.epam.tf.steps;


import com.epam.tf.pages.ListPage;
import com.epam.tf.utils.Random;
import org.openqa.selenium.WebDriver;

public class ListsPageSteps extends AbstractSteps{

    private ListPage listPage;
    private String random;


    public ListsPageSteps(WebDriver driver) {
        super(driver);
        listPage = new ListPage(driver);
    }

    public void createEmptyList(){
        random = "Test "+ Random.getRandomString(5);
        listPage.createEmptyList(random);
    }

    public String getActualListName(){
        return listPage.getFirstListName();
    }

    public String getExpectedListName(){
        return random;
    }

    public void removeAllLists(){
        while(getRemoveButtonsQuantity()!=0){
            listPage.removeFirstList();
        }
    }

    public void removeFirstList(){
        listPage.removeFirstList();
    }

    public int getRemoveButtonsQuantity(){
        return listPage.getRemoveButtonsList().size();
    }

    public ListDescriptionPageSteps turnToListDescription(){
        listPage.turnToListDetails();
        return new ListDescriptionPageSteps(driver);
    }





}
