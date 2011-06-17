package org.springframework.social.foursquare.api;

import java.util.Date;

public class Tip {
	
	private long id;
	private Date createdAt;
	private String text;
	private String status;
	private int todoCount;
	private int doneCount;
	private Venue venue;
	private FoursquareUser user;
	
	public Tip(long id, Date createdAt, String text, String status, int todoCount,
			int doneCount, Venue venue, FoursquareUser user) {
		this.id = id;
		this.createdAt = createdAt;
		this.text = text;
		this.status = status;
		this.todoCount = todoCount;
		this.doneCount = doneCount;
		this.venue = venue;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTodoCount() {
		return todoCount;
	}

	public void setTodoCount(int todoCount) {
		this.todoCount = todoCount;
	}

	public int getDoneCount() {
		return doneCount;
	}

	public void setDoneCount(int doneCount) {
		this.doneCount = doneCount;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public FoursquareUser getUser() {
		return user;
	}

	public void setUser(FoursquareUser user) {
		this.user = user;
	}
	
}
