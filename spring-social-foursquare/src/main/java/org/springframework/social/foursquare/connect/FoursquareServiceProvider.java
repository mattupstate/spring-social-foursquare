package org.springframework.social.foursquare.connect;

import org.springframework.social.foursquare.api.Foursquare;
import org.springframework.social.foursquare.api.impl.FoursquareTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public class FoursquareServiceProvider extends AbstractOAuth2ServiceProvider<Foursquare> {
    
    private final String clientId;
    private final String clientSecret;
    
    public FoursquareServiceProvider(String clientId, String clientSecret) {
        super(new FoursquareOAuth2Template(clientId, clientSecret));
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }
    
    public Foursquare getApi(String accessToken) {
        return new FoursquareTemplate(clientId, clientSecret, accessToken);
    }

}
