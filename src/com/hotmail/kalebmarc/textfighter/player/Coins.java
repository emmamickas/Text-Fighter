package com.hotmail.kalebmarc.textfighter.player;

// Coins are used by the player to purchase items e.g. food, weapons and visit the casino
public class Coins {

    private static int coins;
    private static int bank;


    private Coins() {
    }

    //Return the current amount of coins
    public static int get() {
        return coins;
    }

    // Adding coins to a player and updating player stats.
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