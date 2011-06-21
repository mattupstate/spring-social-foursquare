package org.springframework.social.foursquare.api;

import java.util.List;

public class VenueGroupItem {
    private Reasons reasons;
    private Venue venue;
    private List<Tip> tips;
    
    public VenueGroupItem(Reasons reasons, Venue venue, List<Tip> tips) {
        this.reasons = reasons;
        this.venue = venue;
        this.tips = tips;
    }

    public Reasons getReasons() {
        return reasons;
    }

    public Venue getVenue() {
        return venue;
    }
    
    public List<Tip> getTips() {
        return tips;
    }
}
