package org.springframework.social.foursquare.api.impl.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.foursquare.api.Badge;
import org.springframework.social.foursquare.api.BadgeGroup;
import org.springframework.social.foursquare.api.BadgeImage;
import org.springframework.social.foursquare.api.BadgeSets;
import org.springframework.social.foursquare.api.BadgeUnlocks;
import org.springframework.social.foursquare.api.BadgesResponse;
import org.springframework.social.foursquare.api.Category;
import org.springframework.social.foursquare.api.Checkin;
import org.springframework.social.foursquare.api.CheckinInfo;
import org.springframework.social.foursquare.api.ContactInfo;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.FriendGroup;
import org.springframework.social.foursquare.api.FriendInfo;
import org.springframework.social.foursquare.api.Friends;
import org.springframework.social.foursquare.api.Leaderboard;
import org.springframework.social.foursquare.api.LeaderboardItem;
import org.springframework.social.foursquare.api.Location;
import org.springframework.social.foursquare.api.MayorshipInfo;
import org.springframework.social.foursquare.api.Scores;
import org.springframework.social.foursquare.api.Tip;
import org.springframework.social.foursquare.api.Tips;
import org.springframework.social.foursquare.api.Todo;
import org.springframework.social.foursquare.api.Todos;
import org.springframework.social.foursquare.api.UserSearchResponse;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueStats;

public class FoursquareModule extends SimpleModule {

	public FoursquareModule() {
		super(FoursquareModule.class.getName(), new Version(1, 0, 0, null));
	}
	
	@Override 
	public void setupModule(SetupContext context) {
	    context.setMixInAnnotations(Badge.class, BadgeMixin.class);
	    context.setMixInAnnotations(BadgeGroup.class, BadgeGroupMixin.class);
	    context.setMixInAnnotations(BadgeImage.class, BadgeImageMixin.class);
	    context.setMixInAnnotations(BadgeSets.class, BadgeSetsMixin.class);
	    context.setMixInAnnotations(BadgesResponse.class, BadgesResponseMixin.class);
	    context.setMixInAnnotations(BadgeUnlocks.class, BadgeUnlocksMixin.class);
	    context.setMixInAnnotations(Category.class, CategoryMixin.class);
		context.setMixInAnnotations(Checkin.class, CheckinMixin.class);
		context.setMixInAnnotations(CheckinInfo.class, CheckinInfoMixin.class);
		context.setMixInAnnotations(ContactInfo.class, ContactInfoMixin.class);
		context.setMixInAnnotations(FoursquareUser.class, FoursquareUserMixin.class);
		context.setMixInAnnotations(FriendGroup.class, FriendGroupMixin.class);
		context.setMixInAnnotations(FriendInfo.class, FriendInfoMixin.class);
		context.setMixInAnnotations(Friends.class, FriendsMixin.class);
		context.setMixInAnnotations(Leaderboard.class, LeaderboardMixin.class);
		context.setMixInAnnotations(LeaderboardItem.class, LeaderboardItemMixin.class);
		context.setMixInAnnotations(Location.class, LocationMixin.class);
		context.setMixInAnnotations(MayorshipInfo.class, MayorshipInfoMixin.class);
		context.setMixInAnnotations(Scores.class, ScoresMixin.class);
		context.setMixInAnnotations(Tip.class, TipMixin.class);
		context.setMixInAnnotations(Tips.class, TipsMixin.class);
		context.setMixInAnnotations(Todo.class, TodoMixin.class);
		context.setMixInAnnotations(Todos.class, TodosMixin.class);
		context.setMixInAnnotations(UserSearchResponse.class, UserSearchResponseMixin.class);
		context.setMixInAnnotations(Venue.class, VenueMixin.class);
		context.setMixInAnnotations(VenueStats.class, VenueStatsMixin.class);
	}
}
