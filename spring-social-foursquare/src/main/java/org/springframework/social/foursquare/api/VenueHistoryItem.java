package org.springframework.social.foursquare.api;

public class VenueHistoryItem {
	
	private int beenHere;
	private Venue venue;
	
	public VenueHistoryItem(int beenHere, Venue venue) {
		this.beenHere = beenHere;
		this.venue = venue;
	}

	public int getBeenHere() {
		return beenHere;
	}

	public Venue getVenue() {
		return venue;
	}
	
}
