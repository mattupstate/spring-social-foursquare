package org.springframework.social.foursquare.api;

import java.util.List;

public class Leaderboard {
    
    private int count;
    private List<LeaderboardItem> items;
    
    public Leaderboard(int count, List<LeaderboardItem> items) {
        this.count = count;
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public List<LeaderboardItem> getItems() {
        return items;
    }
    
}
