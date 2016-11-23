package com.epam.tf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ShouldCheckCallsNotes extends BaseTest {

    public static final String SEARCH_REQUEST_SUR_NAME = "Авдевич";

    @Test
    public void checkCallsNotes()  {
        String surname = mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SUR_NAME)
                .applySearchRequest()
                .getSearchResultBySurName(SEARCH_REQUEST_SUR_NAME);
        Assert.assertEquals(surname, SEARCH_REQUEST_SUR_NAME);
       Assert.assertTrue((mainPageSteps.pressFirstRefactorButton().choosePassportPart().showArchieve())!=0);
    }
}
