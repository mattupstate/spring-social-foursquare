package org.springframework.social.foursquare.api;

import java.util.List;

public class CheckinInfo {
	
	private int total;
	private List<Checkin> recentCheckins;
	
	public CheckinInfo(int total, List<Checkin> recentCheckins) {
		this.total = total;
		this.recentCheckins = recentCheckins;
	}

	public int getTotal() {
		return total;
	}

	public List<Checkin> getRecentCheckins() {
		return recentCheckins;
	}
	
}
