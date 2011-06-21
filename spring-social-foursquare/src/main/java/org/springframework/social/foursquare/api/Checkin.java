package org.springframework.social.foursquare.api;

import java.util.Date;

public class Checkin {
	
	private String id;
	private Date createdAt;
	private String type;
	private String shout;
	private boolean mayor;
	private String timeZone;
	private Venue venue;
	private Photos photos;
	
	public Checkin(String id, Date createdAt, String type, String timeZone, Venue venue) {
		this.id = id;
		this.createdAt = createdAt;
		this.type = type;
		this.timeZone = timeZone;
		this.venue = venue;
	}

	public String getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getType() {
		return type;
	}

	public boolean isMayor() {
		return mayor;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public Venue getVenue() {
		return venue;
	}

	public String getShout() {
		return shout;
	}

	public Photos getPhotos() {
		return photos;
	}
}
