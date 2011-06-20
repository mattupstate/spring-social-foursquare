package org.springframework.social.foursquare.api;

import java.util.Date;

public class Todo {
	
	private String id;
	private Date createdAt;
	private Tip tip;
	
	public Todo(String id, Date createdAt, Tip tip) {
		this.id = id;
		this.createdAt = createdAt;
		this.tip = tip;
	}

	public String getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Tip getTip() {
		return tip;
	}

}
