package com.epam.tf.entity;

public class Patient {

    private Long idn;
    private String personalNumber;
    private Long id;
    private String firstName;
    private String lastName;
    private String patrName;
    private String birthDay;
    private Byte sex;
    private String state;
    private Long idDiag;


    public Patient(String personalNumber, String firstName, String last_name, String patr_name, String birthDay,
                   Byte sex, Long idn) {
        this.idn = idn;
        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.lastName = last_name;
        this.patrName = patr_name;
        this.birthDay = birthDay;
        this.sex = sex;
    }

    public Patient(Long idn, String personalNumber, Long num_amb, String firstName, String last_name,
                   String patr_name, String birthDay, Byte sex, Long idDiag) {
        this.idn = idn;
        this.personalNumber = personalNumber;
        this.id = num_amb;
        this.firstName = firstName;
        this.lastName = last_name;
        this.patrName = patr_name;
        this.birthDay = birthDay;
        this.sex = sex;
        this.idDiag = idDiag;
    }

    public Patient(){

    }

    public Long getIdn() {
        return idn;
    }

    public void setIdn(Long idn) {
        this.idn = idn;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatrName() {
        return patrName;
    }

    public void setPatrName(String patrName) {
        this.patrName = patrName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Long getIdDiag() {
        return idDiag;
    }

    public void setIdDiag(Long idDiag) {
        this.idDiag = idDiag;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String dateSwap(){
        String date = this.getBirthDay();
        String year = date.substring(4, 8);
        String month = date.substring(2, 4);
        String day = date.substring(0, 2);
        return (year + day + month);

    }


    @Override
    public String toString() {
        return "Patient{" +
                "idn=" + idn +
                ", personalNumber='" + personalNumber + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patrName='" + patrName + '\'' +
                ", birthDay=" + birthDay +
                ", sex=" + sex +
                ", state=" + state +
                ", idDiag=" + idDiag +
                '}';
    }

}
