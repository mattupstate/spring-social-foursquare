package org.springframework.social.foursquare.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class CheckinParams {
	
	private String venueId;
	private String venue;
	private String shout;
	private String broadcast;
	private Double latitude;
	private Double longitude;
	private Long locationAccuracy;
	private Double altitude;
	private Long altitudeAccuracy;
	
	public CheckinParams() {
		
	}
	
	public String getVenueId() {
		return venueId;
	}
	public CheckinParams venueId(String venueId) {
		this.venueId = venueId;
		return this;
	}
	public String getVenue() {
		return venue;
	}
	public CheckinParams venue(String venue) {
		this.venue = venue;
		return this;
	}
	public String getShout() {
		return shout;
	}
	public CheckinParams shout(String shout) {
		this.shout = shout;
		return this;
	}
	public String getBroadcast() {
		return broadcast;
	}
	public CheckinParams broadcast(String broadcast) {
		this.broadcast = broadcast;
		return this;
	}
	public Double getLatitude() {
		return latitude;
	}
	public CheckinParams latitude(Double latitude) {
		this.latitude = latitude;
		return this;
	}
	public Double getLongitude() {
		return longitude;
	}
	public CheckinParams longitude(Double longitude) {
		this.longitude = longitude;
		return this;
	}
	public long getLocationAccuracy() {
		return locationAccuracy;
	}
	public CheckinParams locationAccuracy(Long locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
		return this;
	}
	public Double getAltitude() {
		return altitude;
	}
	public CheckinParams altitude(Double altitude) {
		this.altitude = altitude;
		return this;
	}
	public long getAltitudeAccuracy() {
		return altitudeAccuracy;
	}
	public CheckinParams altitudeAccuracy(Long altitudeAccuracy) {
		this.altitudeAccuracy = altitudeAccuracy;
		return this;
	}
	
	public MultiValueMap<String,Object> toParams() {
		MultiValueMap<String,Object> params = new LinkedMultiValueMap<String, Object>();
		if(venueId != null) {
			params.add("venueId", venueId);
		}
		if(venue != null) {
			params.add("venue", venue);
		}
		if(shout != null) {
			params.add("shout", shout);
		}
		if(broadcast != null) {
			params.add("broadcast", broadcast);
		}
		if (latitude != null && longitude != null) {
            params.add("ll", latitude.toString() + "," + longitude.toString());
        }
        if (locationAccuracy != null) {
            params.add("llAcc", locationAccuracy.toString());
        }
        if (altitude != null) {
            params.add("alt", altitude.toString());
        }
        if (altitudeAccuracy != null) {
            params.add("altAcc", altitudeAccuracy.toString());
        }
		return params;
	}
	
}
