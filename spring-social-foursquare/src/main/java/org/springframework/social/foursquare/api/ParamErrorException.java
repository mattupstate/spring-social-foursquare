package org.springframework.social.foursquare.api;

public class ParamErrorException extends FoursquareApiException {
	
	public ParamErrorException(int code, String errorType, String message) {
		super(code, errorType, message);
	}

	private static final long serialVersionUID = 1L;
	
}
