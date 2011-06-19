package org.springframework.social.foursquare.api;

import java.util.List;

public class BadgeUnlocks {
    
    private List<Checkin> checkins;
    
    public BadgeUnlocks(List<Checkin> checkins) {
        this.checkins = checkins;
    }
    
    public List<Checkin> getCheckins() {
        return checkins;
    }
}
