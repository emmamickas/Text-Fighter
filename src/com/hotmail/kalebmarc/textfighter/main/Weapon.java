package com.hotmail.kalebmarc.textfighter.main;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import com.hotmail.kalebmarc.textfighter.player.Achievements;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

public class Weapon implements Comparable<Weapon> {

    //Weapon List
    public static final ArrayList<Weapon> arrayWeapon = new ArrayList<>();
    //Properties
    public static int BULLET_DAMAGE;
    public static int BULLET_CRITICAL_MULTIPLIER;
    public static double BULLET_CRITICAL_CHANCE;
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
    private double criticalChanceMultiplier;
    private int criticalDamageMultiplierMin;
    private int criticalDamageMultiplierMax;
    private String name;
    private boolean buyable;
    //Ammo
    private int ammo;
    private int ammoUsed;
    private int ammoPrice;//Per 1
    private int ammoIncludedWithPurchase;

    /**
     * Constructor for weapon of type gun
     * @param name
     * @param ammoUsed
     * @param ammoIncludedWithPurchase
     * @param buyable
     * @param price
     * @param ammoPrice
     * @param level
     * @param chanceOfMissing
     * @param criticalChanceMultiplier
     * @param criticalDamageMultiplierMin
     * @param criticalDamageMultiplierMax
     * @param firstInitialization
     * @param changeDifficulty
     */
    public Weapon(String name, int ammoUsed, int ammoIncludedWithPurchase, boolean buyable, int price, //For guns
                  int ammoPrice, int level, double chanceOfMissing, double criticalChanceMultiplier, int criticalDamageMultiplierMin, int criticalDamageMultiplierMax, boolean firstInitialization, boolean changeDifficulty) {

        this.name = name;
        this.ammoUsed = ammoUsed;
        this.ammoIncludedWithPurchase = ammoIncludedWithPurchase;
        this.buyable = buyable;
        this.price = price;
        this.ammoPrice = ammoPrice;
        this.level = level;
        this.chanceOfMissing = chanceOfMissing;
        this.criticalChanceMultiplier = criticalChanceMultiplier;
        this.criticalDamageMultiplierMin = criticalDamageMultiplierMin;
        this.criticalDamageMultiplierMax = criticalDamageMultiplierMax;
        this.melee = false;

        if (!changeDifficulty) {
            arrayWeapon.add(this);
        }

        if (firstInitialization) {
            this.owns = false;

        }

        Collections.sort(arrayWeapon);

    }

    /**
     * Constructor for weapon of type melee
     * @param name
     * @param startingWeapon
     * @param buyable
     * @param price
     * @param level
     * @param damageMin
     * @param damageMax
     * @param firstInitialization
     * @param changeDifficulty
     */
    public Weapon(String name, boolean startingWeapon, boolean buyable, int price, int level,//For Melee
                  int damageMin, int damageMax, boolean firstInitialization, boolean changeDifficulty) {
        this.name = name;
        this.buyable = buyable;
        this.price = price;
        this.level = level;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.melee = true;

        if (!changeDifficulty) {
            arrayWeapon.add(this);
        }

        if (firstInitialization) {
            if (startingWeapon) {//If first init, see if player starts with this or not.
                this.owns = true;
                current = this;
                starting = this;
            } else {
                this.owns = false;
            }
        }
    }

    public static ArrayList<Weapon> getWeapons() {
        return arrayWeapon;
    }

    public static Weapon get() {
        return current;
    }

    static int getIndex(Weapon weapon) {
        return arrayWeapon.indexOf(weapon);
    }

    public static void set(Weapon weapon) {
        current = weapon;
    }

    public static void set(int weaponIndex) {
        current = arrayWeapon.get(weaponIndex);
    }

