package com.epam.tf.data.parser;

import com.epam.tf.entity.TestCase;
import com.epam.tf.entity.Treatment;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;


/**
 * Created by Kiryl_Shyshko on 12/1/2016.
 */
public class TestCasesParserTreatment extends Parser {

    private final static String SHEET = "Val for Lecheniya";

    public TestCasesParserTreatment() {

        super(SHEET);

    }

    protected void parse(Sheet sheet) {
        for (Row row : sheet) {
            if (row.getRowNum() < 2) {
                continue;
            }
            TestCase testCase = new TestCase();
            testCase.setTreatment(new Treatment());


            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.setCellType(Cell.CELL_TYPE_STRING);
                switch (cellCounter) {
                    case 1:
                        testCase.getTreatment().setBeginTreatmentDate(getValue(cell));
                        break;
                    case 2:
                        testCase.getTreatment().setEndingTreatmentDate(getValue(cell));
                        break;
                    case 3:
                        testCase.getTreatment().setTreatmentInfo(getValue(cell));
                        break;
                    case 4:
                        testCase.getTreatment().setTreatmentNature(getValue(cell));
                        break;
                    case 5:
                        testCase.getTreatment().setSpecialTreatmentType(getValue(cell));
                        break;
                    case 6:
                        testCase.getTreatment().setTypeOZ(getValue(cell));
                        break;
                    case 7:
                        testCase.getTreatment().setTreatmentPlace(getValue(cell));
                        break;
                    case 8:
                        testCase.getTreatment().setIncompleteTreatmentReason(getValue(cell));
                        break;
                    case 9:
                        testCase.getTreatment().setMedicalHistoryNumber(getValue(cell));
                        break;
                    case 10:
                        testCase.getTreatment().setAnnotation(getValue(cell));
                        break;
                    case 11:
                        testCase.getTreatment().setCodeType(getValue(cell));
                        break;
                    case 12:
                        testCase.getTreatment().setCode(getValue(cell));
                        break;

                }
                cellCounter++;

            }

            if (!testCase.getTreatment().getCode().equals("")) {
                testCases.add(testCase);
            }
        }
    }

}
