package com.epam.tf.entity;

/**
 * Created by Kiryl_Shyshko on 12/1/2016.
 */
public class Treatment {
    private String beginTreatmentDate ;
    private String endingTreatmentDate;
    private String treatmentInfo;
    private String treatmentNature;
    private String specialTreatmentType;
    private String typeOZ;
    private String treatmentPlace;
    private String incompleteTreatmentReason;
    private String medicalHistoryNumber;
    private String annotation;
    private String codeType;
    private String code;



    public Treatment(){

    }
    public String getBeginTreatmentDate() {
        return beginTreatmentDate;
    }

    public void setBeginTreatmentDate(String beginTreatmentDate) {
        this.beginTreatmentDate = beginTreatmentDate;
    }

    public String getEndingTreatmentDate() {
        return endingTreatmentDate;
    }

    public void setEndingTreatmentDate(String endingTreatmentDate) {
        this.endingTreatmentDate = endingTreatmentDate;
    }

    public String getTreatmentInfo() {
        return treatmentInfo;
    }

    public void setTreatmentInfo(String treatmentInfo) {
        this.treatmentInfo = treatmentInfo;
    }

    public String getTreatmentNature() {
        return treatmentNature;
    }

    public void setTreatmentNature(String treatmentNature) {
        this.treatmentNature = treatmentNature;
    }

    public String getSpecialTreatmentType() {
        return specialTreatmentType;
    }

    public void setSpecialTreatmentType(String specialTreatmentType) {
        this.specialTreatmentType = specialTreatmentType;
    }

    public String getTypeOZ() {
        return typeOZ;
    }

    public void setTypeOZ(String typeOZ) {
        this.typeOZ = typeOZ;
    }

    public String getTreatmentPlace() {
        return treatmentPlace;
    }

    public void setTreatmentPlace(String treatmentPlace) {
        this.treatmentPlace = treatmentPlace;
    }

    public String getIncompleteTreatmentReason() {
        return incompleteTreatmentReason;
    }

    public void setIncompleteTreatmentReason(String incompleteTreatmentReason) {
        this.incompleteTreatmentReason = incompleteTreatmentReason;
    }

    public String getMedicalHistoryNumber() {
        return medicalHistoryNumber;
    }

    public void setMedicalHistoryNumber(String medicalHistoryNumber) {
        this.medicalHistoryNumber = medicalHistoryNumber;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "Treatment{" +
                "beginTreatmentDate='" + beginTreatmentDate + '\'' +
                ", endingTreatmentDate='" + endingTreatmentDate + '\'' +
                ", treatmentInfo='" + treatmentInfo + '\'' +
                ", treatmentNature='" + treatmentNature + '\'' +
                ", specialTreatmentType='" + specialTreatmentType + '\'' +
                ", typeOZ='" + typeOZ + '\'' +
                ", treatmentPlace='" + treatmentPlace + '\'' +
                ", incompleteTreatmentReason='" + incompleteTreatmentReason + '\'' +
                ", medicalHistoryNumber='" + medicalHistoryNumber + '\'' +
                ", annotation='" + annotation + '\'' +
                ", codeType='" + codeType + '\'' +
                ", code='" + code + '\'' +
                '}'+ "\n";
    }
}
