package com.hotmail.kalebmarc.textfighter.player;

import com.hotmail.kalebmarc.textfighter.main.Cheats;
import com.hotmail.kalebmarc.textfighter.main.Handle;
import com.hotmail.kalebmarc.textfighter.main.Ui;

import javax.swing.*;
/*
XP class determines a players level given the experience (xp) that they have gained throughout the game.
XP determines which items are available to the player in the shops.
 */
public class Xp {

	//Variables
    private static int xp;
    private static int battleXp;
    private static int xpNeeded;
    private static int level;
	public static int total;

    private Xp() {
    }

    /**
     * Every 500 xp, player moves to the next level.
     * 100 coins are rewarded.
     */
    private static void levelUp() {
        if (level == 9) {
            Ui.popup("You've reached level 10!\nYou have been rewarded 250 coins!", "Level Up!", JOptionPane.INFORMATION_MESSAGE);
            level = 10;
            Coins.set(250, true);

		}else if(level > 100){
			Handle.error("Error - Level is greater than 100");
            level = 100;
		}else if(level == 99){
            level = 100;
            xp = 49000;
        }else {

			Ui.popup("You've leveled up! You are now level " + (level + 1) + "!\nYou have been rewarded 100 coins!", "Level Up!", JOptionPane.INFORMATION_MESSAGE);
			xp = 0;
			xpNeeded += 500;
			level++;
            Coins.set(100, true);
		}
		Achievements.check();
	}

    /**
     * Setter for xp
     * @param amount amount to xp points
     * @param add if true amount is added to total xp, 
     *            if false amount is the total xp.
     */
	public static void set(int amount, boolean add) {

        if((level == 100) || Cheats.enabled()){
            return;
        }
        if (add){
            xp += amount;
            total += amount;
        } else {
            xp = amount;
        }
		if ((xp >= xpNeeded) && (xpNeeded != 0)){// (xpNeeded != 0) is so it doesn't try and level up when cheats are enabled (Which sets xp and xpNeeded to 0)
			int leftOverXp = xp - xpNeeded;
            levelUp();
            set(leftOverXp, true);
		}

	}
	/**
	 * battleXP is the xp accumulated from fighting enemies.
	 * Getter for battleXp
	 * @return int total battleXP
	 */
	public static int getBattleXp() {
		return battleXp;
	}
	
	/**
	 * Setter for battleXP.
	 * @param amount xp gained
	 * @param add if true amount is added to total battleXp, 
     *            if false amount is the total battleXp.
	 */
	public static void setBattleXp(int amount, boolean add) {
		if(add) {
			battleXp += amount;
		} else {
			battleXp = amount;
		}
	}

	/**
	 * Setter for the level user is on
	 * @param lvl level user is on.
	 */
	public static void setLevel(int lvl){
        level = lvl;
	}
/**
 * Setter for how many points needed to move to the next level
 * @param outOf total points needed to level up.
 */
	public static void setOutOf(int outOf){
		xpNeeded = outOf;
	}
	/**
	 * Setter for current, outOf, level.
	 * @param current amount of xp player has accumulated
	 * @param outOf total xp needed to to level up
	 * @param lvl players current level
	 */
	public static void setAll(int current, int outOf, int lvl){
        xp = current;
        xpNeeded = outOf;
        level = lvl;
    }
    /**
     * Getter for xp
     * @return players xp points
     */
    public static int get(){
        return xp;
    }
    
    /**
     * Getter for user xp needed to level up
     * @return xo points needed to level up
     */
    public static int getOutOf(){
        return xpNeeded;
    }
    /**
     * Getter for players current level
     * @return players current level
     */
    public static int getLevel(){
        return level;
    }
    /**
     * Creates a ratio of player xp.
     * @return XP/xpNeeded
     */
    public static String getFull(){
        return xp + "/" + xpNeeded + " xp";
    }
}