package org.springframework.social.foursquare.api;

import java.util.List;

public class Reasons {
    private int count;
    private List<Reason> items;
    
    public Reasons(int count, List<Reason> items) {
        this.count = count;
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public List<Reason> getItems() {
        return items;
    }
}
