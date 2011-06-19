package org.springframework.social.foursquare.api;

import java.util.List;

public class Badge {
    private String id;
    private String name;
    private String description;
    private BadgeImage image;
    private List<BadgeUnlocks> unlocks;
    
    public Badge(String id, String name, String description, BadgeImage image, List<BadgeUnlocks> unlocks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.unlocks = unlocks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BadgeImage getImage() {
        return image;
    }

    public List<BadgeUnlocks> getUnlocks() {
        return unlocks;
    }
}
