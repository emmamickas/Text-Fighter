package com.hotmail.kalebmarc.textfighter.player;

import com.hotmail.kalebmarc.textfighter.main.Casino;
import com.hotmail.kalebmarc.textfighter.main.Cheats;
import com.hotmail.kalebmarc.textfighter.main.Enemy;
import com.hotmail.kalebmarc.textfighter.main.Ui;

import javax.swing.*;
import java.util.ArrayList;

public class Achievements {
    //Arrays for achievements
    public static final ArrayList<Boolean> arrayKilled = new ArrayList<>();
    private static final ArrayList<Enemy> arrayEnemy = new ArrayList<>();
    /* Achievements
     * 22 Total
     *
     * Booleans to check if the
     * achievement has been unlocked
     */
    public static boolean moneyMaker = false;
    public static boolean enemySlayer = false;
    public static boolean firstKill = false;
    public static boolean timeForAnUpgrade = false;
    public static boolean textFighterMaster = false;
    public static boolean YAYPOWER = false;
    public static boolean awwYouCareAboutMe = false;
    public static boolean slayer = false;
    public static boolean nobodysPerfect = false;
    public static boolean makingMoney = false;
    public static boolean gamblingAddiction = false;
    public static boolean unnaturalLuck = false;
    public static boolean level2Fighter = false;
    public static boolean level3Fighter = false;
    public static boolean level4Fighter = false;
    public static boolean level5Fighter = false;
    public static boolean level6Fighter = false;
    public static boolean level7Fighter = false;
    public static boolean level8Fighter = false;
    public static boolean level9Fighter = false;
    public static boolean level10Fighter = false;
    public static boolean honestPlayer = false;
    //Variables for testing the achievements
    //Time for an upgrade
    public static boolean boughtItem = false;
    //Aww, You Care About Me
    public static boolean viewedAbout = false;

    private Achievements() {
    }

    public static void setUpEnemyAchievement(String name, Enemy type) {

        arrayKilled.add(false);
        arrayEnemy.add(type);

    }

    public static void view() {

        //Displays which achievements the user has gotten
        Ui.cls();

        boolean[] achievementsGained = new boolean[22];
        String[] stringAchievements = new String[22];
        achievementsGained[0] = moneyMaker;
        stringAchievements[0] = "Money Maker";

        achievementsGained[1] = enemySlayer;
        stringAchievements[1] = "Enemy Slayer";

        achievementsGained[2] = firstKill;
        stringAchievements[2] = "First Kill";

        achievementsGained[3] = timeForAnUpgrade;
        stringAchievements[3] = "Time For An Upgrade";

        achievementsGained[4] = textFighterMaster;
        stringAchievements[4] = "Text-Fighter Master";

        achievementsGained[5] = YAYPOWER;
        stringAchievements[5] = "YAY POWER!";

        achievementsGained[6] = awwYouCareAboutMe;
        stringAchievements[6] = "Aww, You Care About Me :')";

        achievementsGained[7] = slayer;
        stringAchievements[7] = "Slayer";

        achievementsGained[8] = nobodysPerfect;
        stringAchievements[8] = "Nobodys Perfect";

        achievementsGained[9] = makingMoney;
        stringAchievements[9] = "Making Money";

        achievementsGained[10] = gamblingAddiction;
        stringAchievements[10] = "Gambling Addiction";

        achievementsGained[11] = level2Fighter;
        stringAchievements[11] = "Level 2 Fighter!";

        achievementsGained[12] = level3Fighter;
        stringAchievements[12] = "Level 3 Fighter!";

        achievementsGained[13] = level4Fighter;
        stringAchievements[13] = "Level 4 Fighter!";

        achievementsGained[14] = level5Fighter;
        stringAchievements[14] = "Level 5 Fighter!";

        achievementsGained[15] = level6Fighter;
        stringAchievements[15] = "Level 6 Fighter!";

        achievementsGained[16] = level7Fighter;
        stringAchievements[16] = "Level 7 Fighter!";

        achievementsGained[17] = level8Fighter;
        stringAchievements[17] = "Level 8 Fighter!";

        achievementsGained[18] = level9Fighter;
        stringAchievements[18] = "Level 9 Fighter!";

        achievementsGained[19] = level10Fighter;
        stringAchievements[19] = "Level 10 Fighter!";

        achievementsGained[20] = honestPlayer;
        stringAchievements[20] = "Honest Player";

        achievementsGained[21] = unnaturalLuck;
        stringAchievements[21] = "Unnatural Luck";

        Ui.println("---------------------------------------");
        Ui.println("Achievements");
        Ui.println();
        Ui.println("Unlocked Achievements:");
        Ui.println();
        for (int i = 0; i < achievementsGained.length; i++) {
            if (achievementsGained[i]) {
                Ui.println(stringAchievements[i]);
            }
        }
        //Enemy
        for (int i = 0; i < arrayEnemy.size(); i++) {
            if (arrayKilled.get(i)) {
                Ui.println("Goodbye, " + arrayEnemy.get(i).getName() + "!");
            }
        }
        Ui.println();
        Ui.println("Locked Achievements:");
        Ui.println();
        for (int i = 0; i < achievementsGained.length; i++) {
            if (!achievementsGained[i]) {
                Ui.println(stringAchievements[i]);
            }
        }
        //Enemy
        for (int i = 0; i < arrayEnemy.size(); i++) {
            if (!arrayKilled.get(i)) {
                Ui.println("Goodbye, " + arrayEnemy.get(i).getName() + "!");
            }
        }
        Ui.println();
        Ui.println("---------------------------------------");

        Ui.pause();
    }

