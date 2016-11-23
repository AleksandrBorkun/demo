package com.epam.tf.data.parser;

import com.epam.tf.data.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class UserDataXlsxParser {
    private static final Logger log = LogManager.getRootLogger();
    private static Map<String,PassportData> passportDataMap = new HashMap<String, PassportData>();
    private static Map<String,DispensaryData> dispensaryDataMap = new HashMap<String, DispensaryData>();
    private static List<Diagnosis> diagnosisList = new ArrayList<Diagnosis>();
    private static List<ClinicalGroups> clinicalGroupsList = new ArrayList<ClinicalGroups>();
    private static List<ClinicalExamination> clinicalExaminationList = new ArrayList<ClinicalExamination>();

    public static void parseXlsx(String path) {
        InputStream inputStream;
        XSSFWorkbook workbook;
        try {
            inputStream = new FileInputStream(path);
            workbook = new XSSFWorkbook(inputStream);
            parsePassportData(workbook.getSheetAt(0));
            parseDiagnosis(workbook.getSheetAt(1));
            parseClinicalGroup(workbook.getSheetAt(2));
            parseClinicalExamination(workbook.getSheetAt(3));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private static void parsePassportData(Sheet sheet){
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            PassportData passportData = new PassportData();
            DispensaryData dispensaryData = new DispensaryData();
            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cellCounter){
                    case 1:
                        passportData.setPersonalNumber(cell.getStringCellValue());
                        dispensaryData.setPersonalNumber(cell.getStringCellValue());
                        break;
                    case 2:
                        passportData.setPatientCardNumber(cell.getStringCellValue());
                        dispensaryData.setPatientCardNumber(cell.getStringCellValue());
                        break;
                    case 3:
                        passportData.setSurname(cell.getStringCellValue());
                        break;
                    case 4:
                        passportData.setName(cell.getStringCellValue());
                        break;
                    case 5:
                        passportData.setPatronymic(cell.getStringCellValue());
                        break;
                    case 6:
                        passportData.setBirthday(cell.getStringCellValue());
                        break;
                    case 7:
                        passportData.setTakeAccountOfDate(cell.getStringCellValue());
                        break;
                    case 8:
                        passportData.setDispensary(cell.getStringCellValue());
                        break;
                    case 9:
                        passportData.setIdn(cell.getStringCellValue());
                        break;
                    case 10:
                        passportData.setSex(cell.getStringCellValue());
                        break;
                    case 11:
                        passportData.setCurrentCondition(cell.getStringCellValue());
                        break;
                    case 12:
                        passportData.setCitizen(cell.getStringCellValue());
                        break;
                    case 13:
                        passportData.setCodeTersone(cell.getStringCellValue());
                        break;
                    case 14:
                        passportData.setPostCode(cell.getStringCellValue());
                        break;
                    case 15:
                        passportData.setStreet(cell.getStringCellValue());
                        break;
                    case 16:
                        passportData.setHouse(cell.getStringCellValue());
                        break;
                    case 17:
                        passportData.setHousing(cell.getStringCellValue());
                        break;
                    case 18:
                        passportData.setFlat(cell.getStringCellValue());
                        break;
                    case 19:
                        passportData.setPhone(cell.getStringCellValue());
                        break;
                    case 20:
                        dispensaryData.setDispensaryCode(cell.getStringCellValue());
                        break;
                    case 21:
                        dispensaryData.setPoliclinic(cell.getStringCellValue());
                        break;
                    case 22:
                        dispensaryData.setBeforeCondition(cell.getStringCellValue());
                        break;
                    case 23:
                        dispensaryData.setInvalidGroup(cell.getStringCellValue());
                        break;
                    case 24:
                        dispensaryData.setPrivilegesCategory(cell.getStringCellValue());
                        break;
                    case 25:
                        dispensaryData.setPosition(cell.getStringCellValue());
                        break;
                    case 26:
                        dispensaryData.setAdditionInfo(cell.getStringCellValue());
                        break;
                    case 27:
                        dispensaryData.setNationality(cell.getStringCellValue());
                        break;
                    case 28:
                        dispensaryData.setAccountingGroup(cell.getStringCellValue());
                        break;
                    case 29:
                        dispensaryData.setIdnInTheAsoigr(cell.getStringCellValue());
                        break;
                    case 30:
                        dispensaryData.setPlaceOfResidenceAtAccidentTime(cell.getStringCellValue());
                        break;
                    case 31:
                        dispensaryData.setDateOfDeath(cell.getStringCellValue());
                        break;
                    case 32:
                        dispensaryData.setPipeline(cell.getStringCellValue());
                        break;
                    case 33:
                        dispensaryData.setRetired(cell.getStringCellValue());
                        break;
                    case 34:
                        dispensaryData.setAdditionalInformationAboutRetire(cell.getStringCellValue());
                        break;
                    case 35:
                        dispensaryData.setCauseOfDeath(cell.getStringCellValue());
                        break;
                    case 36:
                        dispensaryData.setCauseOfDeathText(cell.getStringCellValue());
                        break;
                    case 37:
                        dispensaryData.setNameOfTheSignerCertificateOfDeath(cell.getStringCellValue());
                        break;
                    case 38:
                        dispensaryData.setPresenceOfOpening(cell.getStringCellValue());
                        break;
                }
                cellCounter++;
            }
            passportDataMap.put(passportData.getPatientCardNumber(),passportData);
            dispensaryDataMap.put(dispensaryData.getPatientCardNumber(),dispensaryData);
        }
    }

    private static void parseDiagnosis(Sheet sheet){
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Diagnosis diagnosis = new Diagnosis();
            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cellCounter){
                    case 1:
                        diagnosis.setPatientCardNumber(cell.getStringCellValue());
                        break;
                    case 2:
                        diagnosis.setPersonalNumber(cell.getStringCellValue());
                        break;
                    case 3:
                        diagnosis.setDiagnosisAccordingToICD10(cell.getStringCellValue());
                        break;
                    case 4:
                        diagnosis.setCodeICD10(cell.getStringCellValue());
                        break;
                    case 5:
                        diagnosis.setCodeICD19(cell.getStringCellValue());
                        break;
                    case 6:
                        diagnosis.setDiagnosisDate(cell.getStringCellValue());
                        break;
                    case 7:
                        diagnosis.setDiagnosisCancelDate(cell.getStringCellValue());
                        break;
                    case 8:
                        diagnosis.setPairingSymptom(cell.getStringCellValue());
                        break;
                    case 9:
                        diagnosis.setPregnancy(cell.getStringCellValue());
                        break;
                    case 10:
                        diagnosis.setDiagnosisText(cell.getStringCellValue());
                        break;
                    case 11:
                        diagnosis.setSourceOfdiagnosisInfo(cell.getStringCellValue());
                        break;
                    case 12:
                        diagnosis.setCamePlace(cell.getStringCellValue());
                        break;
                    case 13:
                        diagnosis.setPlaceOfResidenceAtAccidentTime(cell.getStringCellValue());
                        break;
                    case 14:
                        diagnosis.setAdditionalInfo(cell.getStringCellValue());
                        break;
                    case 15:
                        diagnosis.setPhase(cell.getStringCellValue());
                        break;
                    case 16:
                        diagnosis.setPhaseEnding(cell.getStringCellValue());
                        break;
                    case 17:
                        diagnosis.setRefinementPhase(cell.getStringCellValue());
                        break;
                    case 18:
                        diagnosis.setRefinementPhaseEnding(cell.getStringCellValue());
                        break;
                    case 19:
                        diagnosis.setT(cell.getStringCellValue());
                        break;
                    case 20:
                        diagnosis.setN(cell.getStringCellValue());
                        break;
                    case 21:
                        diagnosis.setM(cell.getStringCellValue());
                        break;
                    case 22:
                        diagnosis.setMultiplicity(cell.getStringCellValue());
                        break;
                    case 23:
                        diagnosis.setRevealingTerms(cell.getStringCellValue());
                        break;
                    case 24:
                        diagnosis.setConfirmationMethod(cell.getStringCellValue());
                        break;
                    case 25:
                        diagnosis.setICD10morphology(cell.getStringCellValue());
                        break;
                    case 26:
                        diagnosis.setDifferentiationDegree(cell.getStringCellValue());
                        break;
                    case 27:
                        diagnosis.setMorphologyText(cell.getStringCellValue());
                        break;
                    case 28:
                        diagnosis.setMorphologicalStudyRate(cell.getStringCellValue());
                        break;
                    case 29:
                        diagnosis.setDateOfExamination(cell.getStringCellValue());
                        break;
                }
                cellCounter++;
            }
            diagnosisList.add(diagnosis);
        }
    }

    private static void parseClinicalGroup(Sheet sheet){
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            ClinicalGroups clinicalGroups = new ClinicalGroups();
            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cellCounter){
                    case 1:
                        clinicalGroups.setPersonalNumber(cell.getStringCellValue());
                        break;
                    case 2:
                        clinicalGroups.setPatientCardNumber(cell.getStringCellValue());
                        break;
                    case 3:
                        clinicalGroups.setClinicalGroup(cell.getStringCellValue());
                        break;
                    case 4:
                        clinicalGroups.setDateOfChange(cell.getStringCellValue());
                        break;
                }
                cellCounter++;
            }
            clinicalGroupsList.add(clinicalGroups);
        }
    }

    private static void parseClinicalExamination(Sheet sheet){
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            ClinicalExamination clinicalExamination = new ClinicalExamination();
            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cellCounter){
                    case 1:
                        clinicalExamination.setPersonalNumber(cell.getStringCellValue());
                        break;
                    case 2:
                        clinicalExamination.setPatientCardNumber(cell.getStringCellValue());
                        break;
                    case 3:
                        clinicalExamination.setLastContactDate(cell.getStringCellValue());
                        break;
                    case 4:
                        clinicalExamination.setContactIndication(cell.getStringCellValue());
                        break;
                    case 5:
                        clinicalExamination.setControlForm(cell.getStringCellValue());
                        break;
                    case 6:
                        clinicalExamination.setControlTime(cell.getStringCellValue());
                        break;
                    case 7:
                        clinicalExamination.setWherePatientCame(cell.getStringCellValue());
                        break;
                    case 8:
                        clinicalExamination.setControlDate(cell.getStringCellValue());
                        break;
                    case 9:
                        clinicalExamination.setWherePatientDirected(cell.getStringCellValue());
                        break;
                }
                cellCounter++;
            }
            clinicalExaminationList.add(clinicalExamination);
        }
    }
    public static Map<String, PassportData> getPassportDataMap() {
        return passportDataMap;
    }

    public static Map<String, DispensaryData> getDispensaryDataMap() {
        return dispensaryDataMap;
    }

    public static List<Diagnosis> getDiagnosisList() {
        return diagnosisList;
    }

    public static List<ClinicalGroups> getClinicalGroupsList() {
        return clinicalGroupsList;
    }

    public static List<ClinicalExamination> getClinicalExaminationList() {
        return clinicalExaminationList;
    }
}