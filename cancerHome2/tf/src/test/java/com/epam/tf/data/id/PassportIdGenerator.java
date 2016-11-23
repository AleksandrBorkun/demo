package com.epam.tf.data.id;


public class PassportIdGenerator {
    private String dateOfBirth;
    private Region region;
    private String sex;

    public PassportIdGenerator(String dateOfBirth, Region region, String sex) {
        this.dateOfBirth = dateOfBirth;
        this.region = region;
        this.sex = sex;
    }

    public String generateId(){
        StringBuilder id = new StringBuilder();
        id.append(generateFirstNumber());
        id.append(generateDateOfBirthNumbers());
        id.append(generateRegionLetter());
        id.append("002");                                       //person count, with was born at this region and that date
        id.append("PB");                                         //republic of Belarus
        id.append(generateControlNumber(id));
        return id.toString();
    }


    private int generateControlNumber(StringBuilder id){
        char[] charsBeforeControlNumber = id.toString().toCharArray();
        StringBuilder equivalent = new StringBuilder();
        for (int i = 0;i<charsBeforeControlNumber.length;i++){
            equivalent.append(generateEquivalentNumber(charsBeforeControlNumber[i],i));
        }
        int counter = 1;
        int sum = 0;
        String[] equivalentNumbers = equivalent.toString().split("\\.");
        for(String equivalentNumber:equivalentNumbers){
            switch (counter){
                case 1:
                    sum+=Integer.parseInt(equivalentNumber)*7;
                    counter++;
                    break;
                case 2:
                    sum+=Integer.parseInt(equivalentNumber)*3;
                    counter++;
                    break;
                case 3:
                    sum+=Integer.parseInt(equivalentNumber);
                    counter = 1;
                    break;
            }
        }
        return sum%10;
    }

    private String generateEquivalentNumber(char letterFromId, int index){
        String equivalent = null;
        switch (index){
            case 0:
                equivalent = String.valueOf(letterFromId);
            case 7:
                switch(letterFromId){
                    case 'A':
                        equivalent = ".10";
                        break;
                    case 'B':
                        equivalent = ".11";
                        break;
                    case 'C':
                        equivalent = ".12";
                        break;
                    case 'H':
                        equivalent = ".17";
                        break;
                    case 'K':
                        equivalent = ".20";
                        break;
                    case 'E':
                        equivalent = ".14";
                        break;
                    case 'M':
                        equivalent = ".22";
                        break;
                }
                break;
            case 11:
                equivalent = ".25";
                break;
            case 12:
                equivalent = ".11";
                break;
            default:
                equivalent = "."+letterFromId;
                break;
        }


        return equivalent;
    }

    private char generateRegionLetter(){
        char regionLetter = '0';
        switch (region){
            case MINSK_CITY:
                regionLetter = 'A';
                break;
            case MINSK:
                regionLetter = 'B';
                break;
            case BREST:
                regionLetter = 'C';
                break;
            case GOMEL:
                regionLetter = 'H';
                break;
            case GRODNO:
                regionLetter = 'K';
                break;
            case VITEBSK:
                regionLetter = 'E';
                break;
            case MOGILEV:
                regionLetter = 'M';
                break;
        }
        return regionLetter;
    }

    private String generateDateOfBirthNumbers(){
        String[] parsedDateOfBirth = dateOfBirth.split("\\.");
        StringBuilder birthDate = new StringBuilder();
        birthDate.append(parsedDateOfBirth[0]);
        birthDate.append(parsedDateOfBirth[1]);
        birthDate.append(parsedDateOfBirth[2].substring(2));
        return birthDate.toString();
    }

    private int generateFirstNumber(){
        String[] parsedDateOfBirth;
        parsedDateOfBirth = dateOfBirth.split("\\.");
        int yearOfBirth = Integer.valueOf(parsedDateOfBirth[2]);
        int firstNumber=0;
        switch (sex){
            case "М":
                if (yearOfBirth>=1801&&yearOfBirth<=1900){
                    firstNumber = 1;
                }
                else if(yearOfBirth>=1901&&yearOfBirth<=2000){
                    firstNumber = 3;
                }
                else if(yearOfBirth>=2001&&yearOfBirth<=2100){
                    firstNumber = 5;
                }
                break;
            case "Ж":
                if (yearOfBirth>1801&&yearOfBirth<1900){
                    firstNumber = 2;
                }
                else if(yearOfBirth>=1901&&yearOfBirth<=2000){
                    firstNumber = 4;
                }
                else if(yearOfBirth>=2001&&yearOfBirth<=2100){
                    firstNumber = 6;
                }
                break;
        }
        return firstNumber;
    }
}
