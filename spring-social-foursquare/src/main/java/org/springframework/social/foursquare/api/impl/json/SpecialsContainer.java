package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.Specials;

@JsonDeserialize(using=SpecialsContainerDeserializer.class)
public class SpecialsContainer {
	private Specials specials;
	
	public SpecialsContainer(Specials specials) {
		this.specials = specials;
	}
	
	public Specials getSpecials() {
		return specials;
	}
}
