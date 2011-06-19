package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.UserSearchResponse;

public class UserSearchResponseContainerDeserializer extends AbstractFoursquareDeserializer<UserSearchResponseContainer> {
    
    @Override
    public UserSearchResponseContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        
        return deserializeResponseObject(jp, UserSearchResponseContainer.class, UserSearchResponse.class);
    }
    
}
