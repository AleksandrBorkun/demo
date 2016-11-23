package com.epam.tf.data;


public class Diagnosis extends BaseData{
    private String diagnosisAccordingToICD10;
    private String codeICD10;
    private String codeICD19;
    private String diagnosisDate;
    private String diagnosisCancelDate;
    private String pairingSymptom;
    private String pregnancy;
    private String diagnosisText;
    private String sourceOfdiagnosisInfo;
    private String camePlace;
    private String additionalInfo;
    private String phase;
    private String phaseEnding;
    private String refinementPhase;
    private String refinementPhaseEnding;
    private String multiplicity;
    private String revealingTerms;
    private String confirmationMethod;
    private String ICD10morphology;
    private String differentiationDegree;
    private String morphologyText;
    private String morphologicalStudyRate;
    private String dateOfExamination;
    private String t;
    private String n;
    private String m;

    /*
    Fields in russian:

    Диагноз по МКБ10
    Код МКБ10
    МКБ9
    Дата установления диагноза
    Дата отмены диагноза
    Признак парности
    Беременность при установлении
    Текст диагноза
    Источник информации о диагнозе
    Откуда поступила
    Место проживания на момент установления диагноза
    Доп текст к мж
    Стадия
    Стадия кончат
    Уточнение стадии
    Уточнение стадии окончат
    Множественность
    Условия выявления
    Метод подтверждения
    Морфология МКБ10
    Степень дифференцировки
    Текст морфологии
    Ном морфологического исследования
    Дата проведения
    T
    N
    M

     */


    public String getDiagnosisAccordingToICD10() {
        return diagnosisAccordingToICD10;
    }

    public void setDiagnosisAccordingToICD10(String diagnosisAccordingToICD10) {
        this.diagnosisAccordingToICD10 = diagnosisAccordingToICD10;
    }

    public String getCodeICD10() {
        return codeICD10;
    }

    public void setCodeICD10(String codeICD10) {
        this.codeICD10 = codeICD10;
    }

    public String getCodeICD19() {
        return codeICD19;
    }

    public void setCodeICD19(String codeICD19) {
        this.codeICD19 = codeICD19;
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

    public void setICD10morphology(String ICD10morphology) {
        this.ICD10morphology = ICD10morphology;
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

    public String getDateOfExamination() {
        return dateOfExamination;
    }

    public void setDateOfExamination(String dateOfExamination) {
        this.dateOfExamination = dateOfExamination;
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

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosisAccordingToICD10='" + diagnosisAccordingToICD10 + '\'' +
                ", codeICD10='" + codeICD10 + '\'' +
                ", codeICD19='" + codeICD19 + '\'' +
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
                ", multiplicity='" + multiplicity + '\'' +
                ", revealingTerms='" + revealingTerms + '\'' +
                ", confirmationMethod='" + confirmationMethod + '\'' +
                ", ICD10morphology='" + ICD10morphology + '\'' +
                ", differentiationDegree='" + differentiationDegree + '\'' +
                ", morphologyText='" + morphologyText + '\'' +
                ", morphologicalStudyRate='" + morphologicalStudyRate + '\'' +
                ", dateOfExamination='" + dateOfExamination + '\'' +
                ", t=" + t +
                ", n=" + n +
                ", m=" + m +
                '}';
    }
}
