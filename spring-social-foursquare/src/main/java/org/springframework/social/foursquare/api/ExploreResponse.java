package org.springframework.social.foursquare.api;

import java.util.List;
import java.util.Map;

public class ExploreResponse {
    
    private Keywords keywords;
    private List<VenueGroup> groups;
    private Map<String,Object> warning;
    
    public ExploreResponse(Keywords keywords, List<VenueGroup> groups, Map<String,Object> warning) {
        this.keywords = keywords;
        this.groups = groups;
        this.warning = warning;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public List<VenueGroup> getGroups() {
        return groups;
    }

    public Map<String, Object> getWarning() {
        return warning;
    }
}
