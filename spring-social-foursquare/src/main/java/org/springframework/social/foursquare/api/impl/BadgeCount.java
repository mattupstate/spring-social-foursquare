package org.springframework.social.foursquare.api.impl;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BadgeCount {

	private int count;
	
	public BadgeCount(@JsonProperty("count") int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
}