    /**
     * Allows for the user to select which weapon to be equipped
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
            int[] offset = new int[getWeapons().size()];
            for (int i = 0; i < getWeapons().size(); i++) {
                if (getWeapons().get(i).owns()) {
                    Ui.println((j + 1) + ") " + getWeapons().get(i).getName());
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
                    if (!getWeapons().get(menuItem).owns) {
                        Ui.msg("You do not own this weapon!");
                        return;
                    }

                    current = getWeapons().get(menuItem);
                    Ui.msg("You have equipped a " + getWeapons().get(menuItem).getName());
                    return;

                } catch (Exception e) {
                    Ui.println();
                    Ui.println(menuItem + " is not an option.");
                }
            }
        }
    }

    private static void noAmmo() {
        Ui.popup("You've run out of ammo!", "Warning", JOptionPane.WARNING_MESSAGE);
        Weapon.current = Weapon.starting;
    }

    public static void displayAmmo() {
        if (!(Weapon.get().melee)) {
            Ui.println("     Ammo: " + Weapon.get().getAmmo());
        }
    }

    public String getName() {
        return name;
    }

    public boolean owns() {
        return owns;
    }

    public void setAmmo(int amount, boolean add) {
        if (this.melee) return;
        if (add) {
            this.ammo += amount;
        } else {
            this.ammo = amount;
        }
    }

    public int getAmmo() {
        return this.ammo;
    }

    public int getDamageDealt() {
        return this.damageDealt;
    }

    /**
     * Calculates the damage to be dealt by the weapon and calls necessary functions to apply damage dealt
     */
    public void dealDamage() {

        if (this.melee) {
            /*
             * Melee Attack
             */
            damageDealt = Random.randomInt(this.damageMin, this.damageMax);
        } else {

            /*
             * Gun Attack
             */
            if (getAmmo() >= this.ammoUsed) {

                for (int i = 1; i <= this.ammoUsed; i++) {
                    if (Random.randomInt(100) > this.chanceOfMissing) {
                        damageDealt += BULLET_DAMAGE;
                        Stats.bulletsThatHit++;

                    }

                    //Results
                    setAmmo(-1, true);
                    Stats.bulletsFired += 1;
                }
                //Run the logic for critical hit
                criticalHit();
                bulletCriticalHit();

            } else {
                noAmmo();
                damageDealt = 0;
            }
        }

        //Display stuff
        com.hotmail.kalebmarc.textfighter.player.Stats.totalDamageDealt += damageDealt;
        com.hotmail.kalebmarc.textfighter.player.Xp.setBattleXp(damageDealt, true);
        if(!Enemy.get().takeDamage(damageDealt)) { // !dead
            Ui.cls();
            Ui.println("----------------------------------------------------");
            Ui.println("You have attacked a " + Enemy.get().getName() + "!");
            Ui.println("You dealt " + damageDealt + " damage with a " + this.name);
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + com.hotmail.kalebmarc.textfighter.player.Health.getAsString());
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
     * Applies logic for a critical hit
     */
    private void criticalHit() {

        if (wasCriticalHit()) {
            int critMultiplier = Random.randomInt(this.criticalDamageMultiplierMin, this.criticalDamageMultiplierMax);

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
     * Applies logic for a bullet critical hit
     */
    private void bulletCriticalHit() {
    	
    	if (bulletWasCriticalHit()) {

            damageDealt *= Weapon.BULLET_CRITICAL_MULTIPLIER;

            Ui.cls();
            Ui.println("----------------------------------------------------");
            Ui.println("Critical Bullet Hit!");
            Ui.println("Your bullets dealt " + Weapon.BULLET_CRITICAL_MULTIPLIER + "x normal damage.");
            Ui.println("----------------------------------------------------");
            Ui.pause();

        }
    }

    private boolean wasCriticalHit() {
        return Random.randomInt((int) (100 / this.criticalChanceMultiplier)) == 1;
    }
    
    private boolean bulletWasCriticalHit() {
    	return Random.randomInt((int) (100 / Weapon.BULLET_CRITICAL_CHANCE)) == 1;
    }

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
        Ui.println("Chance of critical hit: " + this.criticalChanceMultiplier + "%");
        Ui.println("Critical hit damage multiplier: " + this.criticalDamageMultiplierMin + "-" + this.criticalDamageMultiplierMax + "x");
        if (!this.melee) {
            Ui.println("Chance of critical hit, bullet: " + Weapon.BULLET_CRITICAL_CHANCE + "%");
            Ui.println("Bullet Critical of critical hit, bullet: " + Weapon.BULLET_CRITICAL_MULTIPLIER + "x");
        }
        for (int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//Make line
        Ui.pause();
        Ui.cls();
        //End of weapon Info
    }

    /**
     * Get the amount of damage that a weapon can deal
     * @return
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

    public boolean isBuyable() {
        return this.buyable;
    }

    /**
     * Checks if the weapon can be purchased and then sets the proper variables to signify ownership
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
     * Checks if the ammo can be purchased and then sets the proper variables to signify ownership
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
    public int compareTo(Weapon weapon) {
        return Integer.compare(this.level, weapon.level);
    }
}