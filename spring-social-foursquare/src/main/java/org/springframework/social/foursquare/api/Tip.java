package org.springframework.social.foursquare.api;

import java.util.Date;

public class Tip {
	
	private String id;
	private Date createdAt;
	private String text;
	private String status;
	private Venue venue;
	private FoursquareUser user;
	private TipTodoGroup todo;
	private TipTodoGroup done;
	
	public Tip(String id, Date createdAt, String text) {
		this.id = id;
		this.createdAt = createdAt;
		this.text = text;
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
	
	public TipTodoGroup getTodo() {
		return todo;
	}

	public TipTodoGroup getDone() {
		return done;
	}
}
