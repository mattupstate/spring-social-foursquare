package org.springframework.social.foursquare.api;

import java.util.List;

public class Venue {
	
	private String id;
	private String name;
	private ContactInfo contactInfo;
	private Location location;
	private List<Category> categories;
	private boolean verified;
	private VenueStats stats;
	
	public Venue(String id, String name, ContactInfo contactInfo, Location location, List<Category> categories,
			boolean verified, VenueStats stats) {
		this.id = id;
		this.name = name;
		this.contactInfo = contactInfo;
		this.location = location;
		this.categories = categories;
		this.verified = verified;
		this.stats = stats;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public VenueStats getStats() {
		return stats;
	}

	public void setStats(VenueStats stats) {
		this.stats = stats;
	}
}
