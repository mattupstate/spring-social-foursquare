package org.springframework.social.foursquare.api;

import java.util.List;

public class BadgeGroup {
    
    private String type;
    private String name;
    private List<String> items;
    private List<BadgeGroup> groups;
    private BadgeImage image;
    
    public BadgeGroup(String type, String name, List<String> items, List<BadgeGroup> groups) {
        this.type = type;
        this.name = name;
        this.items = items;
        this.groups = groups;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<String> getItems() {
        return items;
    }

    public List<BadgeGroup> getGroups() {
        return groups;
    }

    public BadgeImage getImage() {
        return image;
    }
}
