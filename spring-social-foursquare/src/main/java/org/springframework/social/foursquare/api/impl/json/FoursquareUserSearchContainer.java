package org.springframework.social.foursquare.api.impl.json;

import org.springframework.social.foursquare.api.UserSearchResults;

public class FoursquareUserSearchContainer {
    
    private final UserSearchResults results;
    
    public FoursquareUserSearchContainer(UserSearchResults results) {
        this.results = results;
    }
    
    public UserSearchResults getResults() {
        return results;
    }
}
