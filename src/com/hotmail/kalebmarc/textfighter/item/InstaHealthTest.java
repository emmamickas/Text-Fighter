package com.hotmail.kalebmarc.textfighter.item;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Xp;

class InstaHealthTest {


	
	@Test
	void testBuy() {
        Xp.setLevel(1);
        Coins.set(0, false);
        InstaHealth.level = 3;
        InstaHealth.price = 50;
		InstaHealth.buy();
		assertEquals(0, InstaHealth.get()); // Test when user isn't at high enough level
        InstaHealth.level = 0;
        InstaHealth.price = 50;
		InstaHealth.buy();
		assertEquals(0, InstaHealth.get()); // Test when user doesn't have enough coins
        InstaHealth.level = 0;
        InstaHealth.price = 0;
		InstaHealth.buy();
		assertEquals(1, InstaHealth.get()); // Test user can purchase instaHealth
		
	}

}
