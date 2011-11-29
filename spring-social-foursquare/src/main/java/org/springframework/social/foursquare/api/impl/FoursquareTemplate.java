package org.springframework.social.foursquare.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.client.ClientHttpRequestFactory;
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
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

public class FoursquareTemplate extends AbstractOAuth2ApiBinding implements Foursquare {

	private String accessToken;
	
	private String clientId;
	
	private String clientSecret;
	
	private UserOperations userOperations;
	
	private VenueOperations venueOperations;
	
	private CheckinOperations checkinOperations;
	
	private TipOperations tipOperations;
	
	private PhotoOperations photoOperations;
	
	private SettingOperations settingOperations;
	
	private SpecialOperations specialOperations;
	
	private ObjectMapper objectMapper;
	
	public FoursquareTemplate(String clientId, String clientSecret) {
		this(clientId, clientSecret, null);
	}
	
	public FoursquareTemplate(String clientId, String clientSecret, String accessToken) {
		super(accessToken);
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.accessToken = accessToken;
		initialize();
	}
	
	@Override
	public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
	}
	
	// AbstractOAuth2ApiBinding hooks
	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.DRAFT_10;
	}
	
	@Override
	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = super.getJsonMessageConverter();
		objectMapper = new ObjectMapper();				
		objectMapper.registerModule(new FoursquareModule());
		converter.setObjectMapper(objectMapper);		
		return converter;
	}
	
	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new FoursquareErrorHandler());
	}
	
	// private helpers
	private void initialize() {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();
	}
	
	private void initSubApis() {
		this.userOperations = new UserTemplate(this, isAuthorized());
		this.venueOperations = new VenueTemplate(this, isAuthorized());
		this.checkinOperations = new CheckinTemplate(this, isAuthorized());
		this.tipOperations = new TipTemplate(this, isAuthorized());
		this.photoOperations = new PhotoTemplate(this, isAuthorized());
		this.settingOperations = new SettingTemplate(this, isAuthorized());
		this.specialOperations = new SpecialTemplate(this, isAuthorized());
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
			? URIBuilder.fromUri(uri).queryParam("client_id", clientId).queryParam("client_secret", clientSecret)
			: URIBuilder.fromUri(uri).queryParam("oauth_token", accessToken);
	}
	
}
