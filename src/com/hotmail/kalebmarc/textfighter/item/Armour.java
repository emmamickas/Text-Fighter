package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Handle;
import com.hotmail.kalebmarc.textfighter.main.NPC;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Xp;

import java.util.ArrayList;
/**
 * Armour class is a defense mechanism for player
 *Armour can be purchased. Better armour is available when player levels up
 */
public class Armour {

    private static ArrayList<Armour> armours = new ArrayList<>(3);
    private String name;
    private int price;
    private int damResist;//x%
    private int level;
    private boolean owns;
    private boolean equipped;

    public Armour(String name, int price, int damResist, int level) {
        this.name = name;
        this.price = price;
        this.damResist = damResist;
        this.level = level;
        armours.add(this);
    }
    /**
     * Helper function for get()
     * Player choosing armour to use
     * @return chosen armour
     */
    public static Armour getEquipped() {
        for (Armour i : armours) {
            if (i.isEquipped()) return i;
        }
        Handle.error("Error - No armour equipped");
        return null;
    }
    /**
     * Getter for all the players armour
     * @return List of armour
     */
    public static ArrayList<Armour> getArmours() {
        return armours;
    }
    /**
     * Getter for armour player chooses
     * @return index of armour in List armours
     */
    public static int get() {
        return armours.indexOf(getEquipped());
    }
    /**
     * Sets which armour player is equipped with
     * @param i index at chosen armour
     */
    public static void set(int i) {
        armours.get(i).equipped = true;
    }
    /**
     * UI for player to choose armour to be equipped with
     */
    public static void choose() {
        while (true) {
            Ui.cls();
            Ui.println("----------------------------");
            Ui.println("Equip new armour");
            Ui.println();
            Ui.println("Equipped: " + getEquipped().toString());
            Ui.println("----------------------------");
            int j = 0;
            int[] offset = new int[getArmours().size()];
            for (int i = 0; i < getArmours().size(); i++) {
                if (getArmours().get(i).isOwns()) {
                    Ui.println((j + 1) + ") " + getArmours().get(i).getName());
                    offset[j] = i - j;
                    j++;
                }
            }

            //Get valid weapon index
            while (true) {//Make it easy to break, without going back to main store menu

                int menuItem = Ui.getValidInt();

                try { //This is probably pretty bad practice. Using exceptions as a functional part of the program. Use variables!

                    //reverts Weapon indexing
                    menuItem--;
                    menuItem = menuItem + offset[menuItem];

                    //Results go here:
                    Armour.getArmours().get(menuItem).equip();
                    return;

                } catch (Exception e) {
                    Ui.println();
                    Ui.println((menuItem + 1) + " is not an option.");
                }
            }
        }
    }
    /**
     * Getter for armours name
     * @return armours name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method is never used.
     * Setter for armours name
     * @param name
     */
    public void setName(String name) {
        if (name.equals("")) return;
        this.name = name;
    }
    /**
     * Getter for armours price
     * @return price of armour
     */
    public int getPrice() {
        return this.price;
    }
    /**
     * Method is never used.
     * Setter for armours price
     * @param price price of armour
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * Getter for damage resistance for an armour
     * @return armours damage resistance
     */
    public int getDamResist() {
        return this.damResist;
    }
    /**
     *  Method is never used.
     * Setter for damage resistance for an armour
     *
     */
    public void setDamResist(int damResist) {
        this.damResist = damResist;
    }
    /**
     * Getter for level armour can be unlocked
     * @return level armour can be unlocked
     */
    public int getLevel() {
        return this.level;
    }
    /**
     *  Method is never used.
     * Setter for level armour can be unlocked
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }
    /**
     * Checks to see if player owns armour
     * @return true if player owns the armour
     */
    public boolean isOwns() {
        return this.owns;
    }
    /**
     * Setter for owns 
     * @param owns true if player buys armour
     */
    public void setOwns(boolean owns) {
        this.owns = owns;
    }
    /**
     * Checks which armour player is using
     * @return true if player is currently using armour
     */
    public boolean isEquipped() {
        return this.equipped;
    }
    /*
    The armour the player is currently using is the armour the player is equipped with.
     */
    public void equip() {
        if (!(this.owns)) {
            Ui.msg("You do not own this.");
            return;
        }

        this.equipped = true;//To make sure something is already equipped
        getEquipped().unequip();
        this.equipped = true;
        Ui.msg("You have equipped " + this.toString());
    }
    /*
    When player purchases armour, player will be equipped (using currently) with this new armour,
    Player won't be notified in the UI.
     */
    public void equipSilent() {
        if (!(this.owns)) {
            return;
        }
        this.equipped = true;//To make sure something is already equipped
        getEquipped().unequip();
        this.equipped = true;
    }
    /**
     * Used when player has switched to a new armour
     */
    public void unequip() {
        this.equipped = false;
    }

    public String toString() {
        if (this.getName().equals("None")) return "No armour";
        return this.getName() + " armour";
    }
    /**
     * Menu to purchase armour
     * @return true if player purchases armour
     * 		   false if player isn't able to purchase armour
     */
    public boolean buy() {
        if (Xp.getLevel() < this.getLevel()) {
            Ui.println("You have to be at least level " + this.getLevel() + " to buy this!");
            Ui.pause();
            return false;
        } else if (this.isOwns()) {
            Ui.println("You already own this.");
            Ui.pause();
            return false;
        } else if (this.getPrice() <= Coins.get()) {
            Coins.set(-this.price, true);
            setOwns(true);
            equipSilent();
            NPC.gratitude("Armour", "purchase");
            Ui.pause();
            return true;
        } else {
            Ui.println("You do not have enough coins.");
            Ui.pause();
            return false;
        }
    }
    /**
     * Armour information in the Help Section.
     */
    public void viewAbout() {

        final int BORDER_LENGTH = 39;

        //Start of armour Info
        Ui.cls();
        for (int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//Make line
        Ui.println();
        for (int i = 0; i < ((BORDER_LENGTH / 2) - (this.getName().length() / 2)); i++)
            Ui.print(" ");//Set correct spacing to get name in middle of box
        Ui.println(this.toString());
        Ui.println("Price: " + this.price + " coins");
        Ui.println("Damage Resistance(%): " + this.damResist + "%");
        Ui.println("Level needed: " + this.level);
        for (int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//Make line
        Ui.pause();
        Ui.cls();
        //End of armour Info
    }

}
