package org.springframework.social.foursquare.api;

import java.util.List;

public class MayorshipInfo {
	
	private int total;
	private List<Venue> venues;
	
	public MayorshipInfo(int total, List<Venue> venues) {
		this.total = total;
		this.venues = venues;
	}
	
	public int getTotal() {
		return total;
	}

	public List<Venue> getVenues() {
		return venues;
	}
}
