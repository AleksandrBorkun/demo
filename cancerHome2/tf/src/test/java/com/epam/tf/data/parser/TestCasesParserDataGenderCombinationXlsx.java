package com.epam.tf.data.parser;

import com.epam.tf.entity.TestCase;
import com.epam.tf.property.PropertyProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ihar_Hukau on 12/1/2016.
 */
public class TestCasesParserDataGenderCombinationXlsx {
    private final static String SHEET = "Вал комбинации Пола";
    private final static String FILE_PATH = "xlsxDocument";
    private static final Logger LOG = LogManager.getRootLogger();
    private List<TestCase> testCaseList = new ArrayList<>();

    public List<TestCase> getDiagnosisList () {
        return testCaseList;
    }

    public TestCasesParserDataGenderCombinationXlsx(){
        InputStream inputStream;
        XSSFWorkbook workbook;

        try {
            inputStream = new FileInputStream(PropertyProvider.getProperty(FILE_PATH));
            workbook = new XSSFWorkbook(inputStream);
            parsePatientDataGender(workbook.getSheet(SHEET));
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

    }
    private void parsePatientDataGender(Sheet sheet){
        for (Row row : sheet) {
            if (row.getRowNum() < 2) {
                continue;
            }
            TestCase testCase = new TestCase();
            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.setCellType(Cell.CELL_TYPE_STRING);
                    switch (cellCounter) {
                        case 1:
                            String sex = cell.getStringCellValue().trim();
                            if(sex.equals("М")) {
                                testCase.setSex("1 - мужской");
                            } else if(sex.equals("Ж")) {
                                testCase.setSex("2 - женский");
                            }
                            break;
                        case 2:
                            testCase.setMkb10(cell.getStringCellValue().replace(".", "").trim());
                            break;
                        case 3:
                            testCase.setMkb9(cell.getStringCellValue().trim());
                        case 4:
                            testCase.setDateDiag(cell.getStringCellValue().replace(".", "").trim());
                            break;
                        case 5:
                            testCase.setDateDiagCan(cell.getStringCellValue().replace(".", "").trim());
                            break;
                        case 6:
                            testCase.setSignP(cell.getStringCellValue().trim());
                            break;
                        case 7:
                            testCase.setPregnancyBegin(cell.getStringCellValue().trim());
                            break;
                        case 8:
                            testCase.setDiagnosisText(cell.getStringCellValue().trim());
                            break;
                        case 9:
                            testCase.setSourceInf(cell.getStringCellValue().trim());
                            break;
                        case 10:
                            testCase.setFrom(cell.getStringCellValue().trim());
                            break;
                        case 11:
                            testCase.setHomeAddress(cell.getStringCellValue().trim());
                            break;
                        case 12:
                            testCase.setExtraText(cell.getStringCellValue().trim());
                            break;
                        case 13:
                            testCase.setStage(cell.getStringCellValue().trim());
                            break;
                        case 14:
                            testCase.setFinalStage(cell.getStringCellValue().trim());
                            break;
                        case 15:
                            testCase.setSpecificationStage(cell.getStringCellValue().trim());
                            break;
                        case 16:
                            testCase.setFinalSpecificationStage(cell.getStringCellValue().trim());
                            break;
                        case 17:
                            testCase.setT(cell.getStringCellValue().trim());
                            break;
                        case 18:
                            testCase.setN(cell.getStringCellValue().trim());
                            break;
                        case 19:
                            testCase.setM(cell.getStringCellValue().trim());
                            break;
                        case 20:
                            testCase.setPlurality(cell.getStringCellValue().trim());
                            break;
                        case 21:
                            testCase.setDetectionRules(cell.getStringCellValue().trim());
                            break;
                        case 22:
                            testCase.setAcceptMethod(cell.getStringCellValue().trim());
                            break;
                        case 23:
                            testCase.setMorphology(cell.getStringCellValue().trim());
                            break;
                        case 24:
                            testCase.setStageDif(cell.getStringCellValue().trim());
                            break;
                        case 25:
                            testCase.setMorphologyText(cell.getStringCellValue().trim());
                            break;
                        case 26:
                            testCase.setMorphologyNumber(cell.getStringCellValue().trim());
                            break;
                        case 27:
                            testCase.setCarriageDate(cell.getStringCellValue().replace(".", "").trim());
                            break;
                        case 28:
                            testCase.setResult(cell.getStringCellValue().trim());
                            break;
                    }
                    cellCounter++;
            }
            if(testCase.getSex() != null) {
                testCaseList.add(testCase);
            }
        }
    }
}
