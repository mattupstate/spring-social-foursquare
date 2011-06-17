package org.springframework.social.foursquare.api.impl;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.foursquare.api.CheckinOperations;
import org.springframework.social.foursquare.api.Foursquare;
import org.springframework.social.foursquare.api.PhotoOperations;
import org.springframework.social.foursquare.api.SettingOperations;
import org.springframework.social.foursquare.api.SpecialOperations;
import org.springframework.social.foursquare.api.TipOperations;
import org.springframework.social.foursquare.api.UserOperations;
import org.springframework.social.foursquare.api.VenueOperations;
import org.springframework.social.foursquare.api.impl.json.FoursquareModule;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

public class FoursquareTemplate extends AbstractOAuth2ApiBinding implements Foursquare {

	private final String accessToken;
	private final String clientId;
	private final UserOperations userOperations;
	private final VenueOperations venueOperations;
	private final CheckinOperations checkinOperations;
	private final TipOperations tipOperations;
	private final PhotoOperations photoOperations;
	private final SettingOperations settingOperations;
	private final SpecialOperations specialOperations;
	
	public FoursquareTemplate(String clientId, String accessToken) {
		super(accessToken);
		this.clientId = clientId;
		this.accessToken = accessToken;
		
		MappingJacksonHttpMessageConverter json = new MappingJacksonHttpMessageConverter();
        json.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "javascript")));
		getRestTemplate().getMessageConverters().add(json);
		registerFoursquareJsonModule(getRestTemplate());
		getRestTemplate().setErrorHandler(new FoursquareErrorHandler());
		
		this.userOperations = new UserTemplate(this, true);
		this.venueOperations = new VenueTemplate();
		this.checkinOperations = new CheckinTemplate();
		this.tipOperations = new TipTemplate();
		this.photoOperations = new PhotoTemplate();
		this.settingOperations = new SettingTemplate();
		this.specialOperations = new SpecialTemplate();
	}
	
	private void registerFoursquareJsonModule(RestTemplate restTemplate) {
	    List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> converter : converters) {
            if(converter instanceof MappingJacksonHttpMessageConverter) {
                MappingJacksonHttpMessageConverter jsonConverter = (MappingJacksonHttpMessageConverter) converter;
                ObjectMapper objectMapper = new ObjectMapper();             
                objectMapper.registerModule(new FoursquareModule());
                jsonConverter.setObjectMapper(objectMapper);
            }
        }
	}
	
	public UserOperations userOperations() {
		return userOperations;
	}

	public VenueOperations venueOperations() {
		return venueOperations;
	}

	public CheckinOperations checkinOperations() {
		return checkinOperations;
	}

	public TipOperations tipOperations() {
		return tipOperations;
	}

	public PhotoOperations photoOperations() {
		return photoOperations;
	}

	public SettingOperations settingOperations() {
		return settingOperations;
	}

	public SpecialOperations specialOperations() {
		return specialOperations;
	}
	

	public URIBuilder withAccessToken(String uri) {
		return (accessToken == null) 
			? URIBuilder.fromUri(uri).queryParam("client_id", clientId)
			: URIBuilder.fromUri(uri).queryParam("access_token", accessToken);
	}
	
}
