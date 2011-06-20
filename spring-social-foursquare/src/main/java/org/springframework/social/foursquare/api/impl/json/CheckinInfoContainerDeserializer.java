package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.CheckinInfo;

public class CheckinInfoContainerDeserializer extends AbstractFoursquareDeserializer<CheckinInfoContainer> {
	@Override
	public CheckinInfoContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		return new CheckinInfoContainer(deserializeNestedResponseObject(jp, "checkins", CheckinInfo.class));
	}
}