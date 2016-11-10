package com.epam.tf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "UserName")
    private WebElement loginNameField;
    @FindBy(id = "Password")
    private WebElement passwordField;
    @FindBy(xpath = "//button[text() = 'Войти']")
    private WebElement submitButton;

    public void authorization(String login, String password) {
        loginNameField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
