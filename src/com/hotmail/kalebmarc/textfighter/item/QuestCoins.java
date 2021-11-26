package com.hotmail.kalebmarc.textfighter.item;

public class QuestCoins {
	
	private int CoinMax;
    private int CoinMin;

    public QuestCoins(int coinMax, int coinMin) {
    	this.CoinMax = coinMax;
    	this.CoinMin = coinMin;
    }
    
    public int getCoinMin() {
		return CoinMin;
	}

	public void setCoinMin(int coinMin) {
		this.CoinMin = coinMin;
	}
	
	public int getCoinMax() {
		return CoinMax;
	}

	public void setCoinMax(int coinMax) {
		this.CoinMax = coinMax;
	}
}
