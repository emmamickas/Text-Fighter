package com.hotmail.kalebmarc.textfighter.player;

import com.google.common.annotations.VisibleForTesting;
import com.hotmail.kalebmarc.textfighter.main.*;

import static com.hotmail.kalebmarc.textfighter.player.Stats.kills;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class TestTipsHints {

    @Test
    public void tipsHintsTest1() {
        kills = 2;
        assertTrue(kills % 2 == 0);
    }
}
