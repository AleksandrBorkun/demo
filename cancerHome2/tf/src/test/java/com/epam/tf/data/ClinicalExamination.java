package com.epam.tf.data;


public class ClinicalExamination extends BaseData{
    private String lastContactDate;
    private String contactIndication;
    private String controlForm;
    private String controlTime;
    private String controlDate;
    private String wherePatientCame;
    private String wherePatientDirected;

    /*
    Fields in russian:

    Дата последнего контакта
    Отметка о контакте
    Форма контроля
    Период контроля
    Куда явился пациент
    Дата_контроля
    Куда_направлен_пациент

     */

    public String getLastContactDate() {
        return lastContactDate;
    }

    public void setLastContactDate(String lastContactDate) {
        this.lastContactDate = lastContactDate;
    }

    public String getContactIndication() {
        return contactIndication;
    }

    public void setContactIndication(String contactIndication) {
        this.contactIndication = contactIndication;
    }

    public String getControlForm() {
        return controlForm;
    }

    public void setControlForm(String controlForm) {
        this.controlForm = controlForm;
    }

    public String getControlTime() {
        return controlTime;
    }

    public void setControlTime(String controlTime) {
        this.controlTime = controlTime;
    }

    public String getControlDate() {
        return controlDate;
    }

    public void setControlDate(String controlDate) {
        this.controlDate = controlDate;
    }

    public String getWherePatientCame() {
        return wherePatientCame;
    }

    public void setWherePatientCame(String wherePatientCame) {
        this.wherePatientCame = wherePatientCame;
    }

    public String getWherePatientDirected() {
        return wherePatientDirected;
    }

    public void setWherePatientDirected(String wherePatientDirected) {
        this.wherePatientDirected = wherePatientDirected;
    }

    @Override
    public String toString() {
        return "ClinicalExamination{" +
                "lastContactDate='" + lastContactDate + '\'' +
                ", contactIndication='" + contactIndication + '\'' +
                ", controlForm='" + controlForm + '\'' +
                ", controlTime='" + controlTime + '\'' +
                ", controlDate='" + controlDate + '\'' +
                ", wherePatientCame='" + wherePatientCame + '\'' +
                ", wherePatientDirected='" + wherePatientDirected + '\'' +
                '}';
    }
}
