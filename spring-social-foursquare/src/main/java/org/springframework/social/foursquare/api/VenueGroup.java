package org.springframework.social.foursquare.api;

import java.util.List;

public class VenueGroup {
    private String type;
    private String name;
    private List<VenueGroupItem> items;
    
    public VenueGroup(String type, String name, List<VenueGroupItem> items) {
        this.type = type;
        this.name = name;
        this.items = items;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<VenueGroupItem> getItems() {
        return items;
    }
}
