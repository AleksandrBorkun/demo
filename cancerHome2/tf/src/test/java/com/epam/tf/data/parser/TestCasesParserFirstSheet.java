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
 * Created by Nikolay_Golubitsky on 12/1/2016.
 */
public class TestCasesParserFirstSheet {

    private final static String SHEET = "Вал Общих сведений о диагнозе ";
    private final static String FILE_PATH = "xlsxDocument";
    private static final Logger LOG = LogManager.getRootLogger();
    private List<TestCase> testCases = new ArrayList<>();

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public TestCasesParserFirstSheet(){
        InputStream inputStream;
        XSSFWorkbook workbook;

        try {
            inputStream = new FileInputStream(PropertyProvider.getProperty(FILE_PATH));
            workbook = new XSSFWorkbook(inputStream);
            parse(workbook.getSheet(SHEET));
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

    }
    private void parse(Sheet sheet){
        int testCaseNumber = 1;
        for (Row row : sheet) {
            if (row.getRowNum() < 2) {
                continue;
            }
            TestCase testCase = new TestCase();
            testCase.setTestCaseNumber(testCaseNumber);
            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.setCellType(Cell.CELL_TYPE_STRING);
                switch (cellCounter){
                    case 1:
                        testCase.setMkb10(cell.getStringCellValue().replace(".", ""));
                        break;
                    case 2:
                        testCase.setMkb9(cell.getStringCellValue());
                        break;
                    case 3:
                        testCase.setDateDiag(cell.getStringCellValue());
                        break;
                    case 4:
                        testCase.setDateDiagCan(cell.getStringCellValue());
                        break;
                    case 5:
                        testCase.setSignP(cell.getStringCellValue());
                        break;
                    case 6:
                        testCase.setPregnancyBegin(cell.getStringCellValue());
                        break;
                    case 7:
                        testCase.setDiagnosisText(cell.getStringCellValue());
                        break;
                    case 8:
                        testCase.setSourceInf(cell.getStringCellValue());
                        break;
                    case 9:
                        testCase.setFrom(cell.getStringCellValue());
                        break;
                    case 10:
                        testCase.setHomeAddress(cell.getStringCellValue());
                        break;
                    case 11:
                        testCase.setExtraText(cell.getStringCellValue());
                        break;
                    case 12:
                        testCase.setStage(cell.getStringCellValue());
                        break;
                    case 13:
                        testCase.setFinalStage(cell.getStringCellValue());
                        break;
                    case 14:
                        testCase.setSpecificationStage(cell.getStringCellValue());
                        break;
                    case 15:
                        testCase.setFinalSpecificationStage(cell.getStringCellValue());
                        break;
                    case 16:
                        testCase.setT(cell.getStringCellValue());
                        break;
                    case 17:
                        testCase.setN(cell.getStringCellValue());
                        break;
                    case 18:
                        testCase.setM(cell.getStringCellValue());
                        break;
                    case 19:
                        testCase.setPlurality(cell.getStringCellValue());
                        break;
                    case 20:
                        testCase.setDetectionRules(cell.getStringCellValue());
                        break;
                    case 21:
                        testCase.setAcceptMethod(cell.getStringCellValue());
                        break;
                    case 22:
                        testCase.setMorphology(cell.getStringCellValue());
                        break;
                    case 23:
                        testCase.setStageDif(cell.getStringCellValue());
                        break;
                    case 24:
                        testCase.setMorphologyText(cell.getStringCellValue());
                        break;
                    case 25:
                        testCase.setMorphologyNumber(cell.getStringCellValue());
                        break;
                    case 26:
                        testCase.setPregnancy(cell.getStringCellValue());
                        break;
                    case 27:
                        testCase.setCarriageDate(cell.getStringCellValue());
                        break;
                    case 28:
                        testCase.setSex(cell.getStringCellValue());
                        break;
                    case 29:
                        testCase.setNowStage(cell.getStringCellValue());
                        break;
                    case 30:
                        testCase.setResult(cell.getStringCellValue());
                        break;
                    case 31:
                        testCase.setScenarioDescription(cell.getStringCellValue());
                        break;
                }
                cellCounter++;

            }
            if (!testCase.getResult().equals(""))
            {
                testCases.add(testCase);
            }
            testCaseNumber++;
        }
    }
}
