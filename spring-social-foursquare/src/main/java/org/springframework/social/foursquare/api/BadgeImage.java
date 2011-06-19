package org.springframework.social.foursquare.api;

import java.util.List;

public class BadgeImage {
    
    private String prefix;
    private String name;
    private List<Integer> sizes;
    
    public BadgeImage(String prefix, String name, List<Integer> sizes) {
        this.prefix = prefix;
        this.name = name;
        this.sizes = sizes;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getSizes() {
        return sizes;
    }
}
