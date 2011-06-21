package org.springframework.social.foursquare.api;

public class Keyword {
    private String displayName;
    private String keyword;
    
    public Keyword(String displayName, String keyword) {
        this.displayName = displayName;
        this.keyword = keyword;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getKeyword() {
        return keyword;
    }
    
}
