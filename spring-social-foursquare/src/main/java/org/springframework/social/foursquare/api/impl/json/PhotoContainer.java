package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.Photo;

@JsonDeserialize(using=PhotoContainerDeserializer.class)
public class PhotoContainer {
	private Photo photo;
	
	public PhotoContainer(Photo photo) {
		this.photo = photo;
	}
	
	public Photo getPhoto() {
		return photo;
	}
}
