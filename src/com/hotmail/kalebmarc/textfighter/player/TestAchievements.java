package com.hotmail.kalebmarc.textfighter.player;
import com.google.common.annotations.VisibleForTesting;
import com.hotmail.kalebmarc.textfighter.main.*;

import static com.hotmail.kalebmarc.textfighter.player.Stats.kills;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class TestAchievements {


    @Test
    public void poorManTest() {
        // Testing Poor Man: run out of coins.
        Coins.set(0, true);
        assertEquals(0, Coins.get());

        String[] strAch = new String[5];
        if(Coins.get() == 0) {
            strAch[0] = "Poor Man";
        }

        assertEquals("Poor Man", strAch[0]);
    }

    @Test
    public void heatingUpTest() {
        // Test Heating Up: 3 monster kill streak.
        Stats.kills = 3;
        assertEquals(3, Stats.kills);

        String[] strAch = new String[5];
        if(Stats.kills == 3) {
            strAch[0] = "Heating Up";
        }

        assertEquals("Heating Up", strAch[0]);
    }

    @Test
    public void hesOnFireTest() {
        // Test He's On Fire!: 5 monster kill streak.
        Stats.kills = 5;
        assertEquals(5, Stats.kills);

        String[] strAch = new String[5];
        if(Stats.kills == 5) {
            strAch[0] = "He's On Fire!";
        }

        assertEquals("He's On Fire!", strAch[0]);
    }

    @Test
    public void fromDowntownTest() {
        // Test From downtown!: hit with one bullet.
        Stats.bulletsThatHit = 1;
        assertEquals(1, Stats.bulletsThatHit);

        String[] strAch = new String[5];
        if(Stats.bulletsThatHit == 1) {
            strAch[0] = "From downtown!";
        }

        assertEquals("From downtown!", strAch[0]);
    }

    @Test
    public void machineGunKellyTest() {
        // Test Machine Gun Kelly: 100 bullets hit.
        Stats.bulletsThatHit = 100;
        assertEquals(100, Stats.bulletsThatHit);

        String[] strAch = new String[5];
        if(Stats.bulletsThatHit == 100) {
            strAch[0] = "Machine Gun Kelly";
        }

        assertEquals("Machine Gun Kelly", strAch[0]);
    }

    @Test
    public void closeShaveTest() {
        // Test Close Shave!: enemy dies while fighter has 5 or less health.
        Enemy testEnemy = new Enemy("Dark Elf", 45, 10, 15, 10, 15, 15, 1, 100, true, false);
        testEnemy.setHealth(0, 45);
        Health.set(5);
        assertEquals(0, testEnemy.getHealth());
        assertEquals(5, Health.get());

        String[] strAch = new String[5];
        if(testEnemy.getHealth() <= 0 && Health.get() <= 5) {
            strAch[0] = "Close Shave!";
        }

        assertEquals("Close Shave!", strAch[0]);
    }

    @Test
    public void cheaterCheaterTest() {
        // Test Cheater! Cheater!: cheats enabled.
        Cheats.enable();
        assertTrue(!Cheats.locked());

        String[] strAch = new String[5];
        if(!Cheats.locked()) {
            strAch[0] = "Cheater! Cheater!";
        }

        assertEquals("Cheater! Cheater!", strAch[0]);
    }
}
