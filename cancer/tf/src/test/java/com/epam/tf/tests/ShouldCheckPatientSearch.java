package com.epam.tf.tests;

import com.epam.tf.utils.ScreenshotExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotExecutor.class)
public class ShouldCheckPatientSearch extends BaseTest {
    public static final String SEARCH_REQUEST_SUR_NAME= "Давыдчик";

    @Test
    public void oneCanFindPatientBySurName() {
        String result = mainPageSteps.insertSurNameIntoSearchField(SEARCH_REQUEST_SUR_NAME)
                .applySearchRequest()
                .getSearchResultBySurName();
        Assert.assertEquals(SEARCH_REQUEST_SUR_NAME, result);
    }
}
