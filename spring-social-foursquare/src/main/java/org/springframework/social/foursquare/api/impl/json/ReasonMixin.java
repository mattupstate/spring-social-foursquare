package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class ReasonMixin {
    @JsonCreator
    ReasonMixin(
            @JsonProperty("count") String type,
            @JsonProperty("items") String message){}
}
