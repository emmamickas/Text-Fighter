package com.hotmail.kalebmarc.textfighter.item;

public class QuestHealth {
	
	private int HealthMax;
    private int HealthMin;

    public QuestHealth(int healthMax, int healthMin) {
    	this.HealthMax = healthMax;
    	this.HealthMin = healthMin;
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
}
