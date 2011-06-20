package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.VenueHistory;

@JsonDeserialize(using=VenueHistoryContainerDeserializer.class)
public class VenueHistoryContainer {
	
	private VenueHistory venueHistory;
	
	public VenueHistoryContainer(VenueHistory venueHistory) {
		this.venueHistory = venueHistory;
	}

	public VenueHistory getVenueHistory() {
		return venueHistory;
	}
	
}
