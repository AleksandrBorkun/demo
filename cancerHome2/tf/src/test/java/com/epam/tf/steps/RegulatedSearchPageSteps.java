package com.epam.tf.steps;

import com.epam.tf.pages.RegulatedSearchPage;
import com.epam.tf.utils.Random;
import org.openqa.selenium.WebDriver;

public class RegulatedSearchPageSteps extends AbstractSteps{
    private RegulatedSearchPage regulatedSearchPage;
    private String random;

    public RegulatedSearchPageSteps(WebDriver driver) {
        super(driver);
        regulatedSearchPage = new RegulatedSearchPage(driver);
    }

    public ListsPageSteps addNewList(){
        random = "Test "+ Random.getRandomString(7);
        regulatedSearchPage.searchForDispensaryCall("2015");
        regulatedSearchPage.saveSearchResultInList(random);
        return new ListsPageSteps(driver);
    }

    public String getExpectedListName(){
        return random;
    }



}
