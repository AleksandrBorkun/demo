package com.epam.tf.entity;

public class DataDiagnosisTo15 {

	    
	    private String birthDay; // Дата рождения
     	private String codeICD10;   // Код МКБ-10
	    private String codeICD9;   // Код МКБ-9
	    private String diagnosisDate;   // Дата установления диагноза
	    private String diagnosisCancelDate;  // 	Дата отмены диагноза
	    private String pairingSymptom;   //Признак парности 
	    private String pregnancy;   // Беременность при установлении
	    private String diagnosisText;  // 	Текст диагноза
	    private String sourceOfdiagnosisInfo;  // Источник информации о диагнозе
	    private String camePlace;   // 	Откуда поступила
	    private String placeOfresidency;   // Место проживания на момент установления диагноза
	    private String additionalInfo; // Доп. текст к м/ж
	    private String phase;  //  Стадия
	    private String phaseEnding;  // Стадия(окончат.)
	    private String refinementPhase; // Уточнение стадии
	    private String refinementPhaseEnding; // Уточнение стадии (окончат.)
	    private String multiplicity;  //  Множественность
	    private String revealingTerms; // Условия выявления
	    private String confirmationMethod; // 	Метод подтверждения
	    private String ICD10morphology;  // Морфология(МКБ-10)
	    private String differentiationDegree; // Степень дифференцировки
	    private String morphologyText; // Текст морфологии
	    private String morphologicalStudyRate;  //№ морфологического исследования
	    private String t;  //  T
	    private String n;  // N
	    private String m;  // M
	    private String dateOfExamination;  // Дата проведения
	    private String result;  // Дата проведения
	    
	    
	    
