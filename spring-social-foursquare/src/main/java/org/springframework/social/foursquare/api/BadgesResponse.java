package org.springframework.social.foursquare.api;

import java.util.Map;

public class BadgesResponse {
    
    private BadgeSets sets;
    private Map<String, Badge> badges;
    
    public BadgesResponse(BadgeSets sets, Map<String, Badge> badges) {
        this.sets = sets;
        this.badges = badges;
    }
    
    /**
     * Hierarchical groups of badge IDs or, for unlocked badges, badge unlock IDs, as they are 
     * intended for display. Badges may be repeated across groups, e.g. a unlocked partner badge 
     * may shop up under "all badges," "partner badges," and "Bravo badges."
     * @return BadgeSets
     */
    public BadgeSets getSets() {
        return sets;
    }
    
    /**
     * A map of badge ID or badge unlock ID to a badge. Unlocked badges will contain the checkin 
     * that led to it being unlocked (may eventually only be returned if the client asks for it) 
     * and the underlying badge ID.
     * @return
     */
    public Map<String, Badge> getBadges() {
        return badges;
    }
    
}
