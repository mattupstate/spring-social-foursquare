package org.springframework.social.foursquare.api.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.InsufficientPermissionException;
import org.springframework.social.InternalServerErrorException;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.RateLimitExceededException;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.social.foursquare.api.FoursquareApiException;
import org.springframework.social.foursquare.api.ParamErrorException;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class FoursquareErrorHandler extends DefaultResponseErrorHandler {
	
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
	    Map<String, Object> errorDetails = extractErrorDetailsFromResponse(response);
	    
	    int code = Integer.valueOf(String.valueOf(errorDetails.get("code"))).intValue();
        String errorType = String.valueOf(errorDetails.get("errorType"));
        String message = String.valueOf(errorDetails.get("errorDetail"));
        
        handleFoursquareError(code, errorType, message);
        
        throw new FoursquareApiException(code, errorType, message);		
	}
	
	@Override 
	public boolean hasError(ClientHttpResponse response) throws IOException {
		if(super.hasError(response)) {
			return true;
		}
		// only bother checking the body for errors if we get past the default error check
		String content = readFully(response.getBody());		
		return content.contains("\"errorType\":") || content.equals("false");
	}
	
	@SuppressWarnings("unchecked")
    private Map<String, Object> extractErrorDetailsFromResponse(ClientHttpResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        Map<String, Object> responseMap = mapper.<Map<String, Object>>readValue(response.getBody(), new TypeReference<Map<String, Object>>() {});
        if(responseMap.containsKey("meta")) {
            Map<String, Object> meta = (Map<String, Object>) responseMap.get("meta");
            if(Integer.valueOf(String.valueOf(meta.get("code"))).intValue() > 200) {
                return meta;
            }
        }
        return null;
    }
	
	private void handleFoursquareError(int code, String errorType, String message) {
		if(errorType.equals("invalid_auth")) {
			throw new NotAuthorizedException(message);
		} else if(errorType.equals("param_error")) {
			throw new ParamErrorException(code, errorType, message);
		} else if(errorType.equals("endpoint_error")) {
			throw new ResourceNotFoundException(message);
		} else if(errorType.equals("not_authorized")) {
			throw new InsufficientPermissionException(message);
		} else if(errorType.equals("rate_limit_exceeded")) {
			throw new RateLimitExceededException();
		} else if(errorType.equals("server_error")) {
			throw new InternalServerErrorException(message);
		}
	}
	
	private String readFully(InputStream in) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		while (reader.ready()) {
			sb.append(reader.readLine());
		}
		return sb.toString();
	}
}
