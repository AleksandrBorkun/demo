package com.epam.tf.tests.testUtils;

import com.epam.tf.property.PropertyProvider;
import org.jetbrains.annotations.Contract;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @Contract(" -> !null")
    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {PropertyProvider.getProperty("login"), PropertyProvider.getProperty("password")},
        };
    }

}