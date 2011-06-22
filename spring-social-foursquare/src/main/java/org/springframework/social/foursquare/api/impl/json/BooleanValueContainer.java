package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(using=BooleanValueContainerDeserializer.class)
public class BooleanValueContainer {
	private Boolean value;
	
	public BooleanValueContainer(Boolean value) {
		this.value = value;
	}
	
	public Boolean getValue() {
		return value;
	}
}
