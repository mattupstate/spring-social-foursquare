package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.VenuePhotos;

@JsonDeserialize(using=VenuePhotosContainerDeserializer.class)
public class VenuePhotosContainer {
	
	private VenuePhotos photos;
	
	public VenuePhotosContainer(VenuePhotos photos) {
		this.photos = photos;
	}

	public VenuePhotos getPhotos() {
		return photos;
	}
	
}
