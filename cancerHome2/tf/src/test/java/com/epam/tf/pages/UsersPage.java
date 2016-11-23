package com.epam.tf.pages;

import com.epam.tf.utils.ThreadSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends AbstractPage {

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container']/a")
    private WebElement addUserButton;
    @FindBy(id = "UserName")
    private WebElement loginField;
    @FindBy(id = "PasswordModel_Password")
    private WebElement passwordField;
    @FindBy(id = "PasswordModel_ConfirmPassword")
    private WebElement passwordConfirmField;
    @FindBy(id = "LastName")
    private WebElement surNameField;
    @FindBy(id = "FirstName")
    private WebElement nameField;
    @FindBy(id = "Role-Autocomplete-Button")
    private WebElement rolePopUp;
    @FindBy(xpath = "//li[text() =' - Супер администратор']")
    private WebElement superAdministratorField;
    @FindBy(id = "Email")
    private WebElement emailField;
    @FindBy(id = "submitButton")
    private WebElement submitButton;
    @FindBy(id = "DispensaryCode-Autocomplete-Button")
    private WebElement openDispensaryPopUp;
    @FindBy(xpath = "//li[text() = ' - РНПЦ ОМР']")
    private WebElement dispensaryRNPC;
    @FindBy(xpath = "//h2[text() = 'Администрирование пользователей']")
    private WebElement titleOfPage;

    public void clickAddUser() {
        addUserButton.click();
    }

    public void insertLoginAndPassword(String login, String password) {
        loginField.clear();
        loginField.sendKeys(login);
        passwordField.clear();
        passwordField.sendKeys(password);
        passwordConfirmField.clear();
        passwordConfirmField.sendKeys(password);
    }

    public void insertNameSurNameAndEmail(String surName, String name, String email) {
        surNameField.clear();
        surNameField.sendKeys(surName);
        nameField.clear();
        nameField.sendKeys(name);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void chooseSuperAdministratorField() {
        rolePopUp.click();
        ThreadSleep.waitElement(400);
        superAdministratorField.click();
        ThreadSleep.waitElement(400);
    }

    public void chooseDispensary() {
        openDispensaryPopUp.click();
        ThreadSleep.waitElement(500);
        dispensaryRNPC.click();
        ThreadSleep.waitElement(200);
    }

    public void clickSubmitNewUser() {
        ThreadSleep.waitElement(400);
        submitButton.click();
        ThreadSleep.waitElement(400);
    }

    public String getTitleOfPage() {
        return titleOfPage.getText();
    }

    public String findUser(String query) {
        return driver.findElement(By.xpath("//td[contains(text(), '" + query + "')]")).getText();
    }

    public void findUserAndClickEdit(String query){
        driver.findElement(By.xpath("//td[contains(text(), '" + query + "')]/..//a")).click();
    }
}
