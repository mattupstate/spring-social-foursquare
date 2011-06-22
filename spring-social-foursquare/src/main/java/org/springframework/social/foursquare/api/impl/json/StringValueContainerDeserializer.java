package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;


public class StringValueContainerDeserializer extends AbstractFoursquareDeserializer<StringValueContainer> {
	@Override
	public StringValueContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		return new StringValueContainer(deserializeNestedResponseObject(jp, "message", String.class));
	}
}

