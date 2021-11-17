package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VersionTest {

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
		assertEquals("" //Award for "worse game description" goes to:
            //But seriously; add information that the user actually cares about
            + "Text-Fighter is a Text-Based\n"
            + "Fighter RPG game, completely\n"
            + "written in Java.\n\n"
            + "Text-Fighter is currently in Alpha stage\n"
            + "which means it's still in early development,\n"
            + "and will contain lots of bugs and missing features.", Version.getDesc());
	}

}
