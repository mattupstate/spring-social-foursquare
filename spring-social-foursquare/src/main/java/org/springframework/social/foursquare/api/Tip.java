package org.springframework.social.foursquare.api;

import java.util.Date;

public class Tip {
	
	private String id;
	private Date createdAt;
	private String text;
	private String status;
	private Venue venue;
	private FoursquareUser user;
	
	public Tip(String id, Date createdAt, String text, String status, Venue venue, FoursquareUser user) {
		this.id = id;
		this.createdAt = createdAt;
		this.text = text;
		this.status = status;
		this.venue = venue;
		this.user = user;
	}

	public String getId() {
		return id;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public String getText() {
		return text;
	}

	public String getStatus() {
		return status;
	}

	public Venue getVenue() {
		return venue;
	}

	public FoursquareUser getUser() {
		return user;
	}
}
