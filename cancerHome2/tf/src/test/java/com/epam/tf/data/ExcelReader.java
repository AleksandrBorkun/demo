package com.epam.tf.data;


import com.epam.tf.data.parser.UserDataXlsxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ExcelReader {
    private static final Logger log = LogManager.getRootLogger();
    private static Map<String, PassportData> passportDataMap = new HashMap<String, PassportData>();
    private static Map<String, DispensaryData> dispensaryDataMap = new HashMap<String, DispensaryData>();
    private static Map<String,Object[]> userDataMap = new HashMap<>();
    private static List<Diagnosis> diagnosisList = new ArrayList<Diagnosis>();
    private static List<ClinicalGroups> clinicalGroupsList = new ArrayList<ClinicalGroups>();
    private static List<ClinicalExamination> clinicalExaminationList = new ArrayList<ClinicalExamination>();
    private static final String FILE_PATH = "src\\test\\resources\\test_data_library.xlsx";



    private static void readInfo() {
        try {
            UserDataXlsxParser.parseXlsx(FILE_PATH);
            passportDataMap = UserDataXlsxParser.getPassportDataMap();
            dispensaryDataMap = UserDataXlsxParser.getDispensaryDataMap();
            diagnosisList = UserDataXlsxParser.getDiagnosisList();
            clinicalGroupsList = UserDataXlsxParser.getClinicalGroupsList();
            clinicalExaminationList = UserDataXlsxParser.getClinicalExaminationList();
            Set<String> keys = passportDataMap.keySet();
            for(String key:keys){
                Object[] user = new Object[]{getPassportData(key), getDispensaryData(key), getDiagnosis(key),
                        getClinicalGroups(key), getClinicalExamination(key)};
                userDataMap.put(key,user);
            }
        } catch (Exception e) {
            log.error("Parsing fails: " + e.getMessage());
        }
    }

    public static Object[] getUserData(String patientCardNumber){
        readInfo();
        if(userDataMap.get(patientCardNumber)==null){
            throw new NullPointerException("There is no patient with such card number");
        }
        return userDataMap.get(patientCardNumber);
    }


    private static PassportData getPassportData(String patientCardNumber) {
        return passportDataMap.get(patientCardNumber);
    }

    private static DispensaryData getDispensaryData(String patientCardNumber) {
        return dispensaryDataMap.get(patientCardNumber);
    }

    private static Map<String,Diagnosis> getDiagnosis(String patientCardNumber) {
        Map<String,Diagnosis> returned = new HashMap<>();
        for (Diagnosis diagnosis : diagnosisList) {
            if (diagnosis.getPatientCardNumber().equals(patientCardNumber)){
                returned.put(diagnosis.getDiagnosisDate(),diagnosis);
            }
        }
        return returned;
    }

    private static Map<String,ClinicalGroups> getClinicalGroups(String patientCardNumber) {
        Map<String, ClinicalGroups> returned = new HashMap<>();
        for (ClinicalGroups groups : clinicalGroupsList) {
            if (groups.getPatientCardNumber().equals(patientCardNumber)){
                returned.put(groups.getDateOfChange(),groups);
            }
        }
        return returned;
    }

    private static Map<String,ClinicalExamination> getClinicalExamination(String patientCardNumber) {
        Map<String,ClinicalExamination> returned = new HashMap<>();
        for (ClinicalExamination examination : clinicalExaminationList) {
            if (examination.getPatientCardNumber().equals(patientCardNumber)){
                returned.put(examination.getLastContactDate(),examination);
            }
        }
        return returned;
    }
}
