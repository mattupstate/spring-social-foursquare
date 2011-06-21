package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.VenueLinks;


public class VenueLinksContainerDeserializer extends AbstractFoursquareDeserializer<VenueLinksContainer> {
	@Override
	public VenueLinksContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		return new VenueLinksContainer(deserializeNestedResponseObject(jp, "links", VenueLinks.class));
	}
}
