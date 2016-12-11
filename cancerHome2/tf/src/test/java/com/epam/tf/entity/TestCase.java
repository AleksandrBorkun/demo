package com.epam.tf.entity;

/**
 * Created by Nikolay_Golubitsky on 12/1/2016.
 */
public class TestCase {


    private int testCaseNumber;
    private String mkb10;
    private String mkb9;
    private String dateDiag;
    private String dateDiagCan;
    private String signP;
    private String pregnancyBegin;
    private String diagnosisText;
    private String sourceInf;
    private String from;
    private String homeAddress;
    private String extraText;
    private String stage;
    private String finalStage;
    private String specificationStage;
    private String finalSpecificationStage;
    private String T;
    private String M;
    private String N;
    private String plurality;
    private String detectionRules;
    private String acceptMethod;
    private String morphology;
    private String stageDif;
    private String morphologyText;
    private String morphologyNumber;
    private String pregnancy;
    private String carriageDate;
    private String sex;
    private String nowStage;
    private String result;
    private String scenarioDescription;

    public TestCase() {
    }

    public int getTestCaseNumber() {
        return testCaseNumber;
    }

    public void setTestCaseNumber(int testCaseNumber) {
        this.testCaseNumber = testCaseNumber;
    }

    public String getMkb9() {
        return mkb9;
    }

    public void setMkb9(String mkb9) {
        this.mkb9 = mkb9;
    }

    public String getPregnancyBegin() {
        return pregnancyBegin;
    }

    public void setPregnancyBegin(String pregnancyBegin) {
        this.pregnancyBegin = pregnancyBegin;
    }

    public String getDiagnosisText() {
        return diagnosisText;
    }

    public void setDiagnosisText(String diagnosisText) {
        this.diagnosisText = diagnosisText;
    }

    public String getMkb10() {
        return mkb10;
    }

    public void setMkb10(String mkb10) {
        this.mkb10 = mkb10;
    }

    public String getDateDiag() {
        return dateDiag;
    }

    public void setDateDiag(String dateDiag) {
        this.dateDiag = dateDiag;
    }

    public String getDateDiagCan() {
        return dateDiagCan;
    }

    public void setDateDiagCan(String dateDiagCan) {
        this.dateDiagCan = dateDiagCan;
    }

    public String getSignP() {
        return signP;
    }

    public void setSignP(String signP) {
        this.signP = signP;
    }

    public String getSourceInf() {
        return sourceInf;
    }

    public void setSourceInf(String sourceInf) {
        this.sourceInf = sourceInf;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getExtraText() {
        return extraText;
    }

    public void setExtraText(String extraText) {
        this.extraText = extraText;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getFinalStage() {
        return finalStage;
    }

    public void setFinalStage(String finalStage) {
        this.finalStage = finalStage;
    }

    public String getSpecificationStage() {
        return specificationStage;
    }

    public void setSpecificationStage(String specificationStage) {
        this.specificationStage = specificationStage;
    }

    public String getFinalSpecificationStage() {
        return finalSpecificationStage;
    }

    public void setFinalSpecificationStage(String finalSpecificationStage) {
        this.finalSpecificationStage = finalSpecificationStage;
    }

    public String getT() {
        return T;
    }

    public void setT(String t) {
        T = t;
    }

    public String getM() {
        return M;
    }

    public void setM(String m) {
        M = m;
    }

    public String getN() {
        return N;
    }

    public void setN(String n) {
        N = n;
    }

    public String getPlurality() {
        return plurality;
    }

    public void setPlurality(String plurality) {
        this.plurality = plurality;
    }

    public String getDetectionRules() {
        return detectionRules;
    }

    public void setDetectionRules(String detectionRules) {
        this.detectionRules = detectionRules;
    }

    public String getAcceptMethod() {
        return acceptMethod;
    }

    public void setAcceptMethod(String acceptMethod) {
        this.acceptMethod = acceptMethod;
    }

    public String getMorphology() {
        return morphology;
    }

    public void setMorphology(String morphology) {
        this.morphology = morphology;
    }

    public String getStageDif() {
        return stageDif;
    }

    public void setStageDif(String stageDif) {
        this.stageDif = stageDif;
    }

    public String getMorphologyText() {
        return morphologyText;
    }

    public void setMorphologyText(String morphologyText) {
        this.morphologyText = morphologyText;
    }

    public String getMorphologyNumber() {
        return morphologyNumber;
    }

    public void setMorphologyNumber(String morphologyNumber) {
        this.morphologyNumber = morphologyNumber;
    }

    public String getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(String pregnancy) {
        this.pregnancy = pregnancy;
    }

    public String getCarriageDate() {
        return carriageDate;
    }

    public void setCarriageDate(String carriageDate) {
        this.carriageDate = carriageDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNowStage() {
        return nowStage;
    }

    public void setNowStage(String nowStage) {
        this.nowStage = nowStage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getScenarioDescription() {
        return scenarioDescription;
    }

    public void setScenarioDescription(String scenarioDescription) {
        this.scenarioDescription = scenarioDescription;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "test number='" + testCaseNumber + '\'' +
                "mkb10='" + mkb10 + '\'' +
                ", dateDiag='" + dateDiag + '\'' +
                ", dateDiagCan='" + dateDiagCan + '\'' +
                ", signP='" + signP + '\'' +
                ", sourceInf='" + sourceInf + '\'' +
                ", from='" + from + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", extraText='" + extraText + '\'' +
                ", stage='" + stage + '\'' +
                ", finalStage='" + finalStage + '\'' +
                ", specificationStage='" + specificationStage + '\'' +
                ", finalSpecificationStage='" + finalSpecificationStage + '\'' +
                ", T='" + T + '\'' +
                ", M='" + M + '\'' +
                ", N='" + N + '\'' +
                ", plurality='" + plurality + '\'' +
                ", detectionRules='" + detectionRules + '\'' +
                ", acceptMethod='" + acceptMethod + '\'' +
                ", morphology='" + morphology + '\'' +
                ", stageDif='" + stageDif + '\'' +
                ", morphologyText='" + morphologyText + '\'' +
                ", morphologyNumber='" + morphologyNumber + '\'' +
                ", pregnancy='" + pregnancy + '\'' +
                ", carriageDate='" + carriageDate + '\'' +
                ", sex='" + sex + '\'' +
                ", nowStage='" + nowStage + '\'' +
                ", result='" + result + '\'' +
                ", scenarioDescription='" + scenarioDescription + '\'' +
                '}';
    }
}
