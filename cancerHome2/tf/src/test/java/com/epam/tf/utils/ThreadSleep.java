package com.epam.tf.utils;

public class ThreadSleep {
    public static void waitElement(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
