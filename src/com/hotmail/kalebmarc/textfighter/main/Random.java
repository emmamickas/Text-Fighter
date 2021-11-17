package com.hotmail.kalebmarc.textfighter.main;

public class Random {
    private Random() {
    }

    public static int randomInt(int max) {
        java.util.Random randomGenerator = new java.util.Random();

        return (randomGenerator.nextInt(max) + 1);
    }

    public static int randomInt(int min, int max) {
        java.util.Random randomGenerator = new java.util.Random();

        return (randomGenerator.nextInt((max - min) + 1) + min);
    }
}