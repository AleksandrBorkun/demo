package com.epam.tf.data.parser;

import com.epam.tf.entity.ListOfCombinationOfAges;
import com.epam.tf.entity.Patient;
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
 * @author Dzmitry_Bets on 12/5/2016.
 * This class gives possibility to parse our xlsx file with
 * test cases. It fill in {@code TestCase} and {@code Patiend}
 * all data wich we need for age comdination tests
 *
 */

public class TestCasesParserThirdSheet {

    private final static String SHEET = "Вал сочетания Возраста ";
    private final static String FILE_PATH = "xlsxDocument";
    private static final Logger LOG = LogManager.getRootLogger();
    private List<ListOfCombinationOfAges> listOfCombinationAges = new ArrayList<>();

    public List<ListOfCombinationOfAges> getListOfCombinationAges(){
        return listOfCombinationAges;
    }

    public TestCasesParserThirdSheet(){
        InputStream inputStream;
        XSSFWorkbook workbook;

        try {
            inputStream = new FileInputStream(PropertyProvider.getProperty(FILE_PATH));
            workbook = new XSSFWorkbook(inputStream);
            doParse(workbook.getSheet(SHEET));
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

    }

    /**
     * Parse third sheet of xlsx document
     * @param sheet is current sheet of xlsx document
     */

    private void doParse(Sheet sheet){
        for (Row row : sheet) {
            if (row.getRowNum() < 1) {
                continue;
            }
            TestCase testCase = new TestCase();
            Patient patient = new Patient();

            ListOfCombinationOfAges listOfCombinationOfAges = new ListOfCombinationOfAges();

            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                cell.setCellType(Cell.CELL_TYPE_STRING);
                switch (cellCounter){
                    case 1:
                        patient.setIdn(new Long(cell.getStringCellValue()));
                        break;
                    case 2:
                        patient.setLastName(cell.getStringCellValue().trim());
                        break;
                    case 3:
                        patient.setFirstName(cell.getStringCellValue().trim());
                        break;
                    case 4:
                        patient.setPatrName(cell.getStringCellValue().trim());
                        break;
                    case 5:
                        patient.setBirthDay(cell.getStringCellValue().replace(".", ""));
                        break;
                    case 6:
                        listOfCombinationOfAges.setDiagnosisText(cell.getStringCellValue());
                        break;
                    case 7:
                        listOfCombinationOfAges.setMKB10(cell.getStringCellValue());
                        break;
                    case 8:
                        listOfCombinationOfAges.setMKB9(cell.getStringCellValue());
                        break;
                    case 9:
                        listOfCombinationOfAges.setDiagnosisDate(cell.getStringCellValue());
                        break;
                    case 10:
                        listOfCombinationOfAges.setCancelDiagnosisDate(cell.getStringCellValue());
                        break;
                    case 11:
                        listOfCombinationOfAges.setPairing(cell.getStringCellValue());
                        break;
                    case 12:
                        listOfCombinationOfAges.setPregnancy(cell.getStringCellValue());
                        break;
                    case 13:
                        listOfCombinationOfAges.setDiagnosisText(cell.getStringCellValue());
                        break;
                    case 14:
                        listOfCombinationOfAges.setDiagnosisInformationSource(cell.getStringCellValue());
                        break;
                    case 15:
                        listOfCombinationOfAges.setDiagnosisInformationFrom(cell.getStringCellValue());
                        break;
                    case 16:
                        listOfCombinationOfAges.setLivingPlace(cell.getStringCellValue());
                        break;
                    case 17:
                        listOfCombinationOfAges.setAdditionalText(cell.getStringCellValue());
                        break;
                    case 18:
                        listOfCombinationOfAges.setStage(cell.getStringCellValue());
                        break;
                    case 19:
                        listOfCombinationOfAges.setFinalStage(cell.getStringCellValue());
                        break;
                    case 20:
                        listOfCombinationOfAges.setElaborationStage(cell.getStringCellValue());
                        break;
                    case 21:
                        listOfCombinationOfAges.setFinalElaborationStage(cell.getStringCellValue());
                        break;
                    case 22:
                        listOfCombinationOfAges.setT(cell.getStringCellValue());
                        break;
                    case 23:
                        listOfCombinationOfAges.setN(cell.getStringCellValue());
                        break;
                    case 24:
                        listOfCombinationOfAges.setM(cell.getStringCellValue());
                        break;
                    case 25:
                        listOfCombinationOfAges.setMultiplicity(cell.getStringCellValue());
                        break;
                    case 26:
                        listOfCombinationOfAges.setDetection(cell.getStringCellValue());
                        break;
                    case 27:
                        listOfCombinationOfAges.setConfirmationMethod(cell.getStringCellValue());
                        break;
                    case 28:
                        listOfCombinationOfAges.setMorphology(cell.getStringCellValue());
                        break;
                    case 29:
                        listOfCombinationOfAges.setDifferentiationDegree(cell.getStringCellValue());
                        break;
                    case 30:
                        listOfCombinationOfAges.setNumberOfMorphologyStudies(cell.getStringCellValue());
                        break;
                    case 31:
                        listOfCombinationOfAges.setDateOf(cell.getStringCellValue());
                        break;
                    case 32:
                        listOfCombinationOfAges.setResult(cell.getStringCellValue());
                        break;
                    case 33:
                        listOfCombinationOfAges.setScenarioDescription(cell.getStringCellValue());
                        break;
                }
                cellCounter++;
            }

            if (listOfCombinationOfAges.getResult() != null){
                listOfCombinationAges.add(listOfCombinationOfAges);
            }

        }
    }

}
