package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class AllSettingsMixin {
	@JsonCreator
	AllSettingsMixin(
			@JsonProperty("receivePings") boolean receivePings, 
			@JsonProperty("receiveCommentPings") boolean receiveCommentPings, 
			@JsonProperty("sendToTwitter") boolean sendToTwitter, 
			@JsonProperty("sendMayorshipsToTwitter") boolean sendMayorshipsToTwitter, 
			@JsonProperty("sendBadgesToTwitter") boolean sendBadgesToTwitter,
			@JsonProperty("sendToFacebook") boolean sendToFacebook, 
			@JsonProperty("sendMayorshipsToFacebook") boolean sendMayorshipsToFacebook, 
			@JsonProperty("sendBadgesToFacebook") boolean sendBadgesToFacebook, 
			@JsonProperty("foreignConsent") String foreignConsent){}
}
