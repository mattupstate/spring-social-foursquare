package org.springframework.social.foursquare.api;

public class ContactInfo {
	
	private String email;
	private String twitter;
	
	public ContactInfo(String email, String twitter) {
		this.email = email;
		this.twitter = twitter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	
}
