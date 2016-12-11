package com.epam.tf.utils;


public class Random {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxwy";
    private static final String AB_RUS = "йцукенгшщзхъэжлдорпавыфячсмитьбю";
    private static java.util.Random rnd = new java.util.Random();

    public static String getRandomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
        {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static String getRandomStringRus(int len){
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
        {
            sb.append(AB_RUS.charAt(rnd.nextInt(AB_RUS.length())));
        }
        return sb.toString();
    }

    public static String getRandomNumber(int length){
        String result = "";
        for(int i = 0; i < length; i++) {
            result += String.valueOf(rnd.nextInt(9) + 1);
        }
        return result;
    }
}
