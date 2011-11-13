package org.springframework.social.foursquare.api.impl;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.social.InsufficientPermissionException;
import org.springframework.social.InternalServerErrorException;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.RateLimitExceededException;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.social.foursquare.api.FoursquareApiException;
import org.springframework.social.foursquare.api.ParamErrorException;

public class ErrorHandlingTest extends AbstractFoursquareApiTest {
	
	private String errorTemplate = "{\"meta\":{\"code\":400,\"errorType\": \"{error_type}\",\"errorDetail\": \"{error_detail}\"},\"response\":{}}";
	
	private String getErrorResponse(String type, String detail) {
		return errorTemplate.replace("{error_type}", type).replace("{error_detail}", detail);
	}
	
	@Test(expected=NotAuthorizedException.class)
	public void badRequest() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(getErrorResponse("invalid_auth", "Invalid authentication"), responseHeaders, HttpStatus.BAD_REQUEST, ""));
		
		foursquare.venueOperations().getVenue("VENUE_ID");
	}
	
	@Test(expected=ParamErrorException.class)
	public void paramError() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(getErrorResponse("param_error", "Invalid param"), responseHeaders, HttpStatus.BAD_REQUEST, ""));
		
		foursquare.venueOperations().getVenue("VENUE_ID");
	}
	
	@Test(expected=ResourceNotFoundException.class)
	public void endpointError() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(getErrorResponse("endpoint_error", "Endpoint error"), responseHeaders, HttpStatus.BAD_REQUEST, ""));
		
		foursquare.venueOperations().getVenue("VENUE_ID");
	}
	
	@Test(expected=InsufficientPermissionException.class)
	public void notAuthorized() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(getErrorResponse("not_authorized", "Not authorized"), responseHeaders, HttpStatus.BAD_REQUEST, ""));
		
		foursquare.venueOperations().getVenue("VENUE_ID");
	}
	
	@Test(expected=RateLimitExceededException.class)
	public void rateLimit() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(getErrorResponse("rate_limit_exceeded", "Rate limit"), responseHeaders, HttpStatus.BAD_REQUEST, ""));
		
		foursquare.venueOperations().getVenue("VENUE_ID");
	}
	
	@Test(expected=InternalServerErrorException.class)
	public void internalServerError() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(getErrorResponse("server_error", "Internal server error"), responseHeaders, HttpStatus.BAD_REQUEST, ""));
		
		foursquare.venueOperations().getVenue("VENUE_ID");
	}
	
	@Test(expected=FoursquareApiException.class)
	public void otherError() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20110609"))
			.andExpect(method(GET))
			.andRespond(withResponse(getErrorResponse("other", "Some other error"), responseHeaders, HttpStatus.BAD_REQUEST, ""));
		
		foursquare.venueOperations().getVenue("VENUE_ID");
	}

}