    public static void check() {

        //Tests achievements if not already unlocked

        if (!Cheats.enabled()) {
            if (!moneyMaker) checkMoneyMaker();
            if (!enemySlayer) checkEnemySlayer();
            if (!firstKill) checkFirstKill();
            if (!timeForAnUpgrade) checkTimeForAnUpgrade();
            if (!textFighterMaster) checkTextFighterMaster();
            if (!YAYPOWER) checkYAYPOWER();
            if (!awwYouCareAboutMe) checkAwwYouCareAboutMe();
            if (!slayer) checkSlayer();
            if (!nobodysPerfect) checkNobodysPerfect();
            if (!makingMoney) checkMakingMoney();
            if (!gamblingAddiction) checkGamblingAddiction();
            if (!unnaturalLuck) checkUnnaturalLuck();
            if (!level2Fighter) checkLevel2Fighter();
            if (!level3Fighter) checkLevel3Fighter();
            if (!level4Fighter) checkLevel4Fighter();
            if (!level5Fighter) checkLevel5Fighter();
            if (!level6Fighter) checkLevel6Fighter();
            if (!level7Fighter) checkLevel7Fighter();
            if (!level8Fighter) checkLevel8Fighter();
            if (!level9Fighter) checkLevel9Fighter();
            if (!level10Fighter) checkLevel10Fighter();
            if (!honestPlayer) checkHonestPlayer();
            //Enemy achs get checked from textfighter.Enemy class
        }
    }

    public static void getEnemyAchievement(Enemy enemy) {
        if (!arrayKilled.get(arrayEnemy.indexOf(enemy))) {
            get("Goodbye, " + enemy.getName() + "!");
            arrayKilled.set(arrayEnemy.indexOf(enemy), true);
        }
    }

    private static void get(String achievement) {
        //Displays that you've gotten an achievement
        Ui.popup("You've got an achievement! \n\n" + achievement, "Achievement", JOptionPane.INFORMATION_MESSAGE);
        Xp.set(100, true);
    }

    private static void checkUnnaturalLuck() {
        if(Casino.LOTTERY.getJackpotWon()){
            unnaturalLuck = true;
            get("Unnatural Luck");
        }
    }

    private static void checkMoneyMaker() {
        if (Coins.get() >= 1500) {
            moneyMaker = true;
            get("Money Maker");
        }
    }

    private static void checkEnemySlayer() {
        if (Stats.totalKills >= 100) {
            enemySlayer = true;
            get("Enemy Slayer");
        }
    }

