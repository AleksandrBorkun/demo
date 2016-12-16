package com.epam.tf.data.parser;

import com.epam.tf.entity.TestCase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;

/**
 * Created by Ihar_Hukau on 12/1/2016.
 */

public class TestCasesParserDataGenderCombinationXlsx extends Parser {
    private final static String SHEET = "Вал комбинации Пола";


    public TestCasesParserDataGenderCombinationXlsx(){
        super(SHEET);
    }

    protected void parse(Sheet sheet){
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
                            String sex = getValue(cell).trim();
                            if(sex.equals("М")) {
                                testCase.setSex("1 - мужской");
                            } else if(sex.equals("Ж")) {
                                testCase.setSex("2 - женский");
                            }
                            break;
                        case 2:
                            testCase.setMkb10(getValue(cell).replace(".", "").trim());
                            break;
                        case 3:
                            testCase.setMkb9(getValue(cell));
                        case 4:
                            testCase.setDateDiag(getValue(cell).replace(".", "").trim());
                            break;
                        case 5:
                            testCase.setDateDiagCan(getValue(cell).replace(".", "").trim());
                            break;
                        case 6:
                            testCase.setSignP(getValue(cell));
                            break;
                        case 7:
                            testCase.setPregnancyBegin(getValue(cell));
                            break;
                        case 8:
                            testCase.setDiagnosisText(getValue(cell));
                            break;
                        case 9:
                            testCase.setSourceInf(getValue(cell));
                            break;
                        case 10:
                            testCase.setFrom(getValue(cell));
                            break;
                        case 11:
                            testCase.setHomeAddress(getValue(cell));
                            break;
                        case 12:
                            testCase.setExtraText(getValue(cell));
                            break;
                        case 13:
                            testCase.setStage(getValue(cell));
                            break;
                        case 14:
                            testCase.setFinalStage(getValue(cell));
                            break;
                        case 15:
                            testCase.setSpecificationStage(getValue(cell));
                            break;
                        case 16:
                            testCase.setFinalSpecificationStage(getValue(cell));
                            break;
                        case 17:
                            testCase.setT(getValue(cell));
                            break;
                        case 18:
                            testCase.setN(getValue(cell));
                            break;
                        case 19:
                            testCase.setM(getValue(cell));
                            break;
                        case 20:
                            testCase.setPlurality(getValue(cell));
                            break;
                        case 21:
                            testCase.setDetectionRules(getValue(cell));
                            break;
                        case 22:
                            testCase.setAcceptMethod(getValue(cell));
                            break;
                        case 23:
                            testCase.setMorphology(getValue(cell));
                            break;
                        case 24:
                            testCase.setStageDif(getValue(cell));
                            break;
                        case 25:
                            testCase.setMorphologyText(getValue(cell));
                            break;
                        case 26:
                            testCase.setMorphologyNumber(getValue(cell));
                            break;
                        case 27:
                            testCase.setCarriageDate(getValue(cell).replace(".", ""));
                            break;
                        case 28:
                            testCase.setResult(getValue(cell));
                            break;
                    }
                    cellCounter++;
            }
            if(testCase.getSex() != null) {
                testCases.add(testCase);
            }
        }
    }
}
