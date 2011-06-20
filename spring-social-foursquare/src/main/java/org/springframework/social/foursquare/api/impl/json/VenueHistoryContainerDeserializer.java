package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.VenueHistory;

public class VenueHistoryContainerDeserializer extends AbstractFoursquareDeserializer<VenueHistoryContainer> {
	@Override
	public VenueHistoryContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		return new VenueHistoryContainer(deserializeNestedResponseObject(jp, "venues", VenueHistory.class));
	}
}
