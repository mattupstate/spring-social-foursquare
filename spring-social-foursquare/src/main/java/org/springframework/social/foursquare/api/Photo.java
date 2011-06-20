package org.springframework.social.foursquare.api;

import java.util.Date;

public class Photo {
	
	private String id;
	private Date createdAt;
	private String url;
	private PhotoSizes sizes;
	private PhotoSource source;
	private FoursquareUser user;
	
	public Photo(String id, Date createdAt, String url, PhotoSizes sizes, PhotoSource source, FoursquareUser user) {
		this.id = id;
		this.createdAt = createdAt;
		this.url = url;
		this.sizes = sizes;
		this.source = source;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getUrl() {
		return url;
	}

	public PhotoSizes getSizes() {
		return sizes;
	}

	public PhotoSource getSource() {
		return source;
	}

	public FoursquareUser getUser() {
		return user;
	}
	
}
