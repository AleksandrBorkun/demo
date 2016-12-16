package com.epam.tf.data.parser;

import com.epam.tf.entity.Patient;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;


/**
 * Created by Ihar_Hukau on 11/30/2016.
 */
public class PatientDataXlsxParser extends Parser {

    private final static String SHEET = "Новый пациент";

    public PatientDataXlsxParser() {
        super(SHEET);
    }

    protected void parse(Sheet sheet) {
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
                        patient.setPersonalNumber(getValue(cell));
                        break;
                    case 3:
                        patient.setLastName(getValue(cell));
                        break;
                    case 4:
                        patient.setFirstName(getValue(cell));
                        break;
                    case 5:
                        patient.setPatrName(getValue(cell));
                        break;
                    case 6:
                        patient.setBirthDay(getValue(cell).replace(".", ""));
                        break;
                    case 7:
                        String sex = getValue(cell);
                        if (sex.equals("мужской")) {
                            patient.setSex((byte) 1);
                        } else if (sex.equals("женский")) {
                            patient.setSex((byte) 2);
                        }
                        break;
                    case 8:
                        patient.setIdn(new Long(getValue(cell)));
                        break;
                    case 9:
                        patient.setId(new Long(getValue(cell)));
                        break;
                    case 10:
                        patient.setIdDiag(new Long(getValue(cell)));
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
