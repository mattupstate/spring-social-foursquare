package org.springframework.social.foursquare.api;

import java.util.HashMap;
import java.util.Map;

public class ExploreQuery {
    
    public static enum Section { FOOD, DRINKS, COFFEE, SHOPS, ARTS }
    public static enum Basis { ME, FRIENDS }
    
    private Double latitude; 
    private Double longitude; 
    private Double locationAccuracy; 
    private Double altitude;
    private Double altitudeAccuracy;
    private Integer radius; 
    private Section section; 
    private String query;
    private Integer limit;
    private Basis basis;
    
    public ExploreQuery() {
        
    }
    
    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public ExploreQuery location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        return this;
    }
    public Double getLocationAccuracy() {
        return locationAccuracy;
    }
    public ExploreQuery locationAccuracy(Double locationAccuracy) {
        this.locationAccuracy = locationAccuracy;
        return this;
    }
    public Double getAltitude() {
        return altitude;
    }
    public ExploreQuery altitude(Double altitude) {
        this.altitude = altitude;
        return this;
    }
    public Double getAltitudeAccuracy() {
        return altitudeAccuracy;
    }
    public ExploreQuery altitudeAccuracy(Double altitudeAccuracy) {
        this.altitudeAccuracy = altitudeAccuracy;
        return this;
    }
    public Integer getRadius() {
        return radius;
    }
    public ExploreQuery radius(Integer radius) {
        this.radius = radius;
        return this;
    }
    public Section getSection() {
        return section;
    }
    public ExploreQuery section(Section section) {
        this.section = section;
        return this;
    }
    public String getQuery() {
        return query;
    }
    public ExploreQuery query(String query) {
        this.query = query;
        return this;
    }
    public Integer getLimit() {
        return limit;
    }
    public ExploreQuery limit(Integer limit) {
        this.limit = limit;
        return this;
    }
    public Basis getBasis() {
        return basis;
    }
    public ExploreQuery basis(Basis basis) {
        this.basis = basis;
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
        if (radius != null) {
            params.put("radius", radius.toString());
        }
        if (section != null) {
            params.put("section", section.toString().toLowerCase());
        }
        if (query != null) {
            params.put("query", query);
        }
        if (limit != null) {
            params.put("limit", limit.toString());
        }
        if (basis != null) {
            params.put("basis", basis.toString().toLowerCase());
        }
        return params;
    }
}
