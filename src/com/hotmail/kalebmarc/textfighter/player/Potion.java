package com.hotmail.kalebmarc.textfighter.player;

import com.hotmail.kalebmarc.textfighter.main.Enemy;
import com.hotmail.kalebmarc.textfighter.main.Handle;
import com.hotmail.kalebmarc.textfighter.main.Ui;
/*
 * Potion class is used to heal player or inflict damage to an enemy.
 */
public class Potion {
    public static int spUsed = 0;
    public static int spLevel;
    public static int spPrice;
    //TODO will eventually add potions to heal status ailments
    //TODO possibly add potion that gives player a temporary strength boost (Does more damage)
    public static int rpUsed = 0;
    public static int rpLevel;
    public static int rpPrice;
    private static int survivalPotion; //potion that heals 25% of health
    private static int recoveryPotion; //potion that heals 75% of health
    public static int poisonPotion;    //potion that reduces enemies health by 30 health points.
    public static int ppUsed = 0;
    public static int ppLevel;
    public static int ppPrice;
    
    private Potion() {

    }
    
    /**
     * Getter for potion.
     * @param kind type of potion.
     * @return number of potions player possess.
     */
    public static int get(String kind) {
        switch (kind.toLowerCase()) {
            case "survival":
                return survivalPotion;
            case "recovery":
                return recoveryPotion;
            case "poison":
                return poisonPotion;
            default:
                return 0; //need to modify
        }
    }
    /**
     * Setter for potion.
     * @param kind type of potion.
     * @param amount number of potions player will have.
     * @param add true if player is accumulating a total of potions. 
     * 		      false if player is setting potion.
     */
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
            case "poison":
                if (!add) {
                    poisonPotion = amount;
                } else {
                    poisonPotion += amount;
                    if (poisonPotion < 0) poisonPotion= 0;
                }
                break;
            default:
                Handle.error("Unknown potion type: " + kind);
        }
    }

    /**
     * Called to use potions during game.
     * @param k type of potion being used.
     */
    public static void use(String k) {
        String kind = k.trim().substring(0, 1).toUpperCase()
                + k.substring(1).toLowerCase();
        Ui.cls();
        // If player doesn't have any potions available, they cannot use any.
        if (get(kind) <= 0) {

            Ui.println("----------------------------------------------------");
            Ui.println("You have no " + kind + " Potions left!");
            Ui.println("Go to the shop to buy some more.");
            Ui.println("----------------------------------------------------");
            Ui.pause();
           //If poison type is used enemy will lose 30 health points.  
        } else if(k == "poison"){
            int enemiesHealth = Enemy.get().getHealth()-30;
            //If enemies health is below 0, enemies health reverts to 0;
            if(enemiesHealth < 0 ) enemiesHealth = 0;
            Ui.println("----------------------------------------------------");
            Ui.println("You are poisoning the " + Enemy.get().getName() +"!");
            Ui.println(Enemy.get().getName()+"'s health is now " + enemiesHealth );
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getStr());
            Ui.println(kind + " Potions: " + get(kind));
            Ui.println("----------------------------------------------------");
            //Enemy is dealt 30 damage
            Enemy.get().takeDamage(30);
            //Player totalDamageDealt stat is updated.
            com.hotmail.kalebmarc.textfighter.player.Stats.totalDamageDealt += 30;
            //Poison count is reduced by 1.
            set(kind, -1, true);
            //Potions used stat is updated.
            used(kind);
            Ui.pause();


        }
        //If health is 100 player cant use potion to heal themselves.
        else if (Health.get() == 100) {

            Ui.println("----------------------------------------------------");
            Ui.println("You already have full health!");
            Ui.println("You don't need to use a " + kind + " Potion!");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getStr());
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
            Ui.println("Your health: " + Health.getStr());
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
    //Updates potions used stats.
    public static void used(String kind) {
        switch (kind.toLowerCase()) {
            case "survival":
                spUsed++;
            case "recovery":
                rpUsed++;
            case "poison":
                ppUsed++;
        }
    }
    
    /**
     * Used in the shop to purchase potions
     * @param kind type of potion that is being purchased
     */
    public static void buy(String kind) {

        int level = getLevel(kind);
        int price = getPrice(kind);
        //If user isn't at a high enough level or enough coins they cannot purchase potions.
        if (Xp.getLevel() < level) {
            Ui.println("You have to be at least level " + level + " to buy this!");
            Ui.pause();
        } else if (price <= Coins.get()) {
            Coins.set(-price, true);
            if(kind != "poison") Stats.coinsSpentOnHealth += price;
            else{Stats.coinsSpentOnPoison += price;}
            set(kind, 1, true);
            Ui.println("Thank you for your purchase. Come again soon! ");
            Ui.pause();
        } else {
            Ui.println("You do not have enough coins.");
            Ui.pause();
        }
    }
    /**
     * Getter for the level that must be met to purchase potions
     * @param kind potion type
     * @return level that is necessary to purchase a potion.
     */
    public static int getLevel(String kind) {
        switch (kind.toLowerCase()) {
            case "survival":
                return spLevel;
            case "recovery":
                return rpLevel;
            case "poison":
                return ppLevel;
            default:
                return 0; //need to modify
        }
    }
    /**
     * Getter for price of potion.
     * @param kind potion type.
     * @return price for specified potion.
     */
    public static int getPrice(String kind) {
        switch (kind.toLowerCase()) {
            case "survival":
                return spPrice;
            case "recovery":
                return rpPrice;
            case "poison":
                return ppPrice;
            default:
                return 0; //need to modify
        }
    }
    
    public static void brewPotion(String kind) {
    	
    }
}
