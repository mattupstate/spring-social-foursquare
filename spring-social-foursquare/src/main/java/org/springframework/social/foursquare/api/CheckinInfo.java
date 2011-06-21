package org.springframework.social.foursquare.api;

import java.util.List;

public class CheckinInfo {
	
	private int total;
	private List<Checkin> checkins;
	
	public CheckinInfo(int total, List<Checkin> checkins) {
		this.total = total;
		this.checkins = checkins;
	}

	public int getTotal() {
		return total;
	}

	public List<Checkin> getCheckins() {
		return checkins;
	}
	
}
