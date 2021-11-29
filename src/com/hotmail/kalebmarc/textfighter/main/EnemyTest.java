package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.player.Xp;

public class EnemyTest {
	
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
	
	static ArrayList<Enemy> possibleEnemy;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        darkElf = new Enemy("Dark Elf", 45, 10, 15, 10, 15, 15, 5, 99, true, false);
        ninja = new Enemy("Ninja", 75, 5, 15, 5, 15, 15, 1, 10, true, false);
        giantSpider = new Enemy("Giant Spider", 35, 5, 10, 5, 10, 10, 5, 99, true, false);
        zombie = new Enemy("Zombie", 20, 5, 15, 5, 15, 15, 1, 10, true, false);
        goblin = new Enemy("Goblin", 60, 10, 20, 10, 20, 20, 1, 10, true, false);
        ghost = new Enemy("Ghost", 85, 15, 25, 15, 25, 25, 1, 99, true, false);
        barbarian = new Enemy("Barbarian", 50, 5, 15, 5, 15, 15, 5, 99, true, false);
        giantAnt = new Enemy("Giant Ant", 30, 5, 10, 5, 10, 10, 1, 10, true, false);
        evilUnicorn = new Enemy("Evil Unicorn", 35, 30, 40, 5, 15, 20, 5, 99, true, false);
        ogre = new Enemy("Ogre", 90, 20, 50, 10, 30, 50, 5, 99, true, false);
        
        possibleEnemy = new ArrayList<>();
        
        possibleEnemy.add(darkElf);
        possibleEnemy.add(ninja);
        possibleEnemy.add(giantSpider);
        possibleEnemy.add(zombie);
        possibleEnemy.add(ghost);
        possibleEnemy.add(barbarian);
        possibleEnemy.add(giantAnt);
        possibleEnemy.add(evilUnicorn);
        possibleEnemy.add(ogre);
        
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
	public void testSet() {
        
        Xp.setLevel(1);
        Enemy.set(1); 		
		assertTrue(Enemy.get() instanceof Enemy); 		
		assertEquals(ninja.getName(), Enemy.get().getName()); 
        
        Xp.setLevel(15); 
        Enemy.set(0); 
		assertTrue(Enemy.get() instanceof Enemy);
		
		assertEquals(darkElf.getName(), Enemy.get().getName()); 
        
	}

	@Test
	public void testGet() {
        
        Xp.setLevel(1);        
        Enemy.encounterNew(); 		
		assertTrue(Enemy.get() instanceof Enemy); 		
		assertTrue(possibleEnemy.contains(Enemy.get()));
        	
	}



	@Test
	public void testFindEnemy() {
        
        Xp.setLevel(1);     
        Enemy.findEnemy(); 	
		assertTrue(Enemy.get() instanceof Enemy); 	
        ArrayList<Enemy> enemy = new ArrayList<Enemy>();       
        enemy.add(ninja);
        enemy.add(zombie);
        enemy.add(goblin);
        enemy.add(ghost);
        enemy.add(giantAnt);		
		assertTrue(enemy.contains(Enemy.get())); 

	}


}