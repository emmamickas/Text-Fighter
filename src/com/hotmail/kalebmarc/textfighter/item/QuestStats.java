package com.hotmail.kalebmarc.textfighter.item;

public class QuestStats {
	
	private String Host;
	private int MinimumLevel;
	private boolean Completed;
	private boolean Available;
	
	public QuestStats(String host, int minLevel, boolean completed, boolean available) {
		
		this.Host = host;
		this.MinimumLevel = minLevel;
		this.Completed = completed;
		this.Available = available;
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

	public String getHost() {
		return Host;
	}

	public void setHost(String host) {
		Host = host;
	}
}
