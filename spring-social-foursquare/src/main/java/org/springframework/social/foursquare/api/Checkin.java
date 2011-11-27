package org.springframework.social.foursquare.api;

import java.util.Date;

public class Checkin {
	
	private String id;
	private FoursquareUser user;
	private Date createdAt;
	private String type;
	private String shout;
	private boolean mayor;
	private String timeZone;
	private Venue venue;
	private Photos photos;
	private CheckinSource source;
	private CheckinCommentInfo comments;
	
	public Checkin(String id, FoursquareUser user, Date createdAt, String type, String timeZone, 
			Venue venue, CheckinSource source, CheckinCommentInfo comments) {
		this.id = id;
		this.user = user;
		this.createdAt = createdAt;
		this.type = type;
		this.timeZone = timeZone;
		this.venue = venue;
		this.source = source;
		this.comments = comments;
	}

	public String getId() {
		return id;
	}
	
	public FoursquareUser getUser() {
		return user;
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
	
	public CheckinSource getSource() {
		return source;
	}
	
	public CheckinCommentInfo getComments() {
		return comments;
	}
}
