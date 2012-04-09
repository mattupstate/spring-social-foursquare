package org.springframework.social.foursquare.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.foursquare.api.Foursquare;
import org.springframework.social.foursquare.api.FoursquareUser;


/**
 * Foursquare ApiAdapter implementation.
 */
public class FoursquareAdapter implements ApiAdapter<Foursquare> {

    public boolean test(Foursquare foursquare) {
        try {
            foursquare.userOperations().getUser();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    public void setConnectionValues(Foursquare foursquare, ConnectionValues values) {
        FoursquareUser user = foursquare.userOperations().getUser();
        values.setProviderUserId(user.getId());
        values.setDisplayName(user.getFirstName() + " " + user.getLastName());
        values.setImageUrl(user.getPhotoUrl());
    }

    public UserProfile fetchUserProfile(Foursquare instagram) {
        FoursquareUser user = instagram.userOperations().getUser();
        String name = user.getFirstName() + " " + user.getLastName();
        String email = user.getContactInfo().getEmail();
        return new UserProfileBuilder().setName(name).setUsername(email).setEmail(email).build();
    }

    public void updateStatus(Foursquare foursquare, String message) {
        // Unimplemented
    }

}