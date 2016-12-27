package com.epam.tf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShouldCheckPatientSearch extends BaseTest {
    private static final String SEARCH_REQUEST_SUR_NAME= "Демидович";

    @Test
    public void oneCanFindPatientBySurName() {
        String result = mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SUR_NAME)
                .applySearchRequest()
                .getSearchResultBySurName(SEARCH_REQUEST_SUR_NAME);
        Assert.assertEquals(SEARCH_REQUEST_SUR_NAME, result);
    }
}
