package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.Venue;

public class VenueContainerDeserializer extends AbstractFoursquareDeserializer<VenueContainer> {
	@Override
	public VenueContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new VenueContainer(deserializeNestedResponseObject(jp, "venue", Venue.class));
	}
}
