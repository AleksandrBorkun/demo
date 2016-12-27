package com.epam.tf.steps;

import com.epam.tf.pages.LoginPage;
import com.epam.tf.property.PropertyProvider;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps extends AbstractSteps {
    private final LoginPage loginPage;

    public LoginPageSteps(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }


    public LoginPageSteps openLoginPage() {
        log.info("opening login page");
        driver.get(PropertyProvider.getProperty("url"));
        return this;
    }

    public MainPageSteps authorization(String login, String password) {
        log.info("try to login in");
        loginPage.authorization(login, password);
        return new MainPageSteps(driver);
    }
}
