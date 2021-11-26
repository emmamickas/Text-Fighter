package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.Armour;
import com.hotmail.kalebmarc.textfighter.player.Xp;

import java.util.ArrayList;

public class Quest {

	private static ArrayList<Quest> QuestList = new ArrayList<>();
    //Available Armour/Weapon reward for Quest
    private final ArrayList<Armour> rewardArmours = new ArrayList<>();
    private final ArrayList<Weapon> rewardWeapons = new ArrayList<>();
    //NPC that provides the quest
    private String host;
    //Rewards
    private int coinRewardMin;
    private int coinRewardMax;
    private int xpRewardMin;
    private int xpRewardMax;
    private int healthRewardMin;
    private int healthRewardMax;
    //Requirements
    private int minLevelReq;
    private boolean completed;
    private boolean available;

    // This constructor takes a parameter of the QuestBuilder class that helps building a quest object.
    public Quest(QuestBuilder parameterObject) {

        this.host = parameterObject.getHost();
        this.coinRewardMin = parameterObject.getCoinMin();
        this.coinRewardMax = parameterObject.getCoinMax();
        this.xpRewardMin = parameterObject.getXpMin();
        this.xpRewardMax = parameterObject.getXpMax();
        this.healthRewardMin = parameterObject.getHealthMin();
        this.healthRewardMax = parameterObject.getHealthMax();
        this.minLevelReq = parameterObject.getMinimumLevel();
        this.completed = parameterObject.getCompleted();
        this.available = parameterObject.getAvailable();
        QuestList.add(this);
    }

    public static boolean checkQuestsForNPC(String npcName) {
        boolean check = false;
        int i = 0;
        do {
            if (QuestList.get(i).host.equalsIgnoreCase(npcName) && QuestList.get(i).getMinLevelReq() <= Xp.getLevel() && QuestList.get(i).getAvailable()) {
                        check = !QuestList.get(i).getComplete();
            }

            i++;

        } while ((i < QuestList.size()) || (check));
        return check;
    }

    public int getMinLevelReq() {
        return minLevelReq;
    }

    public boolean getComplete() {
        return completed;
    }

    public boolean getAvailable() {
        return available;
    }
    
    public ArrayList<Quest> getQuestList(){
    	return QuestList;
    }
    
    public void clearQuests() {
    	QuestList.clear();
    }
    
    public int getCoinRewardMax() {
    	return coinRewardMax;
    }
    
    public int getCoinRewardMin() {
    	return coinRewardMin;
    }
    
    public int getXpRewardMax() {
    	return xpRewardMax;
    }
    
    public int getXpRewardMin() {
    	return xpRewardMin;
    }
    
    public int getHealthRewardMax() {
    	return healthRewardMax;
    }
    
    public int getHealthRewardMin() {
    	return healthRewardMin;
    }

	public ArrayList<Armour> getRewardArmours() {
		return rewardArmours;
	}

	public ArrayList<Weapon> getRewardWeapons() {
		return rewardWeapons;
	}
}
