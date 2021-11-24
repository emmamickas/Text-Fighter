package com.hotmail.kalebmarc.textfighter.casino;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.casino.BlackjackGame.Card;

public class BlackjackGameTest {
	
	static BlackjackGame testGame;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		testGame = new BlackjackGame();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testResetCards() {
        
        testGame.ResetCards();
        
        int cardCounts[] = new int[12];
        
        for (int i = 0; i < testGame.cardStack.size(); i++)
        {
        	cardCounts[testGame.cardStack.elementAt(i).getValue()] += 1;
        }
        
        for (int i = 2; i < 12; i++)
        {
        	assertTrue(cardCounts[i] == 2);
        }
	}

}
