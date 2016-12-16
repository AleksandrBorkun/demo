package com.epam.tf.data.id;


import com.epam.tf.dao.impl.PatientDAO;
import com.epam.tf.data.parser.PatientDataXlsxParser;
import com.epam.tf.data.parser.TestCasesParserDataGenderCombinationXlsx;
import com.epam.tf.data.parser.TestCasesParserDiagnosisTo15;


public class IdGeneratorRunner {

    public static void main(String[] args) {
        PassportIdGenerator generator = new PassportIdGenerator("03.02.1989",Region.MINSK,"М");
        System.out.println(generator.generateId());

        PatientDataXlsxParser parser = new PatientDataXlsxParser();
        System.out.println(parser.getPatientList());

        TestCasesParserDataGenderCombinationXlsx data = new TestCasesParserDataGenderCombinationXlsx();
        PatientDAO patientDAO = new PatientDAO();
        patientDAO.deleteByIdn(new Long("42"));
        patientDAO.deleteByIdn(new Long("44"));

        patientDAO.add(parser.getPatientList().get(1));
        patientDAO.add(parser.getPatientList().get(3));

   /* 	TestCasesParserDiagnosisTo15 parseDiagnosisTo15 = new TestCasesParserDiagnosisTo15();
    	System.out.println(parseDiagnosisTo15.getValDiagnosisTo15());*/

    }
}
