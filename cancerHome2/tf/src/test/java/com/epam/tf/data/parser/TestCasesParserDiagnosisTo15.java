package com.epam.tf.data.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.tf.property.PropertyProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.epam.tf.entity.DataDiagnosisTo15;

public class TestCasesParserDiagnosisTo15 {

	private final static String SHEET = "Вал уст. диагноза до 15 лет";
	private final static String FILE_PATH = "xlsxDocument";
	private static final Logger LOG = LogManager.getRootLogger();
	private List<DataDiagnosisTo15> valDiagnosisTo15List = new ArrayList<>();

	public List<DataDiagnosisTo15> getValDiagnosisTo15() {
		return valDiagnosisTo15List;
	}

	public TestCasesParserDiagnosisTo15() {
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
			DataDiagnosisTo15 testCase = new DataDiagnosisTo15();
			int cellCounter = 1;
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				cell.setCellType(Cell.CELL_TYPE_STRING);
				switch (cellCounter) {
				case 1:
					testCase.setBirthDay(cell.getStringCellValue().trim());
					break;
				case 2:
					testCase.setCodeICD10(cell.getStringCellValue().trim());
					break;
				case 3:
					testCase.setCodeICD9(cell.getStringCellValue().trim());
					break;
				case 4:
					testCase.setDiagnosisDate(cell.getStringCellValue().trim());
					break;
				case 5:
					testCase.setDiagnosisCancelDate(cell.getStringCellValue().trim());
					break;
				case 6:
					testCase.setPairingSymptom(cell.getStringCellValue().trim());
					break;
				case 7:
					testCase.setPregnancy(cell.getStringCellValue().trim());
					break;
				case 8:
					testCase.setDiagnosisText(cell.getStringCellValue().trim());
					break;
				case 9:
					testCase.setSourceOfdiagnosisInfo(cell.getStringCellValue().trim());
					break;
				case 10:
					testCase.setCamePlace(cell.getStringCellValue().trim());
					break;
				case 11:
					testCase.setPlaceOfresidency(cell.getStringCellValue().trim());
					break;
				case 12:
					testCase.setAdditionalInfo(cell.getStringCellValue().trim());
					break;
				case 13:
					testCase.setPhase(cell.getStringCellValue().trim());
					break;
				case 14:
					testCase.setPhaseEnding(cell.getStringCellValue().trim());
					break;
				case 15:
					testCase.setRefinementPhase(cell.getStringCellValue().trim());
					break;
				case 16:
					testCase.setRefinementPhaseEnding(cell.getStringCellValue().trim());
					break;
				case 17:
					testCase.setT(cell.getStringCellValue().trim());
					break;
				case 18:
					testCase.setN(cell.getStringCellValue().trim());
					break;
				case 19:
					testCase.setM(cell.getStringCellValue().trim());
					break;
				case 20:
					testCase.setMultiplicity(cell.getStringCellValue().trim());
					break;
				case 21:
					testCase.setRevealingTerms(cell.getStringCellValue().trim());
					break;
				case 22:
					testCase.setConfirmationMethod(cell.getStringCellValue().trim());
					break;
				case 23:
					testCase.setICD10morphology(cell.getStringCellValue().trim());
					break;
				case 24:
					testCase.setDifferentiationDegree(cell.getStringCellValue().trim());
					break;
				case 25:
					testCase.setMorphologyText(cell.getStringCellValue().trim());
					break;
				case 26:
					testCase.setMorphologicalStudyRate(cell.getStringCellValue().trim());
					break;
				case 27:
					testCase.setDateOfExamination(cell.getStringCellValue().trim());
					break;
				case 28:
					testCase.setResult(cell.getStringCellValue().trim());
					break;

				}
				cellCounter++;
			}
			// System.out.println(testCase);
			if (!testCase.getResult().equals("")) {

				valDiagnosisTo15List.add(testCase);
			}
		}
	}

}
