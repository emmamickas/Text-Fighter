package com.hotmail.kalebmarc.textfighter.player;

import com.hotmail.kalebmarc.textfighter.main.Handle;
import com.hotmail.kalebmarc.textfighter.main.Ui;

public class Potion {
    public static int survivalPotionUsed = 0;
    public static int survivalPotionLevel;
    public static int survivalPotionPrice;
    //TODO will eventually add potions to heal status ailments
    //TODO possibly add potion that gives player a temporary strength boost (Does more damage)
    public static int recoveryPotionUsed = 0;
    public static int recoveryPotionLevel;
    public static int recoveryPotionPrice;
    private static int survivalPotion; //potion that heals 25% of health
    private static int recoveryPotion; //potion that heals 75% of health

    private Potion() {
    }

    public static int get(String kind) {
        switch (kind.toLowerCase()) {
            case "survival":
                return survivalPotion;
            case "recovery":
                return recoveryPotion;
            default:
                return 0; //need to modify
        }
    }

    public static void set(String kind, int amount, boolean add) {
        switch (kind.toLowerCase()) {
            case "survival":
                if (!add) {
                    survivalPotion = amount;
                } else {
                    survivalPotion += amount;
                    if (survivalPotion < 0) survivalPotion = 0;
                }
                break;
            case "recovery":
                if (!add) {
                    recoveryPotion = amount;
                } else {
                    recoveryPotion += amount;
                    if (recoveryPotion < 0) recoveryPotion = 0;
                }
                break;
            default:
                Handle.error("Unknown potion type: " + kind);
        }
    }

    public static void use(String potionKind) {
        String kind = potionKind.trim().substring(0, 1).toUpperCase()
                + potionKind.substring(1).toLowerCase();
        Ui.cls();

        if (get(kind) <= 0) {

            Ui.println("----------------------------------------------------");
            Ui.println("You have no " + kind + " Potions left!");
            Ui.println("Go to the shop to buy some more.");
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else if (Health.get() == 100) {

            Ui.println("----------------------------------------------------");
            Ui.println("You already have full health!");
            Ui.println("You don't need to use a " + kind + " Potion!");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getAsString());
            Ui.println(kind + " Potions: " + get(kind));
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else {

            set(kind, -1, true);
            int heal = (int) Math.round(healBy(kind));
            Health.gain(heal);
            used(kind);

            Ui.println("----------------------------------------------------");
            Ui.println("You have used a " + kind + " Potion.");
            Ui.println("You've gained " + heal + " health.");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getAsString());
            Ui.println(kind + " Potions: " + get(kind));
            Ui.println("----------------------------------------------------");
            Ui.pause();

        }

    }

    public static double healBy(String kind) {
        switch (kind.toLowerCase()) {
            case "survival":
                return Health.getOutOf() * .25;
            case "recovery":
                return Health.getOutOf() * .75;
            default:
                return 0;
        }
    }

    public static void used(String kind) {
        switch (kind.toLowerCase()) {
            case "survival":
                survivalPotionUsed++;
                break;
            case "recovery":
                recoveryPotionUsed++;
                break;
        }
    }

    public static void buy(String kind) {

        int level = getLevel(kind);
        int price = getPrice(kind);

        if (Xp.getLevel() < level) {
            Ui.println("You have to be at least level " + level + " to buy this!");
            Ui.pause();
        } else if (price <= Coins.get()) {
            Coins.set(-price, true);
            Stats.coinsSpentOnHealth += price;
            set(kind, 1, true);
            Ui.println("Thank you for your purchase. Come again soon! ");
            Ui.pause();
        } else {
            Ui.println("You do not have enough coins.");
            Ui.pause();
        }
    }

    public static int getLevel(String kind) {
        switch (kind.toLowerCase()) {
            case "survival":
                return survivalPotionLevel;
            case "recovery":
                return recoveryPotionLevel;
            default:
                return 0; //need to modify
        }
    }

    public static int getPrice(String kind) {
        switch (kind.toLowerCase()) {
            case "survival":
                return survivalPotionPrice;
            case "recovery":
                return recoveryPotionPrice;
            default:
                return 0; //need to modify
        }
    }
}
