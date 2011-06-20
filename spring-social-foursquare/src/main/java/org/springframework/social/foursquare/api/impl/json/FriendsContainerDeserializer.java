package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.Friends;

public class FriendsContainerDeserializer extends AbstractFoursquareDeserializer<FriendsContainer> {
	@Override
	public FriendsContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		return new FriendsContainer(deserializeNestedResponseObject(jp, "friends", Friends.class));
	}
}
