package com.epam.tf.data.parser;

import com.epam.tf.entity.Patient;
import com.epam.tf.entity.TestCase;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;


/**
 * Created by Nikolay_Golubitsky on 12/1/2016.
 */
public class TestCasesParserTreatmentInfo extends Parser {

    private final static String SHEET = "Вал Общих сведений о диагнозе ";

    public TestCasesParserTreatmentInfo(){
        super(SHEET);
    }

    protected void parse(Sheet sheet){
        int testCaseNumber = 1;
        for (Row row : sheet) {
            if (row.getRowNum() < 2) {
                continue;
            }
            TestCase testCase = new TestCase();
            testCase.setPatient(new Patient());
            testCase.setTestCaseNumber(testCaseNumber);
            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.setCellType(Cell.CELL_TYPE_STRING);
                switch (cellCounter){
                    case 1:
                        testCase.setMkb10(getValue(cell).replace(".", ""));
                        break;
                    case 2:
                        testCase.setMkb9(getValue(cell));
                        break;
                    case 3:
                        testCase.setDateDiag(getValue(cell));
                        break;
                    case 4:
                        testCase.setDateDiagCan(getValue(cell));
                        break;
                    case 5:
                        testCase.setSignP(getValue(cell));
                        break;
                    case 6:
                        testCase.setPregnancyBegin(getValue(cell));
                        break;
                    case 7:
                        testCase.setDiagnosisText(getValue(cell));
                        break;
                    case 8:
                        testCase.setSourceInf(getValue(cell));
                        break;
                    case 9:
                        testCase.setFrom(getValue(cell));
                        break;
                    case 10:
                        testCase.setHomeAddress(getValue(cell));
                        break;
                    case 11:
                        testCase.setExtraText(getValue(cell));
                        break;
                    case 12:
                        testCase.setStage(getValue(cell));
                        break;
                    case 13:
                        testCase.setFinalStage(getValue(cell));
                        break;
                    case 14:
                        testCase.setSpecificationStage(getValue(cell));
                        break;
                    case 15:
                        testCase.setFinalSpecificationStage(getValue(cell));
                        break;
                    case 16:
                        testCase.setT(getValue(cell));
                        break;
                    case 17:
                        testCase.setN(getValue(cell));
                        break;
                    case 18:
                        testCase.setM(getValue(cell));
                        break;
                    case 19:
                        testCase.setPlurality(getValue(cell));
                        break;
                    case 20:
                        testCase.setDetectionRules(getValue(cell));
                        break;
                    case 21:
                        testCase.setAcceptMethod(getValue(cell));
                        break;
                    case 22:
                        testCase.setMorphology(getValue(cell));
                        break;
                    case 23:
                        testCase.setStageDif(getValue(cell));
                        break;
                    case 24:
                        testCase.setMorphologyText(getValue(cell));
                        break;
                    case 25:
                        testCase.setMorphologyNumber(getValue(cell));
                        break;
                    case 26:
                        testCase.setPregnancy(getValue(cell));
                        break;
                    case 27:
                        testCase.setCarriageDate(getValue(cell));
                        break;
                    case 28:
                        String sex = getValue(cell);
                        if (!sex.equals("") || sex.contains("Женский")){
                            testCase.getPatient().setSex((byte) 2);
                        } else {
                            testCase.getPatient().setSex((byte) 1);
                        }
                        break;
                    case 29:
                        testCase.getPatient().setState(getValue(cell));
                        break;
                    case 30:
                        testCase.setResult(getValue(cell));
                        break;
                    case 31:
                        testCase.setScenarioDescription(getValue(cell));
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