		public DataDiagnosisTo15() {
			
		}
		public String getBirthDay() {
			return birthDay;
		}
		public void setBirthDay(String birthDay) {
			this.birthDay = birthDay;
		}
		public String getCodeICD10() {
			return codeICD10;
		}
		public void setCodeICD10(String codeICD10) {
			this.codeICD10 = codeICD10;
		}
		public String getCodeICD9() {
			return codeICD9;
		}
		public void setCodeICD9(String codeICD9) {
			this.codeICD9 = codeICD9;
		}
		public String getDiagnosisDate() {
			return diagnosisDate;
		}
		public void setDiagnosisDate(String diagnosisDate) {
			this.diagnosisDate = diagnosisDate;
		}
		public String getDiagnosisCancelDate() {
			return diagnosisCancelDate;
		}
		public void setDiagnosisCancelDate(String diagnosisCancelDate) {
			this.diagnosisCancelDate = diagnosisCancelDate;
		}
		public String getPairingSymptom() {
			return pairingSymptom;
		}
		public void setPairingSymptom(String pairingSymptom) {
			this.pairingSymptom = pairingSymptom;
		}
		public String getPregnancy() {
			return pregnancy;
		}
		public void setPregnancy(String pregnancy) {
			this.pregnancy = pregnancy;
		}
		public String getDiagnosisText() {
			return diagnosisText;
		}
		public void setDiagnosisText(String diagnosisText) {
			this.diagnosisText = diagnosisText;
		}
		public String getSourceOfdiagnosisInfo() {
			return sourceOfdiagnosisInfo;
		}
		public void setSourceOfdiagnosisInfo(String sourceOfdiagnosisInfo) {
			this.sourceOfdiagnosisInfo = sourceOfdiagnosisInfo;
		}
		public String getCamePlace() {
			return camePlace;
		}
		public void setCamePlace(String camePlace) {
			this.camePlace = camePlace;
		}
		public String getPlaceOfresidency() {
			return placeOfresidency;
		}
		public void setPlaceOfresidency(String placeOfresidency) {
			this.placeOfresidency = placeOfresidency;
		}
		public String getAdditionalInfo() {
			return additionalInfo;
		}
		public void setAdditionalInfo(String additionalInfo) {
			this.additionalInfo = additionalInfo;
		}
		public String getPhase() {
			return phase;
		}
		public void setPhase(String phase) {
			this.phase = phase;
		}
		public String getPhaseEnding() {
			return phaseEnding;
		}
		public void setPhaseEnding(String phaseEnding) {
			this.phaseEnding = phaseEnding;
		}
		public String getRefinementPhase() {
			return refinementPhase;
		}
		public void setRefinementPhase(String refinementPhase) {
			this.refinementPhase = refinementPhase;
		}
		public String getRefinementPhaseEnding() {
			return refinementPhaseEnding;
		}
		public void setRefinementPhaseEnding(String refinementPhaseEnding) {
			this.refinementPhaseEnding = refinementPhaseEnding;
		}
		public String getMultiplicity() {
			return multiplicity;
		}
		public void setMultiplicity(String multiplicity) {
			this.multiplicity = multiplicity;
		}
		public String getRevealingTerms() {
			return revealingTerms;
		}
		public void setRevealingTerms(String revealingTerms) {
			this.revealingTerms = revealingTerms;
		}
		public String getConfirmationMethod() {
			return confirmationMethod;
		}
		public void setConfirmationMethod(String confirmationMethod) {
			this.confirmationMethod = confirmationMethod;
		}
		public String getICD10morphology() {
			return ICD10morphology;
		}
		public void setICD10morphology(String iCD10morphology) {
			ICD10morphology = iCD10morphology;
		}
		public String getDifferentiationDegree() {
			return differentiationDegree;
		}
		public void setDifferentiationDegree(String differentiationDegree) {
			this.differentiationDegree = differentiationDegree;
		}
		public String getMorphologyText() {
			return morphologyText;
		}
		public void setMorphologyText(String morphologyText) {
			this.morphologyText = morphologyText;
		}
		public String getMorphologicalStudyRate() {
			return morphologicalStudyRate;
		}
		public void setMorphologicalStudyRate(String morphologicalStudyRate) {
			this.morphologicalStudyRate = morphologicalStudyRate;
		}
		public String getT() {
			return t;
		}
		public void setT(String t) {
			this.t = t;
		}
		public String getN() {
			return n;
		}
		public void setN(String n) {
			this.n = n;
		}
		public String getM() {
			return m;
		}
		public void setM(String m) {
			this.m = m;
		}
		public String getDateOfExamination() {
			return dateOfExamination;
		}
		public void setDateOfExamination(String dateOfExamination) {
			this.dateOfExamination = dateOfExamination;
		}
	
	
		@Override
	    public String toString() {
	        return "Diagnosis{" +
	        		", birthDay='" + birthDay + '\'' +
	        		"codeICD10='" + codeICD10 + '\'' +
	                ", codeICD9='" + codeICD9 + '\'' +
	                ", diagnosisDate='" + diagnosisDate + '\'' +
	                ", diagnosisCancelDate='" + diagnosisCancelDate + '\'' +
	                ", pairingSymptom='" + pairingSymptom + '\'' +
	                ", pregnancy='" + pregnancy + '\'' +
	                ", diagnosisText='" + diagnosisText + '\'' +
	                ", sourceOfdiagnosisInfo='" + sourceOfdiagnosisInfo + '\'' +
	                ", camePlace='" + camePlace + '\'' +
	                ", additionalInfo='" + additionalInfo + '\'' +
	                ", phase='" + phase + '\'' +
	                ", phaseEnding='" + phaseEnding + '\'' +
	                ", refinementPhase='" + refinementPhase + '\'' +
	                ", refinementPhaseEnding='" + refinementPhaseEnding + '\'' +
	                ", t='" + t + '\'' +
	                ", n='" + n + '\'' +
	                ", m='" + m + '\'' +
	                ", multiplicity='" + multiplicity + '\'' +
	                ", revealingTerms='" + revealingTerms + '\'' +
	                ", confirmationMethod='" + confirmationMethod + '\'' +
	                ", ICD10morphology='" + ICD10morphology + '\'' +
	                ", differentiationDegree='" + differentiationDegree + '\'' +
	                ", morphologyText='" + morphologyText + '\'' +
	                ", morphologicalStudyRate='" + morphologicalStudyRate + '\'' +
	                ", dateOfExamination='" + dateOfExamination + '\'' +
	                
	                
	                '}' + "\n";
	    }
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
	
		
	
	
		

	

	
	
	
}
