package com.epam.tf.data.parser;

/**
 * Created by Nikolay_Golubitsky on 12/14/2016.
 */
public class ParserFactory {

    public enum ParserType{
        PATIENT,
        AGE_COMBINATION,
        GENDER_COMBINATION,
        TO_15,
        TREATMENT,
        COMMON_INFO
    }
    public static Parser getParser(ParserType type){
        Parser parser = null;
        switch (type) {
            case PATIENT:
                parser = new PatientDataXlsxParser();
                break;
            case AGE_COMBINATION:
                parser = new TestCasesParserAgeCombination();
                break;
            case GENDER_COMBINATION:
                parser = new TestCasesParserDataGenderCombinationXlsx();
                break;
            case TO_15:
                parser = new TestCasesParserDiagnosisTo15();
                break;
            case TREATMENT:
                parser = new TestCasesParserTreatment();
                break;
            case COMMON_INFO:
                parser = new TestCasesParserTreatmentInfo();
                break;
        }
        return parser;
    }
}
