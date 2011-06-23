package org.springframework.social.foursquare.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.foursquare.api.Foursquare;

public class FoursquareConnectionFactory extends OAuth2ConnectionFactory<Foursquare> {

    public FoursquareConnectionFactory(String clientId, String clientSecret) {
        super("foursquare", new FoursquareServiceProvider(clientId, clientSecret), new FoursquareAdapter());
    }
    
}
