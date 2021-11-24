package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Health;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

public class InstaHealth {
    public static int used = 0;
    public static int price;
    public static int level;
    private static int instaHealth;

    private InstaHealth() {
    }

    public static int get() {
        return instaHealth;
    }

    /**
     * Either sets the number of insta healths owned by the player to amount or adds amount to the number of insta healths owned by the player
     * @param amount
     * @param add whether or not amount is set or added
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
     * Checks whether user has an insta health to use, whether user can gain health, and adds the amount of health gained from an insta health
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
            Ui.println("Your health: " + Health.getAsString());
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
            Ui.println("Your health: " + Health.getAsString());
            Ui.println("Insta-Health's: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        }
    }

    /**
     * Checks if the insta health can be purchased and then sets the proper variables to signify purchase
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
