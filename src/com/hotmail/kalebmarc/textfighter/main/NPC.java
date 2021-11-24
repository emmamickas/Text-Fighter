package com.hotmail.kalebmarc.textfighter.main;

//import Quest;

public class NPC {

    private static final String NAME_HEALTH = "Corinna";
    private static final String NAME_WEAPON = "Niel";
    private static final String NAME_XP = "Halette";
    private static final String NAME_ARMOUR = "Leon";
    private static final String NAME_PROPERTY = "Hazel";
    private static String name;
    private static String shop;


    public NPC() {
    }

    /**
     * View the name of the NPC based on the type of NPC it is
     * @param type
     * @return the NPC's name
     */
    public static String getName(String type) {
        switch (type.toLowerCase()) {
            case "health":
                return NAME_HEALTH;

            case "weapon":
                return NAME_WEAPON;

            case "xp":
                return NAME_XP;

            case "armour":
                return NAME_ARMOUR;

            case "property":
                return NAME_PROPERTY;

            default:
                return "This shop does not exist.";
        }
    }

    /**
     * Gets the NPC's shop based on the name of the NPC
     * @param npc
     * @return
     */
    public static String getShop(String npc) {//TODO use constants instead of names
        switch (npc.toLowerCase()) {
            case "corinna":
                shop = "Health";
                break;
            case "niel":
                shop = "Weapon";
                break;
            case "halette":
                shop = "XP";
                break;
            case "leon":
                shop = "Armour";
                break;
            case "hazel":
                shop = "Property";
            default:
                shop = "This NPC does not exist.";
        }
        return shop;
    }

    public static void setName(String npc) {
        name = npc;
    }

    public static void setShop(String type) {
        shop = type;
    }

    /**
     * Shows the NPC's welcome based on the type of NPC
     * @param type
     */
    public static void welcome(String type) {
        Ui.println(getName(type) + ": \n\tWelcome to the " + type + " shop.");
        Ui.println("\tHow can I help you today?");
    }

    /**
     * Shows the NPC's thanks for purchase based on the type of NPC
     * @param type
     */
    public static void gratitude(String shop, String type) {
        if (type.toLowerCase().equals("purchase")) {
            Ui.println(getName(shop) + ": \nThank you for your purchase.");
        }

    }

    public boolean hasQuests() {
        return Quest.checkQuestsForNPC(name);
    }

}
