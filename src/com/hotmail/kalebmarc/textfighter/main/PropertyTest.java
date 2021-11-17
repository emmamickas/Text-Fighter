package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PropertyTest {

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
	public void testDescription() {
		Property testProperty1 = new Property();
		Property testProperty2 = new Property();
		
		testProperty1.setDesc("New description of a property!");
		
		testProperty2.setDesc("A different description of a property!");
		
		assertEquals("New description of a property!", testProperty1.getDescription());
		
		assertEquals("A different description of a property!", testProperty2.getDescription());
		
		testProperty1.setDesc("Yet another description of a property!");
		
		testProperty2.setDesc("One more description of a property!");
		
		assertEquals("Yet another description of a property!", testProperty1.getDescription());
		
		assertEquals("One more description of a property!", testProperty2.getDescription());
	}

	@Test
	public void testPricePerSquareFoot() {
		Property testProperty1 = new Property();
		Property testProperty2 = new Property();
		
		testProperty1.setPricePerSquareFoot(10);
		
		testProperty2.setPricePerSquareFoot(20);
		
		assertEquals(10, testProperty1.getPricePerSquareFoot());
		
		assertEquals(20, testProperty2.getPricePerSquareFoot());
		
		testProperty1.setPricePerSquareFoot(15);
		
		testProperty2.setPricePerSquareFoot(25);
		
		assertEquals(15, testProperty1.getPricePerSquareFoot());
		
		assertEquals(25, testProperty2.getPricePerSquareFoot());
	}

	@Test
	public void testSquareFootOwned() {
		Property testProperty1 = new Property();
		Property testProperty2 = new Property();
		
		testProperty1.setSquareFeetOwned(50);
		
		testProperty2.setSquareFeetOwned(2000);
		
		assertEquals(50, testProperty1.getSquareFeetOwned());
		
		assertEquals(100, testProperty2.getSquareFeetOwned());
		
		testProperty1.setSquareFeetOwned(75);
		
		testProperty2.setSquareFeetOwned(80);
		
		assertEquals(75, testProperty1.getSquareFeetOwned());
		
		assertEquals(80, testProperty2.getSquareFeetOwned());
	}

}
