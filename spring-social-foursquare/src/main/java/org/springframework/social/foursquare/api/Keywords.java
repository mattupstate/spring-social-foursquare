package org.springframework.social.foursquare.api;

import java.util.List;

public class Keywords {
    private int count;
    private List<Keyword> items;
    
    public Keywords(int count, List<Keyword> items) {
        this.count = count;
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public List<Keyword> getItems() {
        return items;
    }
}
