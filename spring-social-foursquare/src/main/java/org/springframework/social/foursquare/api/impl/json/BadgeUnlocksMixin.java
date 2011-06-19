package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Checkin;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class BadgeUnlocksMixin {
    @JsonCreator
    BadgeUnlocksMixin(
            @JsonProperty("checkins") List<Checkin> checkins){}

}
