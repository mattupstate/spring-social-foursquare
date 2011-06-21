package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.Venue;

@JsonDeserialize(using=VenueSearchContainerDeserializer.class)
public class VenueSearchContainer {
    
    List<Venue> venues;
    
    public VenueSearchContainer(List<Venue> venues) {
        this.venues = venues;
    }

    public List<Venue> getVenues() {
        return venues;
    }
    
}
