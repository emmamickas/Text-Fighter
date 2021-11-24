package com.hotmail.kalebmarc.textfighter.main;

import javax.swing.*;

class About {
    private static boolean viewed = false;

    private About() {
    }

    /**
     * Shows user's version of the game. Sets view status for achievements.
     * @param isAchievementValid
     */
    public static void view(boolean isAchievementValid) {
        //Displays basic information
        Ui.popup("Text-Fighter " + Version.getFull() + "\n\n" + Version.getDescription(), "About", JOptionPane.INFORMATION_MESSAGE);

        //Displays the Change log (Pops-up after the basic information frame closes)
        Ui.popup("Text-Fighter " + Version.getFull() + " Change Log\n\n" + Version.getChange(), "Change Log", JOptionPane.INFORMATION_MESSAGE);

        if (isAchievementValid) {
            viewed = true;
        }
    }

    public static boolean viewed() {
        return viewed;
    }

    public static void setViewed(boolean hasBeenViewed) {
        viewed = hasBeenViewed;
    }

    public static boolean isEven(int check) {//TODO Remove when implementing JTools
        return ((check % 2) == 0);
    }
}
