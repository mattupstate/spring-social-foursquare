package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.BadgesResponse;

@JsonDeserialize(using=BadgesResponseContainerDeserializer.class)
public class BadgesResponseContainer {
    
    private BadgesResponse response;
    
    public BadgesResponseContainer(BadgesResponse response) {
        this.response = response;
    }
    
    public BadgesResponse getResponse() {
        return response;
    }

}
