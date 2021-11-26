package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.QuestCoins;
import com.hotmail.kalebmarc.textfighter.item.QuestHealth;
import com.hotmail.kalebmarc.textfighter.item.QuestStats;
import com.hotmail.kalebmarc.textfighter.item.QuestXp;

public class QuestBuilder {
	private String Host;
	private int coinMin;
	private int coinMax;
	private int XPMin;
	private int XPMax;
	private int HealthMin;
	private int HealthMax;
	private int MinimumLevel;
	private boolean Completed;
	private boolean Available;

	public QuestBuilder(QuestCoins questCoins, QuestXp questXp, QuestHealth questHealth, QuestStats questStats) {
		this.coinMin = questCoins.getCoinMin();
		this.coinMax = questCoins.getCoinMax();
		this.XPMin = questXp.getXpMin();
		this.XPMax = questXp.getXpMax();
		this.HealthMin = questHealth.getHealthMin();
		this.HealthMax = questHealth.getHealthMax();
		this.Host = questStats.getHost();
		this.MinimumLevel = questStats.getMinimumLevel();
		this.Completed = questStats.getCompleted();
		this.Available = questStats.getAvailable();
	}

	
	public String getHost() {
		return Host;
	}

	public void setHost(String host) {
		this.Host = host;
	}

	public int getCoinMin() {
		return coinMin;
	}

	public void setCoinMin(int coinMin) {
		this.coinMin = coinMin;
	}

	public int getCoinMax() {
		return coinMax;
	}

	public void setCoinMax(int coinMax) {
		this.coinMax = coinMax;
	}
	
	public int getXpMin() {
		return XPMin;
	}

	public void setXpMin(int xpMin) {
		this.XPMin = xpMin;
	}
	
	public int getXpMax() {
		return XPMax;
	}

	public void setXpMax(int xpMax) {
		this.XPMax = xpMax;
	}

	public int getHealthMin() {
		return HealthMin;
	}

	public void setHealthMin(int healthMin) {
		this.HealthMin = healthMin;
	}

	public int getHealthMax() {
		return HealthMax;
	}

	public void setHealthMax(int healthMax) {
		this.HealthMax = healthMax;
	}

	public boolean getCompleted() {
		return Completed;
	}

	public void setCompleted(boolean completed) {
		Completed = completed;
	}

	public boolean getAvailable() {
		return Available;
	}

	public void setAvailable(boolean available) {
		Available = available;
	}

	public int getMinimumLevel() {
		return MinimumLevel;
	}

	public void setMinimumLevel(int minimumLevel) {
		MinimumLevel = minimumLevel;
	}
}
