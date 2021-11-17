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
		
		assertEquals("New description of a property!", testProperty1.getDesc());
		
		assertEquals("A different description of a property!", testProperty2.getDesc());
		
		testProperty1.setDesc("Yet another description of a property!");
		
		testProperty2.setDesc("One more description of a property!");
		
		assertEquals("Yet another description of a property!", testProperty1.getDesc());
		
		assertEquals("One more description of a property!", testProperty2.getDesc());
	}

}
