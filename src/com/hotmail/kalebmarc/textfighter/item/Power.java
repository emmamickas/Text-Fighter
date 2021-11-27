package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Enemy;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Xp;

public class Power {

    public static int used = 0;
    public static int price;
    public static int level;
    private static int powers;

    public static int get() {
        return powers;
    }

    public static void set(int amount, boolean add) {
        if (!add) {
            powers = amount;
        } else {
            powers += amount;
            if (powers < 0) powers = 0;
        }
    }

    public static void use() {

        Ui.cls();

        if (powers <= 0) {
            Ui.println("----------------------------------------------------");
            Ui.println("You have no POWER's left!");
            Ui.println("Go to the shop to buy some more.");
            Ui.println("----------------------------------------------------");
            Ui.pause();
        } else {
            powers--;
            used++;
            Xp.set(20, true);
            Enemy.get().takeDamage(Enemy.get().getHealth());
            Ui.println("----------------------------------------------------");
            Ui.println("You have used a POWER.");
            Ui.println("The enemy has instantly died.");
            Ui.println("----------------------------------------------------");
            Ui.println("Enemy Health: " + Enemy.get().getHeathStr());
            Ui.println("POWER's: " + powers);
            Ui.println("----------------------------------------------------");
            Ui.pause();
        }
    }
}
