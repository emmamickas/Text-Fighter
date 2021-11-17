package com.hotmail.kalebmarc.textfighter.player;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HealthTest {

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
	public void testGetString() {
		
		Health.set(0, 0);
		
		assertEquals("0/0", Health.getStr());
		
		Health.set(90, 100);
		assertEquals("90/100", Health.getStr());
		
		Health.set(100, 100);
		assertEquals("100/100", Health.getStr());
	}

	@Test
	public void testGet() {
		
		Health.set(0, 0);
		
		assertEquals(0, Health.get());
		
		Health.set(90, 100);
		assertEquals(90, Health.get());
		
		Health.set(100, 100);
		assertEquals(100, Health.get());
	}

	@Test
	public void testSet() {
		
		Health.set(0, 0);
		
		assertEquals("0/0", Health.getStr());
		
		Health.set(90, 100);
		assertEquals("90/100", Health.getStr());
		assertEquals(90, Health.get());
		
		Health.set(100, 100);
		assertEquals("100/100", Health.getStr());
		assertEquals(100, Health.get());
	}

	@Test
	public void testGain() {
		
		Health.set(0, 100);
		
		assertEquals("0/100", Health.getStr());
		
		Health.gain(5);
		assertEquals("5/100", Health.getStr());
		assertEquals(5, Health.get());

		Health.gain(50);
		assertEquals("55/100", Health.getStr());
		assertEquals(55, Health.get());
	}

}
