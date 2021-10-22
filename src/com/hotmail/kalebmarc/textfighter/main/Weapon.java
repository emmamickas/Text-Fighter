package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Achievements;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Weapon implements Comparable<Weapon> {

    //Weapon List
    public static final ArrayList<Weapon> arrayWeapon = new ArrayList<>();
    //Properties
    public static int BULLET_DAMAGE;
    //Variables
    public static Weapon starting;
    private static Weapon current = null;
    public int price;
    public int level;
    public boolean melee;
    public boolean owns;
    private int damageMin;
    private int damageMax;
    private int damageDealt;
    private double chanceOfMissing;
    private double critChanceMultiplier;
    private int critDamMultiplierMin;
    private int critDamMultiplierMax;
    private String name;
    private boolean buyable;
    //Ammo
    private int ammo;
    private int ammoUsed;
    private int ammoPrice;//Per 1
    private int ammoIncludedWithPurchase;
   /**
    * Weapon constructor for gun weapons
    * @param name
    * @param ammoUsed
    * @param ammoIncludedWithPurchase
    * @param buyable
    * @param price
    * @param ammoPrice
    * @param level
    * @param chanceOfMissing
    * @param critChanceMultiplier
    * @param critDamMultiplierMin
    * @param critDamMultiplierMax
    * @param firstInit
    * @param changeDif
    */
    public Weapon(String name, int ammoUsed, int ammoIncludedWithPurchase, boolean buyable, int price, //For guns
                  int ammoPrice, int level, double chanceOfMissing, double critChanceMultiplier, int critDamMultiplierMin, int critDamMultiplierMax, boolean firstInit, boolean changeDif) {

        this.name = name;
        this.ammoUsed = ammoUsed;
        this.ammoIncludedWithPurchase = ammoIncludedWithPurchase;
        this.buyable = buyable;
        this.price = price;
        this.ammoPrice = ammoPrice;
        this.level = level;
        this.chanceOfMissing = chanceOfMissing;
        this.critChanceMultiplier = critChanceMultiplier;
        this.critDamMultiplierMin = critDamMultiplierMin;
        this.critDamMultiplierMax = critDamMultiplierMax;
        this.melee = false;

        if (!changeDif) {
            arrayWeapon.add(this);
        }

        if (firstInit) {
            this.owns = false;

        }

        Collections.sort(arrayWeapon);

    }
/**
 * Weapon constructor for melee weapons
 * @param name
 * @param startingWeapon
 * @param buyable
 * @param price
 * @param level
 * @param damageMin
 * @param damageMax
 * @param firstInit
 * @param changeDif
 */
    public Weapon(String name, boolean startingWeapon, boolean buyable, int price, int level,//For Melee
                  int damageMin, int damageMax, boolean firstInit, boolean changeDif) {
        this.name = name;
        this.buyable = buyable;
        this.price = price;
        this.level = level;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.melee = true;

        if (!changeDif) {
            arrayWeapon.add(this);
        }

        if (firstInit) {
            if (startingWeapon) {//If first init, see if player starts with this or not.
                this.owns = true;
                current = this;
                starting = this;
            } else {
                this.owns = false;
            }
        }
    }

    /**
     * Get current weapon.
     * @return current weapon
     */
    public static Weapon get() {
        return current;
    }

    /**
     *Method is  not used.
     */
    static int getIndex(Weapon i) {
        return arrayWeapon.indexOf(i);
    }

    /**
     * Set current weapon
     * @param x weapon chosen by player.
     */
    public static void set(Weapon x) {
        current = x;
    }

    public static void set(int i) {
        current = arrayWeapon.get(i);
    }

    /**
     * Display weapons to choose from.
     */
    public static void choose() {
        while (true) {
            Ui.cls();
            Ui.println("----------------------------");
            Ui.println("Equip new weapon");
            Ui.println();
            Ui.println("Ammo: " + current.getAmmo());
            Ui.println("Equipped weapon: " + current.getName());
            Ui.println("----------------------------");
            int j = 0;
            int[] offset = new int[arrayWeapon.size()];
            for (int i = 0; i < arrayWeapon.size(); i++) {
                if (arrayWeapon.get(i).owns()) {
                    Ui.println((j + 1) + ") " + arrayWeapon.get(i).getName());
                    offset[j] = i - j;
                    j++;
                }
            }
            Ui.println((j + 1) + ") Back");

            while (true) {

                int menuItem = Ui.getValidInt();

                try {

                    //choices other than options in the array go here:
                    if (menuItem == (j + 1) || menuItem > j)
                        return;

                    //reverts back to Weapon indexing
                    menuItem--;
                    menuItem = menuItem + offset[menuItem];

                    //Testing to make sure the option is valid goes here:
                    if (!arrayWeapon.get(menuItem).owns) {
                        Ui.msg("You do not own this weapon!");
                        return;
                    }

                    current = arrayWeapon.get(menuItem);
                    Ui.msg("You have equipped a " + arrayWeapon.get(menuItem).getName());
                    return;

                } catch (Exception e) {
                    Ui.println();
                    Ui.println(menuItem + " is not an option.");
                }
            }
        }
    }

    /**
     * Display player has run out of ammo.
     */
    private static void noAmmo() {
        Ui.popup("You've run out of ammo!", "Warning", JOptionPane.WARNING_MESSAGE);
        Weapon.current = Weapon.starting;
    }

    /**
     * Display how much ammo current weapon has.
     */
    public static void displayAmmo() {
        if (!(Weapon.get().melee)) {
            Ui.println("     Ammo: " + Weapon.get().getAmmo());
        }
    }

    /**
     * Gets the weapons name
     * @return string weapons name.
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if player owns a certain weapon
     * @return true if the player owns the weapon.
     * false if the player doesn't own the weapon.
     */
    public boolean owns() {
        return owns;
    }

    /**
     * Sets ammo amount when purchasing ammo.
     * @param amount amount of ammo purchased. negative number is ammo was used.
     * @param add true if ammo is purchased. False if ammo was accumulated from cheat.
     */
    public void setAmmo(int amount, boolean add) {
        if (this.melee) return;
        if (add) {
            this.ammo += amount;
        } else {
            this.ammo = amount;
        }
    }

    /**
     * Gets the ammo amount.
     * @return int amount of ammo player has.
     */
    public int getAmmo() {
        return this.ammo;
    }

    /**
     * Gets the damage dealt to an enemy after a fight
     * @return int how much damage was dealt to enemy.
     */
    public int getDamageDealt() {
        return this.damageDealt;
    }

    /**
     * Calculates how much damage was dealt according to which kind of fight took place.
     * Melee is a random number generated between minimum and maximum damage allotted.
     * Gun attack is determined by ammo used and if there was a critical hit.
     */
    public void dealDam() {

        if (this.melee) {
            /*
             * Melee Attack
             */
            damageDealt = Random.RInt(this.damageMin, this.damageMax);
        } else {

            /*
             * Gun Attack
             */
            if (getAmmo() >= this.ammoUsed) {

                for (int i = 1; i <= this.ammoUsed; i++) {
                    if (Random.RInt(100) > this.chanceOfMissing) {
                        damageDealt += BULLET_DAMAGE;
                        Stats.bulletsThatHit++;

                    }

                    //Results
                    setAmmo(-1, true);
                    Stats.bulletsFired += 1;
                }
                //Run the logic for critical hit
                criticalHit();

            } else {
                noAmmo();
                damageDealt = 0;
            }
        }

        //Display stats from the current attack
        com.hotmail.kalebmarc.textfighter.player.Stats.totalDamageDealt += damageDealt;
        com.hotmail.kalebmarc.textfighter.player.Xp.setBattleXp(damageDealt, true);
        if(!Enemy.get().takeDamage(damageDealt)) { // !dead
            Ui.cls();
            Ui.println("----------------------------------------------------");
            Ui.println("You have attacked a " + Enemy.get().getName() + "!");
            Ui.println("You dealt " + damageDealt + " damage with a " + this.name);
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + com.hotmail.kalebmarc.textfighter.player.Health.getStr());
            Ui.println("Enemy health: " + Enemy.get().getHeathStr());
            Ui.println("----------------------------------------------------");
            Ui.pause();

            if (Enemy.get().getHealth() <= Enemy.get().getHealthMax() / 3){
                Enemy.get().useFirstAidKit();
            }
        }
        damageDealt = 0;
    }

    /**
     * Displays critical hit has happened.
     */
    private void criticalHit() {

        if (wasCriticalHit()) {
            int critMultiplier = Random.RInt(this.critDamMultiplierMin, this.critDamMultiplierMax);

            damageDealt *= critMultiplier;

            Ui.cls();
            Ui.println("----------------------------------------------------");
            Ui.println("Critical Hit!");
            Ui.println("You dealt " + critMultiplier + "x normal damage.");
            Ui.println("----------------------------------------------------");
            Ui.pause();

        }
    }

    /**
     * Determines if a critical hit has taken place.
     *
     * @return true if there was a critical hit
     */
    private boolean wasCriticalHit() {
        return Random.RInt((int) (100 / this.critChanceMultiplier)) == 1;
    }

    /**
     * Displays information about weapons in the Help section.
     */
    public void viewAbout() {

        final int BORDER_LENGTH = 39;

        //Start of weapon Info
        Ui.cls();
        for (int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//Make line
        Ui.println();
        for (int i = 0; i < ((BORDER_LENGTH / 2) - (this.getName().length() / 2)); i++)
            Ui.print(" ");//Set correct spacing to get name in middle of box
        Ui.println(this.getName());
        Ui.println("Price: " + this.price + " coins");
        Ui.println("Chance of missing: " + this.chanceOfMissing + "%");
        Ui.println("Ammo Used: " + this.ammoUsed);
        Ui.println("Damage: " + this.getDamage());
        Ui.println("Chance of critical hit: " + this.critChanceMultiplier + "%");
        Ui.println("Critical hit damage multiplier: " + this.critDamMultiplierMin + "-" + this.critDamMultiplierMax + "x");
        for (int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//Make line
        Ui.pause();
        Ui.cls();
        //End of weapon Info
    }

    /**
     * Gets the damage information
     * @return string that displays minimum and maximum damage.
     */
    private String getDamage() {
        if (this.melee) {
            return (this.damageMin + " - " + this.damageMax);
        } else {
            if (this.chanceOfMissing == 0) {
                return String.valueOf((BULLET_DAMAGE * this.ammoUsed));
            } else {
                return ("0 - " + String.valueOf((BULLET_DAMAGE * this.ammoUsed)));
            }
        }
    }

    /**
     * Checks if an item is available at the shop.
     * @return true if a player has a high enough level and enough coins to purchase weapon.
     */
    public boolean isBuyable() {
        return this.buyable;
    }

    /**
     * Purchase weapon if player doesn't already own it, has high enough level and has enough coins,
     */
    public void buy() {
        if (!isBuyable()) {
            Ui.msg("Sorry, this item is no longer in stock.");
            return;
        }
        if (this.owns()) {
            Ui.msg("You already own this weapon.");
            return;
        }
        if (level > Xp.getLevel()) {
            Ui.msg("You are not a high enough level to buy this item.");
            return;
        }
        if (price > Coins.get()) {
            Ui.msg("You do not have enough coins to buy this item.");
            return;
        }

        //Buy
        Achievements.boughtItem = true;
        Coins.set(-price, true);
        Stats.coinsSpentOnWeapons += price;
        this.owns = true;
        current = this;
        Ui.println("You have bought a " + this.getName() + " for " + this.price + " coins.");
        Ui.println("Coins: " + Coins.get());
        Ui.pause();

        //Give ammo
        ammo += this.ammoIncludedWithPurchase;

    }

    /**
     * Purchases ammo is player is at high enough level and has enough coins.
     */
    public void buyAmmo() {

        Ui.cls();

        //Make sure player is a high enough level
        if (Xp.getLevel() < this.level) {
            Ui.println("You are not a high enough level. You need to be at least level " + this.level + ".");
            Ui.pause();
            return;
        }

        //Get amount of ammo user wants
        Ui.println("How much ammo would you like to buy?");
        Ui.println("1 ammo cost " + this.ammoPrice + " coins.");
        Ui.println("You have " + Coins.get() + " coins.");
        int ammoToBuy = Ui.getValidInt();
        int cost = ammoToBuy * ammoPrice;

        //Make sure player has enough coins
        if (Coins.get() < (cost)) {
            Ui.println("You don't have enough coins. You need " + (cost - Coins.get()) + " more coins.");
            Ui.pause();
            return;
        }

        this.ammo += ammoToBuy;
        Coins.set(-cost, true);
        Stats.coinsSpentOnWeapons += cost;

        Ui.println("You have bought " + ammoToBuy + " ammo.");
        Ui.pause();
    }

    public int getAmmoPrice() {
        return this.ammoPrice;
    }

    @Override
    public int compareTo(Weapon w) {
        return Integer.compare(this.level, w.level);
    }
}