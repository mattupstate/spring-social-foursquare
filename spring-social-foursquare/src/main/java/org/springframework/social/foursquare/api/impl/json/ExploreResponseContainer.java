package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.ExploreResponse;

@JsonDeserialize(using=ExploreResponseContainerDeserializer.class)
public class ExploreResponseContainer {
    
    private ExploreResponse response;
    
    public ExploreResponseContainer(ExploreResponse response) {
        this.response = response;
    }
    
    public ExploreResponse getResponse() {
        return response;
    }
}
