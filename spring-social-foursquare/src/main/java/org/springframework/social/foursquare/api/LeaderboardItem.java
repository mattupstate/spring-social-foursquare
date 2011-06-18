package org.springframework.social.foursquare.api;

public class LeaderboardItem {
    
    private int rank;
    private Scores scores;
    private FoursquareUser user;
    
    public LeaderboardItem(FoursquareUser user, int rank, Scores scores) {
        this.user = user;
        this.rank = rank;
        this.scores = scores;
    }

    public int getRank() {
        return rank;
    }

    public Scores getScores() {
        return scores;
    }

    public FoursquareUser getUser() {
        return user;
    } 
}
