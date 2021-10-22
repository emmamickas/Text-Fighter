package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Health;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;
/**
 * InstaHealth class allows player to fully heal themselves
 *
 */
public class InstaHealth {
    public static int used = 0;
    public static int price;
    public static int level;
    private static int instaHealth;

    private InstaHealth() {
    }
    /**
     * Getter for InstaHealth
     * @return number of InstaHealth available
     */
    public static int get() {
        return instaHealth;
    }
    /**
     * Setter for InstaHealth
     * @param amount number of InstaHealth
     * @param add true if amount is added to the total of InstaHealth available
     * 		      false if amount is the total of InstaHealth
     */		      
    public static void set(int amount, boolean add) {
        if (!add) {
            instaHealth = amount;
        } else {
            instaHealth += amount;
            if (instaHealth < 0) instaHealth = 0;
        }
    }
    /**
     * Use InstaHealth
     * Increases Health to 100
     * Decreases number of InstaHealth available.
     */
    public static void use() {

        Ui.cls();
        if (get() <= 0) {

            Ui.println("----------------------------------------------------");
            Ui.println("You have no Insta-Health's left!");
            Ui.println("Go to the shop to buy some more.");
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else if (Health.get() == 100) {

            Ui.println("----------------------------------------------------");
            Ui.println("You already have full health!");
            Ui.println("You don't need an Insta-Health!");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getStr());
            Ui.println("Insta-Health's: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else {

            set(-1, true);
            Health.set(Health.getOutOf());
            used++;

            Ui.println("----------------------------------------------------");
            Ui.println("You have used an Insta-Health.");
            Ui.println("You're health has been fully restored.");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getStr());
            Ui.println("Insta-Health's: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        }
    }

    /**
     * Purchase InstaHealth if user is at high enough level and has enough coins
     */
    public static void buy() {
        if (Xp.getLevel() < level) {
            Ui.println("You have to be at least level " + level + " to buy this!");
            Ui.pause();
        } else if (price <= Coins.get()) {
            Coins.set(-price, true);
            Stats.coinsSpentOnHealth += price;
            set(1, true);
            Ui.println("Thank you for your purchase. Come again soon! ");
            Ui.pause();
        } else {
            Ui.println("You do not have enough coins.");
            Ui.pause();
        }
    }
}
