package com.epam.tf.data;


public class PassportData extends BaseData{
    private String surname;
    private String name;
    private String patronymic;
    private String birthday;
    private String takeAccountOfDate;
    private String dispensary;
    private String idn;
    private String sex;
    private String currentCondition;
    private String citizen;
    private String codeTersone;
    private String postCode;
    private String street;
    private String house;
    private String housing;
    private String flat;
    private String phone;

    /*
    Fields in russian:

    Фамилия
    Имя
    Отчество
    Дата рождения
    Дата взятия на учет
    Диспансер
    IDN
    Пол
    Состояние на данный момент
    Житель
    Код ТЕРСОН
    Индекс
    Улица
    Дом
    Корпус
    Квартира
    Телефон
    */


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTakeAccountOfDate() {
        return takeAccountOfDate;
    }

    public void setTakeAccountOfDate(String takeAccountOfDate) {
        this.takeAccountOfDate = takeAccountOfDate;
    }

    public String getDispensary() {
        return dispensary;
    }

    public void setDispensary(String dispensary) {
        this.dispensary = dispensary;
    }

    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
        this.idn = idn;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    public String getCitizen() {
        return citizen;
    }

    public void setCitizen(String citizen) {
        this.citizen = citizen;
    }

    public String getCodeTersone() {
        return codeTersone;
    }

    public void setCodeTersone(String codeTersone) {
        this.codeTersone = codeTersone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "PassportData{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday='" + birthday + '\'' +
                ", takeAccountOfDate='" + takeAccountOfDate + '\'' +
                ", dispensary='" + dispensary + '\'' +
                ", idn='" + idn + '\'' +
                ", sex='" + sex + '\'' +
                ", currentCondition='" + currentCondition + '\'' +
                ", citizen='" + citizen + '\'' +
                ", codeTersone='" + codeTersone + '\'' +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", housing='" + housing + '\'' +
                ", flat='" + flat + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

