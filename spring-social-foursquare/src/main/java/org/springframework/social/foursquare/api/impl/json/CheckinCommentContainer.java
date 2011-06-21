package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.foursquare.api.CheckinComment;

@JsonDeserialize(using=CheckinCommentContainerDeserializer.class)
public class CheckinCommentContainer {
	private CheckinComment comment;
	
	public CheckinCommentContainer(CheckinComment comment) {
		this.comment = comment;
	}

	public CheckinComment getComment() {
		return comment;
	}
}
