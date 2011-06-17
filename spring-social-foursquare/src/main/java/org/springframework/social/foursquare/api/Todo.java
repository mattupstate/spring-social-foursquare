package org.springframework.social.foursquare.api;

import java.util.Date;

public class Todo {
	
	private long id;
	private Date createdAt;
	private Tip tip;
	
	public Todo(long id, Date createdAt, Tip tip) {
		this.id = id;
		this.createdAt = createdAt;
		this.tip = tip;
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

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}
}
