package org.springframework.social.foursquare.api;

public class VenueLink {
	
	private Provider provider;
	private String linkedId;
	private String url;
	
	public VenueLink(Provider provider, String linkedId, String url) {
		this.provider = provider;
		this.linkedId = linkedId;
		this.url = url;
	}

	public Provider getProvider() {
		return provider;
	}

	public String getLinkedId() {
		return linkedId;
	}

	public String getUrl() {
		return url;
	}
}
