package org.springframework.social.foursquare.api;

public class Reason {
    private String type;
    private String message;
    
    public Reason(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
