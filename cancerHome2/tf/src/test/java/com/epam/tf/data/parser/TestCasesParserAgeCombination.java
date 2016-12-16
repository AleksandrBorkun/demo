package com.epam.tf.data.parser;


import com.epam.tf.entity.Patient;
import com.epam.tf.entity.TestCase;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;


/**
 * @author Dzmitry_Bets on 12/5/2016.
 * This class gives possibility to parse our xlsx file with
 * test cases. It fill in {@code TestCase} and {@code Patiend}
 * all data wich we need for age comdination tests
 *
 */

public class TestCasesParserAgeCombination extends Parser {

    private final static String SHEET = "Вал сочетания Возраста ";


    public TestCasesParserAgeCombination(){
        super(SHEET);
    }

    /**
     * Parse third sheet of xlsx document
     * @param sheet is current sheet of xlsx document
     */

    protected void parse(Sheet sheet){
        for (Row row : sheet) {
            if (row.getRowNum() < 1) {
                continue;
            }
            TestCase testCase = new TestCase();
            testCase.setPatient(new Patient());

            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                cell.setCellType(Cell.CELL_TYPE_STRING);
                switch (cellCounter){
                    case 1:
                        testCase.getPatient().setPersonalNumber(getValue(cell));
                        break;
                    case 2:
                        testCase.getPatient().setLastName(getValue(cell));
                        break;
                    case 3:
                        testCase.getPatient().setFirstName(getValue(cell));
                        break;
                    case 4:
                        testCase.getPatient().setPatrName(getValue(cell));
                        break;
                    case 5:
                        testCase.getPatient().setBirthDay(getValue(cell).replace(".", ""));
                        break;
                    case 6:
                        testCase.setMkb10(getValue(cell));
                        break;
                    case 7:
                        testCase.setMkb9(getValue(cell));
                        break;
                    case 8:
                        testCase.setDateDiag(getValue(cell).replace(".", ""));
                        break;
                    case 9:
                        testCase.setDateDiagCan(getValue(cell).replace(".", ""));
                        break;
                    case 10:
                        testCase.setSignP(getValue(cell));
                        break;
                    case 11:
                        testCase.setPregnancy(getValue(cell));
                        break;
                    case 12:
                        testCase.setDiagnosisText(getValue(cell));
                        break;
                    case 13:
                        testCase.setSourceInf(getValue(cell));
                        break;
                    case 14:
                        testCase.setFrom(getValue(cell));
                        break;
                    case 15:
                        testCase.setHomeAddress(getValue(cell));
                        break;
                    case 16:
                        testCase.setExtraText(getValue(cell));
                        break;
                    case 17:
                        testCase.setStage(getValue(cell));
                        break;
                    case 18:
                        testCase.setFinalStage(getValue(cell));
                        break;
                    case 19:
                        testCase.setSpecificationStage(getValue(cell));
                        break;
                    case 20:
                        testCase.setFinalSpecificationStage(getValue(cell));
                        break;
                    case 21:
                        testCase.setT(getValue(cell));
                        break;
                    case 22:
                        testCase.setN(getValue(cell));
                        break;
                    case 23:
                        testCase.setM(getValue(cell));
                        break;
                    case 24:
                        testCase.setPlurality(getValue(cell));
                        break;
                    case 25:
                        testCase.setDetectionRules(getValue(cell));
                        break;
                    case 26:
                        testCase.setAcceptMethod(getValue(cell));
                        break;
                    case 27:
                        testCase.setMorphology(getValue(cell));
                        break;
                    case 28:
                        testCase.setStageDif(getValue(cell));
                        break;
                    case 29:
                        testCase.setMorphologyText(getValue(cell));
                        break;
                    case 30:
                        testCase.setMorphologyNumber(getValue(cell));
                        break;
                    case 31:
                        testCase.setCarriageDate(getValue(cell));
                        break;
                    case 32:
                        testCase.setResult(getValue(cell));
                        break;
                    case 33:
                        testCase.setScenarioDescription(getValue(cell));
                        break;
                }
                cellCounter++;
            }

            if (testCase.getResult() != null){
                testCases.add(testCase);
            }

        }
    }

}
