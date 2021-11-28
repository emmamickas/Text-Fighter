package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Xp;

class ShopTest {


	@Test
	void testPurchase() {
        Xp.setLevel(0);
        Coins.set(0, false);
        assertTrue(Shop.purchase(0, 0)); // Test user can purchase
        assertFalse(Shop.purchase(1, 0)); // Test user can purchase because they aren't at a high enough level
        assertFalse(Shop.purchase(0, 1)); // Test user can purchase because they don't have enough coins
	}

}
