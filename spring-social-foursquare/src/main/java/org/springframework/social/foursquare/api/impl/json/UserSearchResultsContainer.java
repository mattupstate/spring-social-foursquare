package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.UserSearchResults;

@JsonDeserialize(using=UserSearchResultsContainerDeserializer.class)
public class UserSearchResultsContainer {
    
    private UserSearchResults results;
    
    public UserSearchResultsContainer(UserSearchResults results) {
        this.results = results;
    }
    
    public UserSearchResults getResults() {
        return results;
    }
}
