package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Health;

import java.util.ArrayList;

public class Food {

    //Food List
    public static final ArrayList<Food> arrayFood = new ArrayList<>();
    public static int totalEaten;
    private String name;
    private String desc;
    private int quantity = 1;//TODO change to not have a default value once done testing
    private StatusEffect.type statusEffect;
    private int effectLevel;
    private type foodType;
    //for ach
    private boolean viewedAbout;

    public Food(String name, String desc, StatusEffect.type statusEffect, type foodType, int effectLevel) {
        this.name = name;
        this.desc = desc;
        this.statusEffect = statusEffect;
        this.foodType = foodType;
        this.effectLevel = effectLevel;
        arrayFood.add(this);
    }

    public static void list() {

        while (true) {
            Ui.cls();
            int j = 0;
            int[] offset = new int[arrayFood.size()];
            for (int i = 0; i < arrayFood.size(); i++) {
                if (arrayFood.get(i).quantity > 0) {
                    Ui.println((j + 1) + ") " + arrayFood.get(i).getName() + "(" + arrayFood.get(i).quantity + ")");
                    offset[j] = i - j;
                    j++;
                }
            }
            Ui.println((j + 1) + ") Back");
            while (true) {//Make it easy to break, without going back to main store menu

                int menuItem = Ui.getValidInt();

                try { //This is probably pretty bad practice. Using exceptions as a functional part of the program.. Use variables!

                    //choices other than options in the array go here:
                    if (menuItem == (j + 1) || menuItem > j)
                        return;

                    //reverts back to Weapon indexing
                    menuItem--;
                    menuItem = menuItem + offset[menuItem];

                    //TODO once more status effects are implemented, use a switch here if appropriate.
                    //Testing to make sure the option is valid goes here:
                    if (arrayFood.get(menuItem).getStatusEffect() == StatusEffect.type.HEALTH && Health.get() == Health.getOutOf()) {
                        Ui.msg("Your health is already full. No need to eat this!");
                        return;
                    }

                    //Results go here:
                    if (arrayFood.get(menuItem).quantity > 0) {
                        Food.arrayFood.get(menuItem).eat();
                    }
                    return;

                } catch (Exception e) {
                    Ui.println();
                    Ui.println(menuItem + " is not an option.");
                }
            }
        }
    }

    /**
     *
     * @return name of food in players chest.
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return int the number of effect level points gained from food.
     */
    public int getEffectLevel() {
        return effectLevel;
    }

    /**
     *
     * @return status effects include: health, strength, stamina, accuracy and luck.
     */
    public StatusEffect.type getStatusEffect() {
        return statusEffect;
    }

    /**
     *
     * @return int quantity of food player has in their chest.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set quantity of food using a cheat.
     *
     * @param quantity = 5000 with cheat code "givemeitall"
     * @param quantity = 100 with cheat code "nomorepain"
     *@param quantity = 10 with cheat code "thirstforfood"
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Display player has eaten and what effects that has on player.
     */
    public void eat() {
        Ui.cls();

        Ui.println("You have ate a " + getName());
        Ui.println("You've gained " + effectLevel + " " + statusEffect.toString() + " points.");
        this.quantity--;
        totalEaten++;
        Ui.pause();

        switch (this.statusEffect) {
            case HEALTH:
                Health.gain(this.effectLevel);
                break;
            case STRENGTH:
                break;
            case STANIMA:
                break;
            case ACCURACY:
                break;
            case LUCK:
                break;
        }

    }

    /**
     * Displays Food information in the "Help" section.
     */
    public void viewAbout() {

        final int BORDER_LENGTH = 39;

        //End of food Info
        Ui.cls();
        for (int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//draw line
        Ui.println();
        for (int i = 0; i < ((BORDER_LENGTH / 2) - (this.getName().length() / 2)); i++)
            Ui.print(" ");//Set correct spacing to get name in middle of box
        Ui.println(this.getName());
        Ui.println(this.desc);
        Ui.println("Category: " + this.foodType.toString());
        Ui.println("Status effect type: " + this.statusEffect.toString());
        Ui.println("Status effect level: " + this.getEffectLevel());
        for (int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//draw line
        Ui.pause();
        Ui.cls();
        //End of food info
        this.setViewed(true);
    }

    /**
     * Unused method
     * @return boolean
     */
    public boolean viewedAbout() {
        return this.viewedAbout;
    }

    /**
     *
     * @param v if viewAbout() is used in the Help section, viewedAbout is set to true.
     *          if viewAbout() hasn't been seen in the Help section, viewAbout remains false.
     */
    public void setViewed(boolean v) {
        this.viewedAbout = v;
    }

    public enum type {
        MEAT_FISH,
        MEAT_OTHER,
        FRUIT,
        OTHER;

        @Override
        public String toString() {
            String effectString = super.toString();
            effectString = effectString.replace("_", " ");
            effectString = effectString.replace("MEAT", "");
            effectString = effectString.trim();
            return effectString.substring(0, 1) + effectString.substring(1).toLowerCase();
        }
    }
}

