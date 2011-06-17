package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Venue;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VenueList {
	
	private List<Venue> list;
	
	public VenueList(@JsonProperty("items") List<Venue> list) {
		this.list = list;
	}
	
	public List<Venue> getList() {
		return list;
	}

}
