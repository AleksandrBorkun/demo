package com.epam.tf.tests;

import com.epam.tf.utils.ScreenshotExecutor;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.tf.data.NewAdministratorData.*;


@Listeners(ScreenshotExecutor.class)
public class ShouldCreateNewAdministrator extends BaseTest {

    private static final String NAME = getNAME();
    private static final String SURNAME = getSurName();
    private static final String NEW_NAME = getSurName();
    private static final String NEW_SURNAME = getSurName();
    private static final String EMAIL = getEMAIL();
    private static final String NEW_EMAIL = getEMAIL();


    @Test
    public void oneCanCreateNewAdministrator() {
        String result = mainPageSteps.goToUsersPage()
                .clickAddNewUser()
                .fillNewUserData(getLOGIN(), getPASSWORD(), SURNAME, NAME, EMAIL)
                .checkResult();
        Assert.assertEquals(result, getAdministrationPage());
    }


    @Test(dependsOnMethods = "oneCanCreateNewAdministrator")
    public void oneCanChangeAdministratorData() {
        String query = SURNAME + " " + NAME;
        String newQuery = NEW_SURNAME + " " + NEW_NAME;
        String result = mainPageSteps.goToUsersPage()
                .findUserAndClickEdit(query)
                .insertNameSurNameAndEmail(NEW_SURNAME, NEW_NAME, NEW_EMAIL)
                .clickSubmitNewUser()
                .findUser(newQuery);
        Assert.assertEquals(result, newQuery);
    }


}
