package com.hotmail.kalebmarc.textfighter.item;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Xp;

class FirstAidTest {

	@Test
	void tesBuyt() {
        Xp.setLevel(0);
        Coins.set(0, false);
        FirstAid.level = 10;
        FirstAid.price = 50;
		FirstAid.buy();
		assertEquals(0, FirstAid.get()); // Test when user isn't at high enough level
		FirstAid.level = 0;
		FirstAid.price = 50;
		FirstAid.buy();
		assertEquals(0, FirstAid.get()); // Test when user doesn't have enough coins
		FirstAid.level = 0;
		FirstAid.price = 0;
		FirstAid.buy();
		assertEquals(1, FirstAid.get()); // Test user can purchase
	}

}
