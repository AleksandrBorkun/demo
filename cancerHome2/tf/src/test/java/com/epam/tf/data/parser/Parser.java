package com.epam.tf.data.parser;

import com.epam.tf.entity.Patient;
import com.epam.tf.entity.TestCase;
import com.epam.tf.property.PropertyProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay_Golubitsky on 12/13/2016.
 */
public abstract class Parser {
    protected final static String FILE_PATH = "xlsxDocument";
    protected static final Logger LOG = LogManager.getLogger();
    protected List<Patient> patientList = new ArrayList<>();
    protected List<TestCase> testCases = new ArrayList<>();
    protected InputStream inputStream;
    protected XSSFWorkbook workbook;

    public Parser(String sheet) {
        try {
            inputStream = new FileInputStream(PropertyProvider.getProperty(FILE_PATH));
            workbook = new XSSFWorkbook(inputStream);
            parse(workbook.getSheet(sheet));
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    public List<Patient> getPatientList() {
        return patientList;
    }


    public List<TestCase> getTestCases() {
        return testCases;
    }

    protected abstract void parse(Sheet sheet);

    protected String getValue(Cell cell){
        return cell.getStringCellValue().trim();
    }
}
