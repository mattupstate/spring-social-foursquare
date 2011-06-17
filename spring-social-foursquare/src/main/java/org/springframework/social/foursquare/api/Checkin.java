package org.springframework.social.foursquare.api;

import java.util.Date;

public class Checkin {
	
	private String id;
	private Date createdAt;
	private String type;
	private boolean mayor;
	private String timeZone;
	private Venue venue;
	
	public Checkin(String id, Date createdAt, String type, boolean mayor, String timeZone, Venue venue) {
		this.id = id;
		this.createdAt = createdAt;
		this.type = type;
		this.mayor = mayor;
		this.timeZone = timeZone;
		this.venue = venue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isMayor() {
		return mayor;
	}

	public void setMayor(boolean mayor) {
		this.mayor = mayor;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
}
