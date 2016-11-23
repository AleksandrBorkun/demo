package com.epam.tf.data;

import com.epam.tf.utils.Random;

/**
 * Data for test №67-68
 */

public class NewAdministratorData {

    private static String LOGIN;
    private static String PASSWORD = "123Goodx";
    private static String NAME;
    private static String SUR_NAME;
    private static String EMAIL = "testemail@mail.ru";
    private static String ADMINISTRATION_PAGE = "Администрирование пользователей";

    public static String getAdministrationPage() {
        return ADMINISTRATION_PAGE;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getLOGIN() {
        NewAdministratorData.setLOGIN(Random.getRandomString(8));
        return LOGIN;
    }

    public static void setLOGIN(String LOGIN) {
        NewAdministratorData.LOGIN = LOGIN;
    }

    public static String getNAME() {
        NewAdministratorData.setNAME(Random.getRandomStringRus(7));
        return NAME;
    }

    public static void setNAME(String NAME) {
        NewAdministratorData.NAME = NAME;
    }

    public static String getSurName() {
        NewAdministratorData.setSurName(Random.getRandomStringRus(7));
        return SUR_NAME;
    }

    public static void setSurName(String surName) {
        SUR_NAME = surName;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

}
