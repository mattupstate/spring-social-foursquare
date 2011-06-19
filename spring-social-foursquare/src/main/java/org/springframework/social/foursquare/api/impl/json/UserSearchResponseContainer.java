package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.UserSearchResponse;

@JsonDeserialize(using=UserSearchResponseContainerDeserializer.class)
public class UserSearchResponseContainer {
    
    private UserSearchResponse results;
    
    public UserSearchResponseContainer(UserSearchResponse results) {
        this.results = results;
    }
    
    public UserSearchResponse getResults() {
        return results;
    }
}
