package com.epam.tf.data.parser;

import com.epam.tf.entity.TestCasesValForTreatment;
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
 * Created by Kiryl_Shyshko on 12/1/2016.
 */
public class TestCasesParserValForTreatmentSheet {

    private final static String SHEET = "Val for Lecheniya";
    private final static String FILE_PATH = "xlsxDocument";
    private static final Logger LOG = LogManager.getRootLogger();
    private List<TestCasesValForTreatment> valForTreatmentList = new ArrayList<>();


    public List<TestCasesValForTreatment> getValForTreatmentList() {
        return valForTreatmentList;
    }

    public TestCasesParserValForTreatmentSheet() {
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

    private void parse(Sheet sheet) {
        for (Row row : sheet) {
            if (row.getRowNum() < 2) {
                continue;
            }
            TestCasesValForTreatment testCase = new TestCasesValForTreatment();


            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.setCellType(Cell.CELL_TYPE_STRING);
                switch (cellCounter) {
                    case 1:
                        testCase.setBeginTreatmentDate(cell.getStringCellValue());
                        break;
                    case 2:
                        testCase.setEndingTreatmentDate(cell.getStringCellValue());
                        break;
                    case 3:
                        testCase.setTreatmentInfo(cell.getStringCellValue());
                        break;
                    case 4:
                        testCase.setTreatmentNature(cell.getStringCellValue());
                        break;
                    case 5:
                        testCase.setSpecialTreatmentType(cell.getStringCellValue());
                        break;
                    case 6:
                        testCase.setTypeOZ(cell.getStringCellValue());
                        break;
                    case 7:
                        testCase.setTreatmentPlace(cell.getStringCellValue());
                        break;
                    case 8:
                        testCase.setIncompleteTreatmentReason(cell.getStringCellValue());
                        break;
                    case 9:
                        testCase.setMedicalHistoryNumber(cell.getStringCellValue());
                        break;
                    case 10:
                        testCase.setAnnotation(cell.getStringCellValue());
                        break;
                    case 11:
                        testCase.setCodeType(cell.getStringCellValue());
                        break;
                    case 12:
                        testCase.setCode(cell.getStringCellValue().trim());
                        break;

                }
                cellCounter++;

            }

            if (!testCase.getCode().equals("")) {
                valForTreatmentList.add(testCase);
            }
        }
    }

}
