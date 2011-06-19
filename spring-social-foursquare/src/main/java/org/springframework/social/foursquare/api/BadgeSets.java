package org.springframework.social.foursquare.api;

import java.util.List;

public class BadgeSets {
    
    private List<BadgeGroup> groups;
    
    public BadgeSets(List<BadgeGroup> groups) {
        this.groups = groups;
    }
    
    public List<BadgeGroup> getGroups() {
        return groups;
    }
}
