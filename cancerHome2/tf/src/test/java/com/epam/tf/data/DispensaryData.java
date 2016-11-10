package com.epam.tf.data;


public class DispensaryData extends BaseData{
    private String dispensaryCode;
    private String policlinic;
    private String beforeCondition;
    private String invalidGroup;
    private String privilegesCategory;
    private String position;
    private String additionInfo;
    private String nationality;
    private String accountingGroup;
    private String idnInTheAsoigr;
    private String dateOfDeath;
    private String pipeline;
    private String retired;
    private String additionalInformationAboutRetire;
    private String causeOfDeath;
    private String causeOfDeathText;
    private String nameOfTheSignerCertificateOfDeath;
    private String presenceOfOpening;

    /*
    Fields in russian:
    Код диспансера
    Поликлиника
    "Состоял
    ранее на учете в другом ОД"
    "Группа инвалидности"
    "Категория
    льгот"
    Должность
    Примечание
    Национальность
    Группа учета
    IDN в АСОИГР
    Место жительства на момент аварии
    Дата смерти
    Источник информации
    Куда выбыл
    Доп информация о выбытии
    Причина Смерти
    Причина Смерти Текст
    ФИО подписавшего свидетельство смерти
    Наличие вскрытия
     */


    public String getDispensaryCode() {
        return dispensaryCode;
    }

    public void setDispensaryCode(String dispensaryCode) {
        this.dispensaryCode = dispensaryCode;
    }

    public String getPoliclinic() {
        return policlinic;
    }

    public void setPoliclinic(String policlinic) {
        this.policlinic = policlinic;
    }

    public String getBeforeCondition() {
        return beforeCondition;
    }

    public void setBeforeCondition(String beforeCondition) {
        this.beforeCondition = beforeCondition;
    }

    public String getInvalidGroup() {
        return invalidGroup;
    }

    public void setInvalidGroup(String invalidGroup) {
        this.invalidGroup = invalidGroup;
    }

    public String getPrivilegesCategory() {
        return privilegesCategory;
    }

    public void setPrivilegesCategory(String privilegesCategory) {
        this.privilegesCategory = privilegesCategory;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAdditionInfo() {
        return additionInfo;
    }

    public void setAdditionInfo(String additionInfo) {
        this.additionInfo = additionInfo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAccountingGroup() {
        return accountingGroup;
    }

    public void setAccountingGroup(String accountingGroup) {
        this.accountingGroup = accountingGroup;
    }

    public String getIdnInTheAsoigr() {
        return idnInTheAsoigr;
    }

    public void setIdnInTheAsoigr(String idnInTheAsoigr) {
        this.idnInTheAsoigr = idnInTheAsoigr;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getPipeline() {
        return pipeline;
    }

    public void setPipeline(String pipeline) {
        this.pipeline = pipeline;
    }

    public String getRetired() {
        return retired;
    }

    public void setRetired(String retired) {
        this.retired = retired;
    }

    public String getAdditionalInformationAboutRetire() {
        return additionalInformationAboutRetire;
    }

    public void setAdditionalInformationAboutRetire(String additionalInformationAboutRetire) {
        this.additionalInformationAboutRetire = additionalInformationAboutRetire;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public String getCauseOfDeathText() {
        return causeOfDeathText;
    }

    public void setCauseOfDeathText(String causeOfDeathText) {
        this.causeOfDeathText = causeOfDeathText;
    }

    public String getNameOfTheSignerCertificateOfDeath() {
        return nameOfTheSignerCertificateOfDeath;
    }

    public void setNameOfTheSignerCertificateOfDeath(String nameOfTheSignerCertificateOfDeath) {
        this.nameOfTheSignerCertificateOfDeath = nameOfTheSignerCertificateOfDeath;
    }

    public String getPresenceOfOpening() {
        return presenceOfOpening;
    }

    public void setPresenceOfOpening(String presenceOfOpening) {
        this.presenceOfOpening = presenceOfOpening;
    }

    @Override
    public String toString() {
        return "DispensaryData{" +
                "dispensaryCode='" + dispensaryCode + '\'' +
                ", policlinic='" + policlinic + '\'' +
                ", beforeCondition='" + beforeCondition + '\'' +
                ", invalidGroup='" + invalidGroup + '\'' +
                ", privilegesCategory='" + privilegesCategory + '\'' +
                ", position='" + position + '\'' +
                ", additionInfo='" + additionInfo + '\'' +
                ", nationality='" + nationality + '\'' +
                ", accountingGroup='" + accountingGroup + '\'' +
                ", idnInTheAsoigr='" + idnInTheAsoigr + '\'' +
                ", dateOfDeath='" + dateOfDeath + '\'' +
                ", pipeline='" + pipeline + '\'' +
                ", retired='" + retired + '\'' +
                ", additionalInformationAboutRetire='" + additionalInformationAboutRetire + '\'' +
                ", causeOfDeath='" + causeOfDeath + '\'' +
                ", causeOfDeathText='" + causeOfDeathText + '\'' +
                ", nameOfTheSignerCertificateOfDeath='" + nameOfTheSignerCertificateOfDeath + '\'' +
                ", presenceOfOpening='" + presenceOfOpening + '\'' +
                '}';
    }
}
