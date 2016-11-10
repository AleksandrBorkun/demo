package com.epam.tf.data;


public class ClinicalGroups extends BaseData{
    private String clinicalGroup;
    private String dateOfChange;

    public String getClinicalGroup() {
        return clinicalGroup;
    }

    public void setClinicalGroup(String clinicalGroup) {
        this.clinicalGroup = clinicalGroup;
    }

    public String getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(String dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    @Override
    public String toString() {
        return "ClinicalGroups{" +
                "clinicalGroup='" + clinicalGroup + '\'' +
                ", dateOfChange='" + dateOfChange + '\'' +
                '}';
    }
}
