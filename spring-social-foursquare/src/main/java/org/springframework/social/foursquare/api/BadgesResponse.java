package org.springframework.social.foursquare.api;

import java.util.Map;

public class BadgesResponse {
    
    private BadgeSets sets;
    private Map<String, Badge> badges;
    
    public BadgesResponse(BadgeSets sets, Map<String, Badge> badges) {
        this.sets = sets;
        this.badges = badges;
    }
    
    public BadgeSets getSets() {
        return sets;
    }
    
    public Map<String, Badge> getBadges() {
        return badges;
    }
    
}
