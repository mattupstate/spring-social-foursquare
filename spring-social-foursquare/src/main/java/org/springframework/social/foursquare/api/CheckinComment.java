package org.springframework.social.foursquare.api;

public class CheckinComment {
	private String id;
	private String text;
	
	public CheckinComment(String id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public String getId() {
		return id;
	}
	public String getText() {
		return text;
	}
}
