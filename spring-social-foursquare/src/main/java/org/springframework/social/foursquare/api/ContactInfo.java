package org.springframework.social.foursquare.api;

public class ContactInfo {
	
	private String email;
	private String twitter;
	private String phone;
	private String formattedPhone;
	
	public ContactInfo(String email, String twitter, String phone, String formattedPhone) {
		this.email = email;
		this.twitter = twitter;
		this.phone = phone;
		this.formattedPhone = formattedPhone;
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
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFormattedPhone() {
		return formattedPhone;
	}

	public void setFormattedPhone(String formattedPhone) {
		this.formattedPhone = formattedPhone;
	}

	
}
