package com.hotmail.kalebmarc.textfighter.player;

public class Coins {

    private static int coins;
    private static int bank;


    private Coins() {
    }

    public static int get() {
        return coins;
    }

    /**
     * Either sets the number of coins owned by the player to amount or adds amount to the number of coins owned by the player
     * @param amount
     * @param add whether or not amount is set or added
     */
    public static void set(int amount, boolean add) {
        if (!add) {
            coins = amount;
        } else {
            coins += amount;
            if (amount < 0) Stats.totalCoinsSpent += -amount;
            if (coins < 0) coins = 0;
        }
    }

}