package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.foursquare.api.Checkin;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CheckinList {
	
	private List<Checkin> list;
	
	public CheckinList(@JsonProperty("items") List<Checkin> list) {
		this.list = list;
	}
	
	public List<Checkin> getList() {
		return list;
	}
}
