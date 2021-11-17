package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RandomTest {

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
	public void testRandomInt() {
		assertTrue(Random.randomInt(10) <= 10);
		
		assertTrue(Random.randomInt(10) >= 0);
		
		assertTrue(Random.randomInt(5, 10) <= 10);
		
		assertTrue(Random.randomInt(5, 10) >= 5);
	}

}
