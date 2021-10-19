package com.hotmail.kalebmarc.textfighter.main;

public class Random {
    private Random() {
    }
    /*
    RInt(int) takes a number and is inclusive of the bounds. RInt(int) is used in conjunction with casino games.
     */
    public static int RInt(int max) {
        java.util.Random ran = new java.util.Random();

        return (ran.nextInt(max) + 1);
    }
    /*
    RInt(int,int) randomly generates how much damage is dealt when encountering enemies.
     */
    public static int RInt(int min, int max) {
        java.util.Random ran = new java.util.Random();

        return (ran.nextInt((max - min) + 1) + min);
    }
}