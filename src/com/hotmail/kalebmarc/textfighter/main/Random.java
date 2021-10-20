package com.hotmail.kalebmarc.textfighter.main;

public class Random {
    private Random() {
    }


    /**
     * RInt(int) is used in conjunction with casino games.
     * @param max inclusive bound for random number generator.
     * @return random number from 1 to max.
     */
    public static int RInt(int max) {
        java.util.Random ran = new java.util.Random();

        return (ran.nextInt(max) + 1);
    }


    /**
     *  RInt(int,int) randomly generates how much damage is dealt when encountering enemies.
     * @param min minimum number generated from random number generator.
     * @param max maximum number generated from random number generator
     * @return random number generated between min and max, inclusive.
     */
    public static int RInt(int min, int max) {
        java.util.Random ran = new java.util.Random();

        return (ran.nextInt((max - min) + 1) + min);
    }
}