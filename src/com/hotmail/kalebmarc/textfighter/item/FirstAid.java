package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Health;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

/*
FirstAid is used to increase a players' health. A FirstAid kit can increase health by 20 points.
FirstAid can be purchased at a shop.
 */
public class FirstAid {
    public static int used = 0;
    public static int price;
    public static int level;
    private static int firstAid;

    private FirstAid() {
    }
    /**
     * Getter for first aid kits
     * @return number of first aid kits available
     */
    public static int get() {
        return firstAid;
    }
    /**
     * Setter for first aid kits
     * @param amount number of first aid kits
     * @param add true if amount is added to total number of first aid kits
     * 			  false if amount is the total number of first aid kits.
     */		  
    public static void set(int amount, boolean add) {
        if (!add) {
            firstAid = amount;
        } else {
            firstAid += amount;
            if (firstAid < 0) firstAid = 0;
        }
    }
    /**
     * Uses first aid kit on player or enemy
     * Increases health by 20 points
     * Decreases number of first aid kits available
     */
    public static void use() {

        Ui.cls();

        if (get() <= 0) {

            Ui.println("----------------------------------------------------");
            Ui.println("You have no First-Aid kits left!");
            Ui.println("Go to the shop to buy some more.");
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else if (Health.get() == 100) {

            Ui.println("----------------------------------------------------");
            Ui.println("You already have full health!");
            Ui.println("You don't need a First-Aid kit!");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getStr());
            Ui.println("First-Aid kits: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else {

            set(-1, true);
            Health.gain(20);
            used++;

            Ui.println("----------------------------------------------------");
            Ui.println("You have used a First-Aid kit.");
            Ui.println("You've gained 20 health.");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getStr());
            Ui.println("First-Aid kits: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        }

    }
    /**
     * Purchase first aid kit if player is at high enough level and has enough coins
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
