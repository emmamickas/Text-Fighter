package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Enemy;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;
/**
 * 
 *  Power Class allows the player to kill an enemy instantly.
 */
public class Power {

    public static int used = 0;
    public static int price;
    public static int level;
    private static int powers;

    /**
     * Getter for powers
     * @return number of powers available
     */
    public static int get() {
        return powers;
    }
    /**
     * Setter for powers
     * @param amount number of powers
     * @param add true if amount is added to the total of powers available
     * 		      false if amount is the total of powers
     */	
    public static void set(int amount, boolean add) {
        if (!add) {
            powers = amount;
        } else {
            powers += amount;
            if (powers < 0) powers = 0;
        }
    }

    /**
     * Use Power 
     * Kill enemy instantly
     * Decrease players number of powers available.
     */
    public static void use() {

        Ui.cls();

        if (powers <= 0) {
            Ui.println("----------------------------------------------------");
            Ui.println("You have no POWER's left!");
            Ui.println("Go to the shop to buy some more.");
            Ui.println("----------------------------------------------------");
            Ui.pause();
        } else {
            powers--;
            used++;
            Xp.set(20, true);
            Enemy.get().takeDamage(Enemy.get().getHealth());
            Ui.println("----------------------------------------------------");
            Ui.println("You have used a POWER.");
            Ui.println("The enemy has instantly died.");
            Ui.println("----------------------------------------------------");
            Ui.println("Enemy Health: " + Enemy.get().getHeathStr());
            Ui.println("POWER's: " + powers);
            Ui.println("----------------------------------------------------");
            Ui.pause();
        }
    }

    /**
     * Purcahse power if player is at high enough level and has enough coins
     */
    public static void buy() {
        if (Xp.getLevel() < level) {
            Ui.println("You have to be at least level " + level + " to buy this!");
            Ui.pause();
        } else if (price <= Coins.get()) {
            Coins.set(-price, true);
            Stats.coinsSpentOnWeapons += price;
            set(1, true);
            Ui.println("Thank you for your purchase. Come again soon! ");
            Ui.pause();
        } else {
            Ui.println("You do not have enough coins.");
            Ui.pause();
        }
    }
}
