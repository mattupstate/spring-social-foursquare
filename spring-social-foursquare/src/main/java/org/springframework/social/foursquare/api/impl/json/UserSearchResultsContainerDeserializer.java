package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.foursquare.api.UserSearchResults;

public class UserSearchResultsContainerDeserializer extends AbstractFoursquareDeserializer<UserSearchResultsContainer> {
    
    @Override
    public UserSearchResultsContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        
        return deserializeResponseObject(jp, UserSearchResultsContainer.class, UserSearchResults.class);
    }
    
}
