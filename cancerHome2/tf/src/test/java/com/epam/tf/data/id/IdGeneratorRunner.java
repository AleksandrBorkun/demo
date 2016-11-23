package com.epam.tf.data.id;


public class IdGeneratorRunner {

    public static void main(String[] args) {
        PassportIdGenerator generator = new PassportIdGenerator("03.02.1989",Region.MINSK,"М");
        System.out.println(generator.generateId());
    }
}