    private static void checkFirstKill() {
        if (Stats.totalKills >= 1) {
            firstKill = true;
            get("First Kill");
        }
    }

    private static void checkTimeForAnUpgrade() {
        if (boughtItem) {
            timeForAnUpgrade = true;
            get("Time for an Upgrade");
        }
    }

    private static void checkTextFighterMaster() {
        if (
                moneyMaker &&
                        enemySlayer &&
                        firstKill &&
                        timeForAnUpgrade &&
                        YAYPOWER &&
                        awwYouCareAboutMe &&
                        slayer &&
                        nobodysPerfect &&
                        makingMoney &&
                        gamblingAddiction &&
                        level2Fighter &&
                        level3Fighter &&
                        level4Fighter &&
                        level5Fighter &&
                        level6Fighter &&
                        level7Fighter &&
                        level8Fighter &&
                        level9Fighter &&
                        level10Fighter &&
                        honestPlayer
                ) {

            //Check Enemy Achs
            int temp = 0;
            for (int i = 0; i <= arrayEnemy.size(); i++) {
                if (arrayKilled.get(i)) {
                    temp++;
                }
            }
            if (temp < arrayEnemy.size()) {
                textFighterMaster = true;
                get("Text-Fighter Master\n Congratulations, you have gotten every achievement in Text Fighter! You've been awarded 2500 coins.");
                Coins.set(2500, true);
            }
        }
    }

    private static void checkYAYPOWER() {
        if (com.hotmail.kalebmarc.textfighter.item.Power.used >= 5) {
            YAYPOWER = true;
            get("YAY, POWER!!");
        }
    }

    private static void checkAwwYouCareAboutMe() {
        if (viewedAbout) {
            awwYouCareAboutMe = true;
            get("Aww, You Care About Me");
        }
    }

    private static void checkSlayer() {
        if (Stats.totalDamageDealt >= 1000) {
            slayer = true;
            get("Slayer");
        }
    }

    private static void checkNobodysPerfect() {
        if (Health.timesDied > 0) {
            nobodysPerfect = true;
            get("Nobodys Perfect");
        }
    }

    private static void checkMakingMoney() {
        if (Casino.totalCoinsWon >= 1000) {
            makingMoney = true;
            get("Making Money");
        }
    }

    private static void checkGamblingAddiction() {
        if (Casino.gamesPlayed >= 75) {
            gamblingAddiction = true;
            get("Gambling Addiction");
        }
    }

    private static void checkLevel2Fighter() {
        if (Xp.getLevel() == 2) {
            level2Fighter = true;
            get("Level 2 Fighter!");
        }
    }

    private static void checkLevel3Fighter() {
        if (Xp.getLevel() == 3) {
            level3Fighter = true;
            get("Level 3 Fighter!");
        }
    }

    private static void checkLevel4Fighter() {
        if (Xp.getLevel() == 4) {
            level4Fighter = true;
            get("Level 4 Fighter!");
        }
    }

    private static void checkLevel5Fighter() {
        if (Xp.getLevel() == 5) {
            level5Fighter = true;
            get("Level 5 Fighter!");
        }
    }

    private static void checkLevel6Fighter() {
        if (Xp.getLevel() == 6) {
            level6Fighter = true;
            get("Level 6 Fighter!");
        }
    }

    private static void checkLevel7Fighter() {
        if (Xp.getLevel() == 7) {
            level7Fighter = true;
            get("Level 7 Fighter!");
        }
    }

    private static void checkLevel8Fighter() {
        if (Xp.getLevel() == 8) {
            level8Fighter = true;
            get("Level 8 Fighter!");
        }
    }

    private static void checkLevel9Fighter() {
        if (Xp.getLevel() == 9) {
            level9Fighter = true;
            get("Level 9 Fighter!");
        }
    }

    private static void checkLevel10Fighter() {
        if (Xp.getLevel() == 10) {
            level10Fighter = true;
            get("Level 10 Fighter!");
        }
    }

    private static void checkHonestPlayer() {
        if (Cheats.locked()) {
            honestPlayer = true;
            get("Honest Player");
        }
    }
}