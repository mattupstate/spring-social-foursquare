package org.springframework.social.foursquare.api;

public class CheckinSource {
	
	private String name;
	private String url;
	
	public CheckinSource(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
}
