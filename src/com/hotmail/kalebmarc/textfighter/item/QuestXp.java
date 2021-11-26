package com.hotmail.kalebmarc.textfighter.item;

public class QuestXp {
	
	private int XPMin;
	private int XPMax;

    
    public QuestXp(int xpMax, int xpMin) {
    	
    	this.XPMin = xpMin;
    	this.XPMax = xpMax;
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
}
