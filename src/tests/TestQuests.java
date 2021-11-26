package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hotmail.kalebmarc.textfighter.item.QuestCoins;
import com.hotmail.kalebmarc.textfighter.item.QuestHealth;
import com.hotmail.kalebmarc.textfighter.item.QuestStats;
import com.hotmail.kalebmarc.textfighter.item.QuestXp;
import com.hotmail.kalebmarc.textfighter.main.Quest;
import com.hotmail.kalebmarc.textfighter.main.QuestBuilder;

class TestQuests {

	@Test
	void TestBuildQuest() {
		QuestCoins questCoins = new QuestCoins(8 ,2);
		QuestXp questXp = new QuestXp(20, 10);
		QuestHealth questHealth = new QuestHealth(40, 30);
		QuestStats questStats = new QuestStats("Store Keeper", 3, false, true);
		QuestBuilder buildQuest = new QuestBuilder(questCoins, questXp, questHealth, questStats);
		Quest newQuest = new Quest(buildQuest);
		assertTrue(newQuest.getQuestList().size() != 0);
		assertEquals(4, newQuest.getQuestList().size());
		assertFalse(newQuest.getQuestList().size() == 3);
	}
	
	@Test
	void TestCoins() {
		QuestCoins questCoins = new QuestCoins(8 ,2);
		QuestXp questXp = new QuestXp(20, 10);
		QuestHealth questHealth = new QuestHealth(40, 30);
		QuestStats questStats = new QuestStats("Store Keeper", 3, false, true);
		QuestBuilder buildQuest = new QuestBuilder(questCoins, questXp, questHealth, questStats);
		Quest newQuest = new Quest(buildQuest);
		assertEquals(2, newQuest.getCoinRewardMin());
		assertEquals(8, newQuest.getCoinRewardMax());
		assertFalse(3 == newQuest.getCoinRewardMin());
	}
	
	@Test
	void TestXp() {
		QuestCoins questCoins = new QuestCoins(8 ,2);
		QuestXp questXp = new QuestXp(20, 10);
		QuestHealth questHealth = new QuestHealth(40, 30);
		QuestStats questStats = new QuestStats("Store Keeper", 3, false, true);
		QuestBuilder buildQuest = new QuestBuilder(questCoins, questXp, questHealth, questStats);
		Quest newQuest = new Quest(buildQuest);
		assertEquals(20, newQuest.getXpRewardMax());
		assertEquals(10, newQuest.getXpRewardMin());
		assertFalse(3 == newQuest.getXpRewardMin());
	}
	
	@Test
	void TestQuestHealth() {
		QuestCoins questCoins = new QuestCoins(8 ,2);
		QuestXp questXp = new QuestXp(20, 10);
		QuestHealth questHealth = new QuestHealth(40, 30);
		QuestStats questStats = new QuestStats("Store Keeper", 3, false, true);
		QuestBuilder buildQuest = new QuestBuilder(questCoins, questXp, questHealth, questStats);
		Quest newQuest = new Quest(buildQuest);
		assertEquals(40, newQuest.getHealthRewardMax());
		assertEquals(30, newQuest.getHealthRewardMin());
		assertFalse(3 == newQuest.getHealthRewardMin());
	}
}
