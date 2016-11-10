package com.epam.tf.data;


public class BaseData {
    protected String patientCardNumber;
    protected String personalNumber;
    protected String placeOfResidenceAtAccidentTime;

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getPatientCardNumber() {
        return patientCardNumber;
    }

    public void setPatientCardNumber(String patientCardNumber) {
        this.patientCardNumber = patientCardNumber;
    }

    public String getPlaceOfResidenceAtAccidentTime() {
        return placeOfResidenceAtAccidentTime;
    }

    public void setPlaceOfResidenceAtAccidentTime(String placeOfResidenceAtAccidentTime) {
        this.placeOfResidenceAtAccidentTime = placeOfResidenceAtAccidentTime;
    }
}
