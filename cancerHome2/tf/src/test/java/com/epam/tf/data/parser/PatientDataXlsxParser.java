package com.epam.tf.data.parser;

import com.epam.tf.entity.Patient;
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
 * Created by Ihar_Hukau on 11/30/2016.
 */
public class PatientDataXlsxParser {

    private final static String FILE_PATH = "xlsxDocument";
    private final static String SHEET = "Новый пациент";
    private static final Logger LOG = LogManager.getRootLogger();
    public List<Patient> patientList = new ArrayList<Patient>();

    public List<Patient> getPatientList() {
        return patientList;
    }

    public PatientDataXlsxParser() {
        InputStream inputStream;
        XSSFWorkbook workbook;

        try {
            inputStream = new FileInputStream(PropertyProvider.getProperty(FILE_PATH));
            workbook = new XSSFWorkbook(inputStream);
            parsePatientData(workbook.getSheet(SHEET));
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

    }

    private void parsePatientData(Sheet sheet) {
        for (Row row : sheet) {
            if (row.getRowNum() < 2) {
                continue;
            }
            Patient patient = new Patient();
            int cellCounter = 1;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.setCellType(Cell.CELL_TYPE_STRING);
                if (cell.getStringCellValue().equals("")){
                    continue;
                }
                if (cell.getStringCellValue().equals("")) {
                    continue;
                }
                switch (cellCounter) {
                    case 1:
                        break;

                    case 2:
                        patient.setPersonalNumber(cell.getStringCellValue());
                        break;
                    case 3:
                        patient.setLastName(cell.getStringCellValue().trim());
                        break;
                    case 4:
                        patient.setFirstName(cell.getStringCellValue().trim());
                        break;
                    case 5:
                        patient.setPatrName(cell.getStringCellValue().trim());
                        break;
                    case 6:
                        patient.setBirthDay(cell.getStringCellValue().replace(".", ""));
                        break;
                    case 7:
                        String sex = cell.getStringCellValue();
                        if (sex.equals("мужской")) {
                            patient.setSex((byte) 1);
                        } else if (sex.equals("женский")) {
                            patient.setSex((byte) 2);
                        }
                        break;
                    case 8:
                        patient.setIdn(new Long(cell.getStringCellValue().trim()));
                        break;
                    case 9:
                        patient.setId(new Long(cell.getStringCellValue().trim()));
                        break;
                    case 10:
                        patient.setIdDiag(new Long(cell.getStringCellValue().trim()));
                        break;
                }
                cellCounter++;
            }
            if (patient.getIdn() != null) {
                patientList.add(patient);
            }
        }
    }
}
