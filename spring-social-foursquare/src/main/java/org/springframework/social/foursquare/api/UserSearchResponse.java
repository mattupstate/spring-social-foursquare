package org.springframework.social.foursquare.api;

import java.util.List;
import java.util.Map;

public class UserSearchResponse {
    
    private final List<FoursquareUser> results;
    private Map<String, Object> unmatched;
    
    public UserSearchResponse(List<FoursquareUser> results, Map<String, Object> unmatched) {
        this.results = results;
        this.unmatched = unmatched;
    }

    public List<FoursquareUser> getResults() {
        return results;
    }

    public Map<String, Object> getUnmatched() {
        return unmatched;
    }
    
}
