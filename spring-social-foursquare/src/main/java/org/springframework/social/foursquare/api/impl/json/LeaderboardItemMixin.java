package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.Scores;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class LeaderboardItemMixin {
    @JsonCreator
    LeaderboardItemMixin(
            @JsonProperty("user") FoursquareUser user,
            @JsonProperty("rank") int rank,
            @JsonProperty("scores") Scores scores){}
}
