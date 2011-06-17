package org.springframework.social.foursquare.api;

public class Scores {
	
	private int recent;
	private int max;
	private int checkinsCount;
	
	public Scores(int recent, int max, int checkinsCount) {
		this.recent = recent;
		this.max = max;
		this.checkinsCount = checkinsCount;
	}

	public int getRecent() {
		return recent;
	}
	
	public int getMax() {
		return max;
	}
	
	public int getCheckinsCount() {
		return checkinsCount;
	}

}
