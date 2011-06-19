package org.springframework.social.foursquare.api;

import java.util.List;
import java.util.Map;

public class UserSearchResults {
    
    private final List<FoursquareUser> results;
    private Map<String, Object> unmatched;
    
    public UserSearchResults(List<FoursquareUser> results, Map<String, Object> unmatched) {
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
