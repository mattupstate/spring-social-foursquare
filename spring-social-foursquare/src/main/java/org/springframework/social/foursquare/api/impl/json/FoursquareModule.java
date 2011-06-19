package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.foursquare.api.Category;
import org.springframework.social.foursquare.api.Checkin;
import org.springframework.social.foursquare.api.CheckinInfo;
import org.springframework.social.foursquare.api.ContactInfo;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.FriendGroup;
import org.springframework.social.foursquare.api.FriendInfo;
import org.springframework.social.foursquare.api.Leaderboard;
import org.springframework.social.foursquare.api.LeaderboardItem;
import org.springframework.social.foursquare.api.Location;
import org.springframework.social.foursquare.api.MayorshipInfo;
import org.springframework.social.foursquare.api.Scores;
import org.springframework.social.foursquare.api.Tip;
import org.springframework.social.foursquare.api.Todo;
import org.springframework.social.foursquare.api.UserSearchResults;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueStats;

public class FoursquareModule extends SimpleModule {

	public FoursquareModule() {
		super(FoursquareModule.class.getName(), new Version(1, 0, 0, null));
	}
	
	@Override 
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(Category.class, CategoryMixin.class);
		context.setMixInAnnotations(Checkin.class, CheckinMixin.class);
		context.setMixInAnnotations(CheckinInfo.class, CheckinInfoMixin.class);
		context.setMixInAnnotations(ContactInfo.class, ContactInfoMixin.class);
		context.setMixInAnnotations(FoursquareUser.class, FoursquareUserMixin.class);
		context.setMixInAnnotations(FriendGroup.class, FriendGroupMixin.class);
		context.setMixInAnnotations(FriendInfo.class, FriendInfoMixin.class);
		context.setMixInAnnotations(Leaderboard.class, LeaderboardMixin.class);
		context.setMixInAnnotations(LeaderboardItem.class, LeaderboardItemMixin.class);
		context.setMixInAnnotations(Location.class, LocationMixin.class);
		context.setMixInAnnotations(MayorshipInfo.class, MayorshipInfoMixin.class);
		context.setMixInAnnotations(Scores.class, ScoresMixin.class);
		context.setMixInAnnotations(Tip.class, TipMixin.class);
		context.setMixInAnnotations(Todo.class, TodoMixin.class);
		context.setMixInAnnotations(UserSearchResults.class, UserSearchResultsMixin.class);
		context.setMixInAnnotations(Venue.class, VenueMixin.class);
		context.setMixInAnnotations(VenueStats.class, VenueStatsMixin.class);
	}
}
