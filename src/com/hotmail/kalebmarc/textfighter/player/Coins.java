package com.hotmail.kalebmarc.textfighter.player;

// Coins are used by the player to purchase items e.g. food, weapons and visit the casino
public class Coins {

    private static int coins;
    private static int bank;


    private Coins() {
    }


    /**
     * Gets the players current amount of coins
     * @return int players coins
     */
    public static int get() {
        return coins;
    }


    /**
     * Setting the amount of coins a player has, updating player stats.
     * @param amount amount of coins player will have
     * @param add true if player is withdrawing coins, taking coins from enemy, purchasing items.
     *            false when a player uses cheat to increase coin amount.
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