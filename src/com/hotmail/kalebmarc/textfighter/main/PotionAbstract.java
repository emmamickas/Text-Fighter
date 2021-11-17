package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Health;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

public abstract class PotionAbstract {

    protected static int used = 0;
    protected static int level;
    protected static int price;
    protected static String name;
    protected static int totalPotions;
    protected static int damage;



    protected  PotionAbstract(String name, int damage, int price, int level) {
        this.name = name;
        this.damage = damage;
        this.level = level;
        this.price = price;
    }

    public PotionAbstract() {

    }


    public static int get() {
        return totalPotions;
        }


    public static void set( int amount, boolean add) {

                if (!add) {
                    totalPotions = amount;
                } else {
                    totalPotions += amount;
                    if (totalPotions < 0) totalPotions = 0;
                }

        }


    public static void use() {

        Ui.cls();

        if (get() <= 0) {

            Ui.println("----------------------------------------------------");
            Ui.println("You have no " + name + " Potions left!");
            Ui.println("Go to the shop to buy some more.");
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else if (Health.get() == 100) {

            Ui.println("----------------------------------------------------");
            Ui.println("You already have full health!");
            Ui.println("You don't need to use a " + name + " Potion!");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getStr());
            Ui.println(name + " Potions: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else {

            set(-1, true);
            int heal = (int) Math.round(healBy());
            Health.gain(heal);
            used();

            Ui.println("----------------------------------------------------");
            Ui.println("You have used a " + name + " Potion.");
            Ui.println("You've gained " + heal + " health.");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getStr());
            Ui.println(name + " Potions: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        }

    }

    public static double healBy() {
        return Health.getOutOf() * damage;
    }

    public static void used() {
        used++;
    }

    public static void buy() {

        int level = getLevel();
        int price = getPrice();

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

    public static int getLevel() {
        return level;
    }

    public static int getPrice() {
       return price;
    }
}
