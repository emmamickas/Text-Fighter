package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuestTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testMinLevelRequirement() {
		Quest testQuest1 = new Quest("Test host 1", 5, 10, 15, 30, 0, 50, 1, false, false);
		
		Quest testQuest2 = new Quest("Test host 2", 2, 8, 10, 20, 5, 25, 0, false, false);
		
		assertEquals(1, testQuest1.getMinLevelReq());

		assertEquals(0, testQuest2.getMinLevelReq());
	}

}
