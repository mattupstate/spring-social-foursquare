package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.BadgeImage;
import org.springframework.social.foursquare.api.BadgeUnlocks;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class BadgeMixin {
    @JsonCreator
    BadgeMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("image") BadgeImage image,
            @JsonProperty("unlocks") List<BadgeUnlocks> unlocks){}
}
