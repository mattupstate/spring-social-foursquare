package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.Venue;

@JsonDeserialize(using=VenueContainerDeserializer.class)
public class VenueContainer {
	private Venue venue;
	
	public VenueContainer(Venue venue) {
		this.venue = venue;
	}
	
	public Venue getVenue() {
		return venue;
	}
}
