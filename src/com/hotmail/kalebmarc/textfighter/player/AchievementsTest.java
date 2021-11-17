package com.hotmail.kalebmarc.textfighter.player;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.main.Enemy;

public class AchievementsTest {
	
	public static Enemy darkElf;
	public static Enemy ninja;
	public static Enemy giantSpider;
	public static Enemy zombie;
	public static Enemy goblin;
	public static Enemy ghost;
	public static Enemy barbarian;
	public static Enemy giantAnt;
	public static Enemy evilUnicorn;
	public static Enemy ogre;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        darkElf = new Enemy("Dark Elf", 45, 10, 15, 10, 15, 15, 5, 100, true, false);
        ninja = new Enemy("Ninja", 75, 5, 15, 5, 15, 15, 1, 10, true, false);
        giantSpider = new Enemy("Giant Spider", 35, 5, 10, 5, 10, 10, 5, 100, true, false);
        zombie = new Enemy("Zombie", 20, 5, 15, 5, 15, 15, 1, 10, true, false);
        goblin = new Enemy("Goblin", 60, 10, 20, 10, 20, 20, 1, 10, true, false);
        ghost = new Enemy("Ghost", 85, 15, 25, 15, 25, 25, 1, 100, true, false);
        barbarian = new Enemy("Barbarian", 50, 5, 15, 5, 15, 15, 5, 100, true, false);
        giantAnt = new Enemy("Giant Ant", 30, 5, 10, 5, 10, 10, 1, 10, true, false);
        evilUnicorn = new Enemy("Evil Unicorn", 35, 30, 40, 5, 15, 20, 5, 100, true, false);
        ogre = new Enemy("Ogre", 90, 20, 50, 10, 30, 50, 5, 100, true, false);
        
        Xp.setLevel(1);
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
	public void testSetUpEnemyAchievement() {
		
		assertEquals(Achievements.arrayKilled.get(0), false);
		assertEquals(Achievements.arrayKilled.get(1), false);
		assertEquals(Achievements.arrayKilled.get(2), false);
		assertEquals(Achievements.arrayKilled.get(3), false);
		assertEquals(Achievements.arrayKilled.get(4), false);
		assertEquals(Achievements.arrayKilled.get(5), false);
		assertEquals(Achievements.arrayKilled.get(6), false);
		assertEquals(Achievements.arrayKilled.get(7), false);
		assertEquals(Achievements.arrayKilled.get(8), false);
		assertEquals(Achievements.arrayKilled.get(9), false);
		
		Achievements.getEnemyAchievement(ninja);
		Achievements.getEnemyAchievement(goblin);
		Achievements.getEnemyAchievement(giantAnt);
		
		assertEquals(Achievements.arrayKilled.get(0), false);
		assertEquals(Achievements.arrayKilled.get(1), true);
		assertEquals(Achievements.arrayKilled.get(2), false);
		assertEquals(Achievements.arrayKilled.get(3), false);
		assertEquals(Achievements.arrayKilled.get(4), true);
		assertEquals(Achievements.arrayKilled.get(5), false);
		assertEquals(Achievements.arrayKilled.get(6), false);
		assertEquals(Achievements.arrayKilled.get(7), true);
		assertEquals(Achievements.arrayKilled.get(8), false);
		assertEquals(Achievements.arrayKilled.get(9), false);
	}

}
