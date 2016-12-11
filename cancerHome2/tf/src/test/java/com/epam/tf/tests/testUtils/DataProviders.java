package com.epam.tf.tests.testUtils;

import com.epam.tf.entity.TestCase;
import com.epam.tf.data.parser.TestCasesParserDataGenderCombinationXlsx;
import com.epam.tf.data.parser.TestCasesParserFirstSheet;
import com.epam.tf.property.PropertyProvider;
import org.jetbrains.annotations.Contract;
import org.testng.annotations.DataProvider;


import java.util.*;

public class DataProviders {
    private static TestCasesParserDataGenderCombinationXlsx genderCombination = new TestCasesParserDataGenderCombinationXlsx();
    private static TestCasesParserFirstSheet parserFirstSheet = new TestCasesParserFirstSheet();

    @Contract(" -> !null")
    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {PropertyProvider.getProperty("login"), PropertyProvider.getProperty("password")},
        };
    }

    @DataProvider(name = "gender combination valid cases")
    public static Iterator<Object[]> genderCombination(){
        List<TestCase> diagnosisList = genderCombination.getDiagnosisList();
       return new ArrayList<Object[]>(){
            {
                for (TestCase diagnosis: diagnosisList) {
                    if(diagnosis.getResult().equals("valid case")) {
                        add(new Object[]{diagnosis});
                    }
                }
            }
        }.iterator();

    }
    @DataProvider(name = "gender combination negative test")
    public static Iterator<Object[]> genderCombinationNegative(){
        List<TestCase> diagnosisList = genderCombination.getDiagnosisList();
        return new ArrayList<Object[]>(){
            {
                for (TestCase diagnosis: diagnosisList) {
                    if(!diagnosis.getResult().equals("valid case")) {
                        add(new Object[]{diagnosis});
                    }
                }
            }
        }.iterator();

    }

    @DataProvider(name = "common info valid cases")
    public static Iterator<Object[]> commonInfoValid(){
        List<TestCase> testCases = parserFirstSheet.getTestCases();
        return new ArrayList<Object[]>(){
            {
                for (TestCase testCase: testCases) {
                    if(testCase.getResult().equalsIgnoreCase("valid case")) {
                        add(new Object[]{testCase});
                    }
                }
            }
        }.iterator();

    }
    @DataProvider(name = "common info")
    public static Iterator<Object[]> commonInfo(){
        List<TestCase> testCases = parserFirstSheet.getTestCases();
        return new ArrayList<Object[]>(){
            {
                for (TestCase testCase: testCases) {
                    if(!testCase.getResult().equalsIgnoreCase("valid case")) {
                        add(new Object[]{testCase});
                    }
                }
            }
        }.iterator();

    }

}