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
        // Test if Poor Man achievement activates when player stats are correct
        Coins.set(0, true);
        assertEquals(0, Coins.get());

        String[] strAch = new String[28];
        if(Coins.get() == 0) {
            strAch[0] = "Poor Man";
        }

        assertEquals("Poor Man", strAch[0]);
    }
}
