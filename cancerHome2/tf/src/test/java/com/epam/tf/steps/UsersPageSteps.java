package com.epam.tf.steps;

import com.epam.tf.pages.UsersPage;
import org.openqa.selenium.WebDriver;

public class UsersPageSteps extends AbstractSteps{
    UsersPage usersPage;

    public UsersPageSteps(WebDriver driver) {
        super(driver);
        this.usersPage = new UsersPage(driver);
    }

    public UsersPageSteps clickAddNewUser() {
        log.info("click on Add User button");
        usersPage.clickAddUser();
        return this;
    }

    public UsersPageSteps insertNameSurNameAndEmail(String surName, String name, String email){
        log.info("fill name, sur name and email");
        usersPage.insertNameSurNameAndEmail(surName, name, email);
        return this;
    }

    public UsersPageSteps clickSubmitNewUser(){
        log.info("click Submit");
        usersPage.clickSubmitNewUser();
        return this;
    }

    public UsersPageSteps fillNewUserData(String login, String password, String surName, String name, String email) {
        log.info("fill users login and password");
        usersPage.insertLoginAndPassword(login, password);
        insertNameSurNameAndEmail(surName, name, email);
        log.info("choose super administrator rights");
        usersPage.chooseSuperAdministratorField();
        log.info("choose Dispensary");
        usersPage.chooseDispensary();
        clickSubmitNewUser();
        return this;
    }

    public String checkResult() {
        log.info("check result page");
        return usersPage.getTitleOfPage();
    }

    public String findUser(String query) {
        log.info("try to find user");
        return usersPage.findUser(query);
    }

    public UsersPageSteps findUserAndClickEdit(String query) {
        log.info("click edit on user");
        usersPage.findUserAndClickEdit(query);
        return this;
    }
}
