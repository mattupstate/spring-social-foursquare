package org.springframework.social.foursquare.api;

import java.util.HashMap;
import java.util.Map;

public class VenueSearchParams {

    public static enum Intent {
        CHECKIN, MATCH, SPECIALS
    }

    private Double latitude;
    private Double longitude;
    private Double locationAccuracy;
    private Double altitude;
    private Double altitudeAccuracy;
    private String query;
    private Integer limit;
    private Intent intent;
    private String categoryId;
    private String url;
    private String providerId;
    private String linkedId;

    public String getLinkedId() {
        return linkedId;
    }

    public VenueSearchParams linkedId(String linkedId) {
        this.linkedId = linkedId;
        return this;
    }

    public String getProviderId() {
        return providerId;
    }

    public VenueSearchParams providerId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public VenueSearchParams categoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public VenueSearchParams url(String url) {
        this.url = url;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public VenueSearchParams location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        return this;
    }

    public Double getLocationAccuracy() {
        return locationAccuracy;
    }

    public VenueSearchParams locationAccuracy(Double locationAccuracy) {
        this.locationAccuracy = locationAccuracy;
        return this;
    }

    public Double getAltitude() {
        return altitude;
    }

    public VenueSearchParams altitude(Double altitude) {
        this.altitude = altitude;
        return this;
    }

    public Double getAltitudeAccuracy() {
        return altitudeAccuracy;
    }

    public VenueSearchParams altitudeAccuracy(Double altitudeAccuracy) {
        this.altitudeAccuracy = altitudeAccuracy;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public VenueSearchParams query(String query) {
        this.query = query;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public VenueSearchParams limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Intent getBasis() {
        return intent;
    }

    public VenueSearchParams basis(Intent intent) {
        this.intent = intent;
        return this;
    }

    public Map<String, String> toParameters() {
        Map<String, String> params = new HashMap<String, String>();
        if (latitude != null && longitude != null) {
            params.put("ll", latitude.toString() + "," + longitude.toString());
        }
        if (locationAccuracy != null) {
            params.put("llAcc", locationAccuracy.toString());
        }
        if (altitude != null) {
            params.put("alt", altitude.toString());
        }
        if (altitudeAccuracy != null) {
            params.put("altAcc", altitudeAccuracy.toString());
        }
        if (query != null) {
            params.put("query", query);
        }
        if (limit != null) {
            params.put("limit", limit.toString());
        }
        if (intent != null) {
            params.put("intent", intent.toString().toLowerCase());
        }
        if (categoryId != null) {
            params.put("categoryId", categoryId);
        }
        if (url != null) {
            params.put("url", url);
        }
        if (providerId != null) {
            params.put("providerId", providerId);
        }
        if (linkedId != null) {
            params.put("linkedId", linkedId);
        }
        return params;
    }

}
