package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(using=StringValueContainerDeserializer.class)
public class StringValueContainer {
	private String value;
	
	public StringValueContainer(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
